package com.jbk.entities;

import com.jbk.enums.ApplicationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_application")
public class JobApplication {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private long id;
	
	@Column(name = "student_id", nullable = false)
	private long studentId;
	
	@Column(name = "job_posting_id", nullable = false)
	private long jobPostingId;
	
	@Column(name = "status",nullable = false)
	private String status = ApplicationStatus.APPLIED.getValue();
	
	public JobApplication() {
		// TODO Auto-generated constructor stub
	}

	public JobApplication(long id, long studentId, long jobPostingId, String status) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.jobPostingId = jobPostingId;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getJobPostingId() {
		return jobPostingId;
	}

	public void setJobPostingId(long jobPostingId) {
		this.jobPostingId = jobPostingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "JobApplication [id=" + id + ", studentId=" + studentId + ", jobPostingId=" + jobPostingId + ", status="
				+ status + "]";
	}
	
	

}
