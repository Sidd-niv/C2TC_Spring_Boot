package com.tns.placementManagementSystem.restFullAPIs.entities;

//Importing this interface to make serial id 
import java.io.Serializable;
//Importing this interface for reference 
import java.util.List;

import javax.persistence.*;


//Below annotation states that, the below class is a table in DB.
@Entity
@Table(name="College")
public class College implements Serializable {

	public College() {
		super();
	}

	public College(long c_id, String collegeAdmin, String collegeName, String location, Long u_id,
			List<Student> student, List<Placement> placement) {
		super();
		this.c_id = c_id;
		this.collegeAdmin = collegeAdmin;
		this.collegeName = collegeName;
		this.location = location;
		this.u_id = u_id;
		this.student = student;
		this.placement = placement;
	}


	// Defining serializale_id 
	private static final long serialVersionUID = 1L;
	
	
	//Defining private instance variable

	// With Id annotation we are indicating that this is a primary key field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="college_id")
	private long c_id;
	
	// Column annotation we are indicating the actual name of column of relational world.
	@Column(name="collegeAdmin")
	private String collegeAdmin;
	
	@Column(name="collegeName")
	private String collegeName;
	
	@Column(name="location")
	private String location;
	

	@Column(name="u_id")
	private Long u_id;
	
	// Mapping the relations
	@OneToMany(mappedBy="college_id", fetch = FetchType.EAGER)
	private List<Student> student;
	
	// Mapping the relations
	@OneToMany(mappedBy="college_id", fetch = FetchType.EAGER)
	private List<Placement> placement;


	// Defining getter and setter methods to read and write private instance variable.
	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	public String getCollegeAdmin() {
		return collegeAdmin;
	}

	
	public void setCollegeAdmin(String collegeAdmin) {
		this.collegeAdmin = collegeAdmin;
	}

	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}



	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Long getU_id() {
		return u_id;
	}

	public void setU_id(Long u_id) {
		this.u_id = u_id;
	}

	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}


	public List<Placement> getPlacement() {
		return placement;
	}


	public void setPlacement(List<Placement> placement) {
		this.placement = placement;
	}


	// Overriding toString method to read the object value at the time of print statement
	@Override
	public String toString() {
		return "College [c_id=" + c_id + ", collegeAdmin=" + collegeAdmin + ", collegeName=" + collegeName
				+ ", location=" + location + ", u_id=" + u_id + ", student=" + student + "]";
	}
	
	
	
}


