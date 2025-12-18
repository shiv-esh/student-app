package com.training.studentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "contact", schema = "studentapp")
public class ContactEntity {

	@Id
	@Column(name = "stud_id")
	private Integer studId;

	@Column
	private String phone;

	@Column
	private String email;

	@Column
	private String address;

	@OneToOne
	@MapsId
	@JoinColumn(name = "stud_id")
	@JsonIgnore
	private StudentEntity student;

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}
}
