package com.shahzad.dto;

import com.shahzad.pojos.TestPojo;

public class TestResponse extends TestPojo {
	private Long testId;

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}
}