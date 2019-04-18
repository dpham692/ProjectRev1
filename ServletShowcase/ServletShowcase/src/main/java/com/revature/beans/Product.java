package com.revature.beans;

public class Product {
	 
	   private String code;
	   private String name;
	   private float price;
	   private String managername;
	   private int account_id;
	   private String approval;
	   private int requestid;
	   public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getManagername() {
		return managername;
	}
	   
	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	//6
	public Product(String code, String name, float price, String managername, int account_id) 
	{
		
		this.code = code;
		this.name = name;
		this.price = price;
		this.managername = managername;
		this.account_id = account_id;
	}
	//0
	public Product() {
	 
	   }
	 	public Product(String managername, String approval, int requestid) {
		super();
		this.managername = managername;
		this.approval = approval;
		this.requestid = requestid;
	}

	//3
	   public Product(String code, String name, float price) {
	       this.code = code;
	       this.name = name;
	       this.price = price;
	   }
	   //2
	   public Product(String name, float price) {
		   this.name = name;
	       this.price = price;
	   }
	   //4
	public Product(String code, String name, float price, int id) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.account_id = id;
	}
	//5
	public Product(String code, String name, float price, int id, String approval) {
		
		this.code = code;
		this.name = name;
		this.price = price;
		this.account_id = id;
		this.approval = approval;
	}

	

	public String getCode() {
	       return code;
	   }
	 
	   public void setCode(String code) {
	       this.code = code;
	   }
	 
	   public String getName() {
	       return name;
	   }
	 
	   public void setName(String name) {
	       this.name = name;
	   }
	 
	   public float getPrice() {
	       return price;
	   }
	 
	   public void setPrice(float price) {
	       this.price = price;
	   }

	
	 
	}