package com.tns.placementManagementSystem.restFullAPIs.entities;

// Importing this interface to make serial id 
import java.io.Serializable;

// Importing annotation from persistence 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Below annotation states that, the below class is a table in DB.
@Entity
@Table(name="user")
public class User implements Serializable{

	
	
	public User() {
		super();
	}

	public User(Long user_id, String uName, String uType, String uPassword) {
		super();
		this.user_id = user_id;
		this.uName = uName;
		this.uType = uType;
		this.uPassword = uPassword;
	}

	// Defining serial_id 
	private static final long serialVersionUID = 1L;
	//Defining private instance variable

	// With Id annotation we are indicating that this is a primary key field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="u_id")
	private Long user_id;
	
	// Column annotation we are indicating the actual name of column of relational world.
	@Column(name="uName")
	private String uName;
	
	@Column(name="uType")
	private String uType;
	
	@Column(name="uPassword")
	private String uPassword;
	
	// Defining getter and setter methods to read and write private instance variable.
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", uName=" + uName + ", uType=" + uType + ", uPassword=" + uPassword + "]";
	}



}
