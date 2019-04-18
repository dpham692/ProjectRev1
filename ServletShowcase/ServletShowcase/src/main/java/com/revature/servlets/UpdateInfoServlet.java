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
 
import com.revature.beans.Product;
import com.revature.beans.UserAccount;
import com.revature.utils.DBUtils;
import com.revature.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/update" })
public class UpdateInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UpdateInfoServlet() {
        super();
    }
 
    //display the page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String username = (String) request.getParameter("username");
 
        UserAccount user = null;
 
        String errorString = null;
 
        try {
            user = DBUtils.findUserAccount(conn, username);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        //no user
        if (errorString != null && user == null) {
            response.sendRedirect(request.getServletPath() + "/productList");
            return;
        }
 
        //save change info
        request.setAttribute("errorString", errorString);
        request.setAttribute("user", user);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/updateInfoView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    //submit this will do
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String username = (String) request.getParameter("username");
        String address = (String) request.getParameter("address");
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        
        UserAccount user = new UserAccount(address,email,password,username);
 
        String errorString = null;
 
        try {
            DBUtils.updateUserAccount(conn, user);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        try {
			user = DBUtils.findUserAccount(conn, username);
		} catch (SQLException e) {
			System.out.println("Error find user");
			e.printStackTrace();
		}
        //post to request after view
        request.setAttribute("errorString", errorString);
        request.setAttribute("user", user);
 
        //if error when fix go back
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/updateInfoView.jsp");
            dispatcher.forward(request, response);
        }
        //if everything fine forward to product list
        else {
        	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
            dispatcher.forward(request, response);
        
        }
    }
 
}
