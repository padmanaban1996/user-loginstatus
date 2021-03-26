package com.smile.tech.payload.request;

import javax.validation.constraints.NotBlank;

public class UserCreateRequest {

	@NotBlank
	private String userId;
	@NotBlank
	private String schoolId;
	@NotBlank
	private String username;
	@NotBlank
	private String token;

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
}
