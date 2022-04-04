package com.tns.placementManagementSystem.restFullAPIs.entities;

//Importing this interface to make serial id 
import java.io.Serializable;

//Importing annotation from persistence 
import javax.persistence.*;



//Below annotation states that, the below class is a table in DB.
@Entity
@Table(name="Student")
public class Student implements Serializable{
	
	 
	public Student() {
		super();
	}

	public Student(Long id, String name, String collegeName, long roll, String qualification, String course,
			Certificate certificate, long hallTicketNo, College college_id) {
		super();
		this.id = id;
		this.name = name;
		this.collegeName = collegeName;
		this.roll = roll;
		this.qualification = qualification;
		this.course = course;
		this.certificate = certificate;
		this.hallTicketNo = hallTicketNo;
		this.college_id = college_id;
	}

	// Defining serializale_id 
	private static final long serialVersionUID = 1L;

	//Declaring private instance variable
	
	// With Id annotation we are indicating that this is a primary key field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="S_id")
	private Long id;
	
	// Column annotation we are indicating the actual name of column of relational world.
	@Column(name="sName")
	private String name;
	
	@Column(name="collegeName")
	private String collegeName;
	
	@Column(name="rollNo")
	private long roll;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="course")
	private String course;
	
	// Forming the associations
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="cert_id")
	private Certificate certificate;
	
	@Column(name="hallTicket")
	private long hallTicketNo;
	
	// Forming the associations
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="college_id")
	private College college_id;
	
	// Defining getter and setter methods to read and write private instance variable.
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public long getRoll() {
		return roll;
	}

	public void setRoll(long roll) {
		this.roll = roll;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public long getHallTicketNo() {
		return hallTicketNo;
	}

	public void setHallTicketNo(long hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}

	public College getCollege_id() {
		return college_id;
	}

	public void setCollege_id(College college_id) {
		this.college_id = college_id;
	}

	// Overriding toString method to read the object value at the time of print statement
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", collegeName=" + collegeName + ", roll=" + roll
				+ ", qualification=" + qualification + ", course=" + course + ", certificate=" + certificate
				+ ", hallTicketNo=" + hallTicketNo + ", college_id=" + college_id + "]";
	}
	

}
