package com.simplilearn.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="iam_Persons")
public class Persons {

	@Id
	@GeneratedValue
	@Column(name="iam_pid")
	private int pid;

	@Column(name="iam_name")
	private String name;
	
	@Column(name="iam_age")
	private String age;
	
	@Column(name="iam_gender")
	private String gender;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
