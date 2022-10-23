package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private Long testId;
	
	@Column(name = "cost",nullable=false)
	private double cost;
	
	@Column(name = "test_name",nullable=false)
	private String testName;
	
	@ManyToMany(mappedBy = "tests")
	private Set<Appointment> Appointments=new HashSet<>();

	public Test() {
		super();
	
	}

	public Test(Long testId, double cost, String testName) {
		super();
		this.testId = testId;
		this.cost = cost;
		this.testName = testName;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", cost=" + cost + ", testName=" + testName + "]";
	}
}
