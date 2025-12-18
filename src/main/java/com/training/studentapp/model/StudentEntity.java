package com.training.studentapp.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "students", schema = "studentapp")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_id")
	private Integer studId;

	@Column
	private String name;

	@Column
	private Date dob;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private MarksEntity marks;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private ContactEntity contact;

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
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

	public MarksEntity getMarks() {
		return marks;
	}

	public void setMarks(MarksEntity marks) {
		this.marks = marks;
	}

	public ContactEntity getContact() {
		return contact;
	}

	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}
}
