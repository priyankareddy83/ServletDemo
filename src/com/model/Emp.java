package com.model;

public class Emp {
	private int id;
	private String Username, Password;
	private String Salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", Username=" + Username + ", Password=" + Password + ", Salary=" + Salary + "]";
	}

}
