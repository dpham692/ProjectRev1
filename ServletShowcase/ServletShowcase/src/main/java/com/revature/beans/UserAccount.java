package com.revature.beans;

public class UserAccount {
	 
	   public static final String GENDER_MALE ="M";
	   public static final String GENDER_FEMALE = "F";
	    
	   private String userName;
	   private String gender;
	   private String password;
	   private String address;
	   private String email;
	   private String firstname;
	   private String lastname;
	   private String title;
	   private int id;
	   public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() 
	   {
		return title;
	   }

	   public void setTitle(String title) {
		this.title = title;
	   }

	public String getFirstname() {
		return firstname;
	   }

	   public void setFirstname(String firstname) {
		this.firstname = firstname;
	   }

	   public String getLastname() {
		return lastname;
	   }

	   public void setLastname(String lastname) {
		this.lastname = lastname;
	   }

	   public String getEmail() {
		return email;
	   }

	   public void setEmail(String email) {
		this.email = email;
	   }
	   
	   public String getAddress() {
		return address;
	   }

	   public void setAddress(String address) {
		this.address = address;
	   }

	   public UserAccount() {
	        
	   }
	    
	   public UserAccount(String address, String email) {
		   this.address = address;
		   this.email = email;
	   }

	   public UserAccount(String address, String email, String password, String username) {
		// TODO Auto-generated constructor stub
		   this.address = address;
		   this.email = email;
		   this.password = password;
		   this.userName = username;
	   }

	public String getUserName() {
	       return userName;
	   }
	 
	   public void setUserName(String userName) {
	       this.userName = userName;
	   }
	 
	   public String getGender() {
	       return gender;
	   }
	 
	   public void setGender(String gender) {
	       this.gender = gender;
	   }
	 
	   public String getPassword() {
	       return password;
	   }
	 
	   public void setPassword(String password) {
	       this.password = password;
	   }

	

	
	
	 
	}