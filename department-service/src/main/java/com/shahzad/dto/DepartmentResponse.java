package com.shahzad.dto;

import com.shahzad.pojos.DepartmentPojo;

public class DepartmentResponse extends DepartmentPojo {
	private Long departmentId;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
}