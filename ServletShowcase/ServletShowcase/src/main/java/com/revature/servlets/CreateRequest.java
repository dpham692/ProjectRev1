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
import com.revature.utils.DBUtils;
import com.revature.utils.MyUtils;
import com.revature.beans.UserAccount;
import com.revature.utils.DBUtils;
import com.revature.utils.MyUtils;
@WebServlet(urlPatterns = { "/createRequest" })
public class CreateRequest extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateRequest() {
        super();
    }
 
    //view the new request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createRequestView.jsp");
        dispatcher.forward(request, response);
    }
 
    //submit when call
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
        Connection conn = MyUtils.getStoredConnection(request);
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        String code = (String) request.getParameter("code");
        String name = loginedUser.getFirstname();
        String priceStr = (String) request.getParameter("price");
        String approval = "PENDING";
        Integer id = loginedUser.getId();
     
        float price = 0;
        try {
            price = Float.parseFloat(priceStr);
        } catch (Exception e) {
        }
        Product product = new Product(code, name, price,id,approval);
 
        String errorString = null;

      
 
        if (code == null || name == null || priceStr == null) {
            errorString = "Please input all the blank";
        }
 
        if (errorString == null) {
            try {
                DBUtils.insertProduct(conn, product);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
        
 
        List<Product> list = null;
 
        
 
        try {
            list = DBUtils.queryEmployeeProduct(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
     
 
      //save information after change to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);
 
        
     
 
        //to edit if error
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createRequestView.jsp");
            dispatcher.forward(request, response);
        }
        else {
        	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/requestEmployeeView.jsp");
            dispatcher.forward(request, response);    
        }
    }
 
}