package com.training.studentapp.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "subjects", schema = "studentapp")
public class MarksEntity {

	@Id
	@Column(name = "stud_id")
	private Integer studId;

	@Column
	private int java;

	@Column
	private int spring;

	@Column
	private int hibernate;

	@Column
	private int microservices;

	@Column
	private int angular;

	@OneToOne
	@MapsId
	@JoinColumn(name = "stud_id")
	@JsonIgnore
	private StudentEntity student;

	@Transient
	private float percentage;

	@Transient
	private String result;



	public float getPercentage() {
		int sum =this.angular+this.hibernate+this.java+this.microservices +this.spring;
		this.percentage=(sum/(float)500)*100;
		return this.percentage;
	}
	
	public String getResult() {
		if(this.percentage>30) {
			this.result="Pass";
		}else {
			this.result="Fail";
		}
		return this.result;
			
	}

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getSpring() {
		return spring;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}

	public int getHibernate() {
		return hibernate;
	}

	public void setHibernate(int hibernate) {
		this.hibernate = hibernate;
	}

	public int getMicroservices() {
		return microservices;
	}

	public void setMicroservices(int microservices) {
		this.microservices = microservices;
	}

	public int getAngular() {
		return angular;
	}

	public void setAngular(int angular) {
		this.angular = angular;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
