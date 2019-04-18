package com.revature.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Product;
/*import com.revature.beans.Product;*/
import com.revature.beans.UserAccount;

public class DBUtils {
	// method for findUser in LoginServlet
	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select a.User_Id, a.User_Name, a.Password, a.Gender, a.Address, a.Email, a.Firstname, a.Lastname, a.Title from User_Account_DP a " //
				+ " where a.User_Name = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Integer id = rs.getInt("User_Id");
			String gender = rs.getString("Gender");
			String address = rs.getString("Address");
			String email = rs.getString("Email");
			String firstname = rs.getString("Firstname");
			String lastname = rs.getString("Lastname");
			String title = rs.getString("Title");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			user.setAddress(address);
			user.setEmail(email);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setTitle(title);
			user.setId(id);
			return user;
		}
		return null;
	}

	public static List<UserAccount> queryUserAccount(Connection conn) throws SQLException {
		String sql = "Select a.User_Name, a.Password, a.Gender, a.Address, a.Email, a.Firstname, a.Lastname from User_Account_DP a where a.Title = 'Employee'";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<UserAccount> list = new ArrayList<UserAccount>();
		while (rs.next()) {
			String userName = rs.getString("User_Name");
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			String address = rs.getString("Address");
			String email = rs.getString("Email");
			String firstname = rs.getString("Firstname");
			String lastname = rs.getString("Lastname");

			UserAccount user1 = new UserAccount();
			user1.setUserName(userName);
			user1.setPassword(password);
			user1.setGender(gender);
			user1.setAddress(address);
			user1.setEmail(email);
			user1.setFirstname(firstname);
			user1.setLastname(lastname);
			list.add(user1);
		}
		return list;
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.User_Id, a.Code, a.Name, a.Price, a.Approval, a.Managername, a.Request_Id from Product_DP a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			Integer id = rs.getInt("User_Id");
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			String approval = rs.getString("Approval");
			String managername = rs.getString("Managername");
			Integer requestid = rs.getInt("Request_Id");
			Product product = new Product();
			product.setAccount_id(id);
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			product.setApproval(approval);
			product.setManagername(managername);
			product.setRequestid(requestid);
			list.add(product);
		}
		return list;
	}

	
	 public static UserAccount findUserAccount(Connection conn, String name) throws SQLException 
	 { 
		 String sql = "Select a.User_Name, a.Password, a.Gender, a.Address, a.Email, a.Firstname, a.Lastname, a.Title from User_Account_DP a where a.User_Name=?"; 
	 
		 PreparedStatement pstm = conn.prepareStatement(sql); 
		 pstm.setString(1, name); 
		 ResultSet rs = pstm.executeQuery(); 
		 while (rs.next()) 
		 { 
			 String gender = rs.getString("Gender");
			 String address = rs.getString("Address");
			 String email = rs.getString("Email");
			 String firstname = rs.getString("Firstname");
			 String lastname = rs.getString("Lastname");
			 String title = rs.getString("Title");
			 UserAccount change = new UserAccount(); 
			 change.setUserName(name);
			 change.setGender(gender);
			 change.setAddress(address);
			 change.setEmail(email);
			 change.setFirstname(firstname);
			 change.setLastname(lastname);
			 return change; 
			 
		 } return null; 
		 
	 }
	 public static List<Product> queryEmployeeProduct(Connection conn, Integer id) throws SQLException {
		 String sql = "Select a.Code, a.Name, a.Price, a.Approval from Product_DP a where a.User_Id=?"; 
		 	System.out.println("Get to queryEmployeeProduct");
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id); 
			ResultSet rs = pstm.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while (rs.next()) {
				String code = rs.getString("Code");
				 String name = rs.getString("Name");
				 float price = rs.getFloat("Price");
				 String approval = rs.getString("Approval");
				 
				 Product product = new Product();
				 product.setCode(code);
				 product.setName(name);
				 product.setPrice(price);
				 product.setApproval(approval);
				list.add(product);
			}
			return list;
		}
	 public static Product findProduct(Connection conn, Integer id) throws SQLException 
	 { 
		 String sql = "Select a.Code, a.Name, a.Price, a.Approval from Product_DP a where a.User_Id=?"; 
	 
		 PreparedStatement pstm = conn.prepareStatement(sql); 
		 pstm.setInt(1, id); 
		 ResultSet rs = pstm.executeQuery(); 
		 while (rs.next()) 
		 { 
			 String code = rs.getString("Code");
			 String name = rs.getString("Name");
			 float price = rs.getFloat("Price");
			 String approval = rs.getString("Approval");

			 Product product = new Product();
			 product.setCode(code);
			 product.setName(name);
			 product.setPrice(price);
			 product.setApproval(approval);
			
			 return product; 
			 
		 } return null; 
		 
	 }
	 

	public static void updateUserAccount(Connection conn, UserAccount user) throws SQLException {
		String sql = "Update User_Account_DP set Address =?, Email=?, Password=? where User_name=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getAddress());
		pstm.setString(2, user.getEmail());
		pstm.setString(3, user.getPassword());
		pstm.setString(4, user.getUserName());
		pstm.executeUpdate();
	}

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product_DP set Name =?, Price=? where Code=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setString(3, product.getCode());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product_DP(Code, Name,Price,User_Id,Approval) values (?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());
		pstm.setInt(4, product.getAccount_id());
		pstm.setString(5, product.getApproval());
		pstm.executeUpdate();
	}
	public static void approveProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product_DP set Managername =?, Approval =? where Request_Id=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getApproval());
		pstm.setString(2, product.getManagername());
		pstm.setInt(3, product.getRequestid());
		System.out.println(product.getRequestid());
		
		
		pstm.executeUpdate();
	

	}

	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From Product_DP where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}

}