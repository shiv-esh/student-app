package com.training.studentapp.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="subjects",schema="stdapp")
public class MarksEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stdid;
	
	
	
	@Column
	private int java;
	
	@Column
	private int Spring;
	@Column
	private int Hibernate;
	@Column
	private int Microservices;
	@Column
	private int Angular;
	
	@javax.persistence.Transient
	private float percentage;
	
	@javax.persistence.Transient
	private String result;
	
	public float getPercentage() {
		int sum =this.Angular+this.Hibernate+this.java+this.Microservices+this.Spring;
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
	
	
	
	public int getStudid() {
		return stdid;
	}
	public void setStudid(int stdid) {
		this.stdid = stdid;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSpring() {
		return Spring;
	}
	public void setSpring(int spring) {
		Spring = spring;
	}
	public int getHibernate() {
		return Hibernate;
	}
	public void setHibernate(int hibernate) {
		Hibernate = hibernate;
	}
	public int getMicroservices() {
		return Microservices;
	}
	public void setMicroservices(int microservices) {
		Microservices = microservices;
	}
	public int getAngular() {
		return Angular;
	}
	
	
	public void setAngular(int angular) {
		Angular = angular;
	}
}
