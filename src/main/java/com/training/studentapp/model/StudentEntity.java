package com.training.studentapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="students",schema="stdapp")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stdid;
	
	
	@Column
	private String name;
	
	@Column
	private Date dob;
	
//	@Column 
//	private int year;
	@OneToOne
	@JoinColumn(name="stdid")
	private MarksEntity marks;
	
	@OneToOne
	@JoinColumn(name="stdid")
	private ContactEntity contact;

	public MarksEntity getMarks() {
		return marks;
	}

	public void setMarks(MarksEntity marks) {
		this.marks = marks;
	}

	public int getStdid() {
		return stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public ContactEntity getContact() {
		return contact;
	}

	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}
	

}
