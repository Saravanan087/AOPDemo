package com.aop.aopdemo.utils;

public class User  {
	
	String Name;
	int Age;
	int Salary;
	
	public User(String Name,int Age,int Salary) {
		this.Name=Name;
		this.Age=Age;
		this.Salary=Salary;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

}
