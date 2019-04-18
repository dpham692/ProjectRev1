package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import com.revature.beans.UserAccount;
import com.revature.utils.DBUtils;
import com.revature.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
 
    //display the login
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
      
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    //enter user and name and password and then this method will run
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//get username and password
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
     
     
 
        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                
                user = DBUtils.findUser(conn, userName, password);
 
                if (user == null) {
                    hasError = true;
                    errorString = "Username or password is invalid";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        //if error forward to login view
        if (hasError) {
            user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
 
           
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
          
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
            dispatcher.forward(request, response);
        }
       //if no error go to user info
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, user);
            
      
			/*
			 * if (remember) { MyUtils.storeUserCookie(response, user); }
			 * 
			 * else { MyUtils.deleteUserCookie(response); }
			 */
            if (user.getTitle().equalsIgnoreCase("Employee") )
            
            {
            	response.sendRedirect(request.getContextPath() + "/userInfo");
            }
            else
            {
            	response.sendRedirect(request.getContextPath() + "/managerInfo");
            }
            
        }
    }
 
}
