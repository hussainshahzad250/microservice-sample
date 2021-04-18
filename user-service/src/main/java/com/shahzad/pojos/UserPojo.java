package com.shahzad.pojos;

public class UserPojo {
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private Long deparmentId;

	public Long getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Long getDeparmentId() {
		return deparmentId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDeparmentId(Long deparmentId) {
		this.deparmentId = deparmentId;
	}

}
