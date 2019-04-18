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
 * Servlet implementation class ApprovalServlet
 */
@WebServlet("/approval")
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApprovalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// view the new request
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/approvalView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection conn = MyUtils.getStoredConnection(request);
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		// this to pass to the approve product
		String requestidStr = (String) request.getParameter("requestid");
		String approval = (String) request.getParameter("approval");
		String managername = loginedUser.getFirstname();

		// this for to print out the list
		Integer id = loginedUser.getId();
		int requestid = 0;
		try {
			// parse the request id
			requestid = Integer.parseInt(requestidStr);
		} catch (Exception e) {
		}
		// create product and pass the approval and request id
		Product product = new Product(approval, managername, requestid);
		String errorString = null;
		if (requestidStr == null || approval == null) {
			errorString = "Please input all the blank";
		}

		if (errorString == null) {
			try {
				DBUtils.approveProduct(conn, product);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		
		List<Product> list = null;
        try {
            list = DBUtils.queryProduct(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
     
 
      //save information after change to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);
		 
		// to edit if error
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/approvalView.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/requestView.jsp");
			dispatcher.forward(request, response);
		}
	}

}
