package com.tns.placementManagementSystem.restFullAPIs.entities;

//Importing this interface to make serial id 
import java.io.Serializable;

//Importing annotation from persistence 
import javax.persistence.*;

//Below annotation states that, the below class is a table in DB.
@Entity
@Table(name = "certificate")
public class Certificate implements Serializable {


	public Certificate() {
		super();
	}

	public Certificate(Long c_id, Long year, String collegeName, Student student) {
		super();
		this.c_id = c_id;
		this.year = year;
		this.collegeName = collegeName;
		this.student = student;
	}

	// Defining serializale_id
	private static final long serialVersionUID = 1L;

	// Defining private instance variable

	// With Id annotation we are indicating that this is a primary key field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cert_id")
	private Long c_id;

	// Column annotation we are indicating the actual name of column of relational
	// world.
	@Column(name = "Year")
	private Long year;

	@Column(name = "collegeName")
	private String collegeName;

	// Mapping the relations
	@OneToOne(mappedBy = "certificate", fetch = FetchType.EAGER)
	private Student student;

	// Defining getter and setter methods to read and write private instance
	// variable.
	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	// Overriding toString method to read the object value at the time of print
	// statement
	@Override
	public String toString() {
		return "Certificate [c_id=" + c_id + ", year=" + year + ", collegeName=" + collegeName + ", student=" + student
				+ "]";
	}

}
