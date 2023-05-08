package com.simplilearn.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="iam_Admin")
public class Admin {
	@Id
	@GeneratedValue
	@Column(name="iam_aid")
	private int aid;

	@Column(name="iam_username")
	private String username;

	@Column(name="iam_password")
	private String password;
	
	@Column(name="iam_question")
	private String question;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
