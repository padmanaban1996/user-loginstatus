package com.smile.tech.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@NotBlank
	private String userId;
	@NotBlank
	private String schoolId;
	@NotBlank
	private String username;
	@NotBlank
	private String token;

	public Users() {
		super();
	}

	public Users(String userId, String schoolId, String username, String token) {
		super();
		this.userId = userId;
		this.schoolId = schoolId;
		this.username = username;
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
