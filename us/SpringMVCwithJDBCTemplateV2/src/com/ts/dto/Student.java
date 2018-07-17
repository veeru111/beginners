package com.ts.dto;

public class Student {
	private int id;
	private String sname;
	private double fees;
	public Student() {
		super();
	}

	public Student(int id, String sname, double fees) {
		super();
		this.id = id;
		this.sname = sname;
		this.fees = fees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", fees=" + fees + "]";
	}
}
