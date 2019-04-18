package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Product;
import com.revature.beans.UserAccount;
import com.revature.utils.DBUtils;
import com.revature.utils.MyUtils;

/**
 * Servlet implementation class RequestEmployeeServlet
 */
@WebServlet("/requestEmployee")
public class RequestEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public RequestEmployeeServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 HttpSession session = request.getSession();
    	 Connection conn = MyUtils.getStoredConnection(request);
    	 UserAccount loginedUser = MyUtils.getLoginedUser(session);
    	 Integer id = loginedUser.getId();
  
    	 List<Product> list = null;
  
         String errorString = null;
  
         try {
             list = DBUtils.queryEmployeeProduct(conn, id);
         } catch (SQLException e) {
             e.printStackTrace();
             errorString = e.getMessage();
         }
  
      
  
       //save information after change to views
         request.setAttribute("errorString", errorString);
         request.setAttribute("productList", list);
  
 
      
        // Forward to /WEB-INF/views/requestView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/requestEmployeeView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
