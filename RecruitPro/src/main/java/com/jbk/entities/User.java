package com.jbk.entities;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "username", nullable = false, unique = true)
	@NotEmpty(message="Invalid Username ")
	private String username;

	@Column(name = "password", nullable = false)
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\r\n",message = "Invalid Password"
			)
	private String password;

	@NotEmpty(message="Invalid ")
	@Column(name = "question", nullable = false)
	private String question;

	@NotEmpty(message="Invalid answer")
	@Column(name = "answer", nullable = false)
	private String answer;

	
	@NotEmpty(message = "enter valid role")
	@Column(name = "role", nullable = false)
	private String role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String question, String answer, String role) {
		super();
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", question=" + question + ", answer=" + answer
				+ ", role=" + role + "]";
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
