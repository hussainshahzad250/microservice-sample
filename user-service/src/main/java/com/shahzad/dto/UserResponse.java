package com.shahzad.dto;

import com.shahzad.pojos.UserPojo;

public class UserResponse extends UserPojo {
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}