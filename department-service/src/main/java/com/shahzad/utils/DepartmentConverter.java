package com.shahzad.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.shahzad.dto.DepartmentRequest;
import com.shahzad.dto.DepartmentResponse;
import com.shahzad.entity.Department;

/**
 * @author shahzad.hussain
 */
public class DepartmentConverter {

	public static Department getEntityFromRequest(DepartmentRequest request) {
		if (request != null) {
			Department response = new Department();
			response.setDepartmentName(request.getDepartmentName());
			response.setDepartmentAddress(request.getDepartmentAddress());
			response.setDepartmentCode(request.getDepartmentCode());
			return response;
		}
		return null;
	}

	public static DepartmentResponse getResponseFromEntity(Department request) {
		if (request != null) {
			DepartmentResponse response = new DepartmentResponse();
			response.setDepartmentId(request.getDepartmentId());
			response.setDepartmentName(request.getDepartmentName());
			response.setDepartmentAddress(request.getDepartmentAddress());
			response.setDepartmentCode(request.getDepartmentCode());
			return response;
		}
		return null;
	}

	public static Department getEntityFromResponse(DepartmentResponse request, Department response) {
		if (request != null) {
			response.setDepartmentName(request.getDepartmentName());
			response.setDepartmentAddress(request.getDepartmentAddress());
			response.setDepartmentCode(request.getDepartmentCode());
			return response;
		}
		return response;
	}

	public static List<DepartmentResponse> getResponseListFromEntityList(List<Department> requestList) {
		if (!CollectionUtils.isEmpty(requestList))
			return requestList.stream().map(o -> getResponseFromEntity(o)).collect(Collectors.toList());
		return null;
	}
}