package com.tns.placementManagementSystem.restFullAPIs.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//Below annotation states that, the below class is a table in DB.
@Entity
@Table(name="Placement")
public class Placement implements Serializable {
	

	public Placement() {
		super();
	}

	public Placement(Long p_id, String pName, String pDate, String qualification, Long year, String collegeName,
			College college_id) {
		super();
		this.p_id = p_id;
		this.pName = pName;
		this.pDate = pDate;
		this.qualification = qualification;
		this.year = year;
		this.collegeName = collegeName;
		this.college_id = college_id;
	}

	// Defining serial_id 
	private static final long serialVersionUID = 1L;
	
	//Defining private instance variable

	// With Id annotation we are indicating that this is a primary key field
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="p_id")
	private Long p_id;
	
	// Column annotation we are indicating the actual name of column of relational world.
	@Column(name="pName")
	private String pName;
	
	@Column(name="pDate")
	private String pDate;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="Year")
	private Long year;
	
	@Column(name="collegeName")
	private String collegeName;
	
	// Declaring the Many to one relationship.
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="college_id")
	private College college_id;

	// Defining getter and setter methods to read and write private instance variable.
	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public College getCollege_id() {
		return college_id;
	}

	public void setCollege_id(College college_id) {
		this.college_id = college_id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	// Overriding toString method to read the object value at the time of print statement
	@Override
	public String toString() {
		return "Placement [p_id=" + p_id + ", pName=" + pName + ", pDate=" + pDate + ", qualification=" + qualification
				+ ", year=" + year + ", collegeName=" + collegeName + ", college_id=" + college_id + "]";
	}

	

}
