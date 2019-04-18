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
 * Servlet implementation class ManagerInfoServlet
 */
@WebServlet("/managerInfo")
public class ManagerInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ManagerInfoServlet() {
        super();
    }
    //if user want to go to user info have to login first
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
 
        //check if user login or not
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
 
        //if login null
        if (loginedUser == null) {
            //redirect to login
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        //save information before forward
        request.setAttribute("user", loginedUser);
        //create employee list
        Connection conn = MyUtils.getStoredConnection(request);
        
        String errorString = null;
        List<UserAccount> list = null;
        try {
            list = DBUtils.queryUserAccount(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        //save information after change to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("userAccountList", list);
        //forward to
        // /WEB-INF/views/managerInfoView.jsp
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/managerInfoView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
