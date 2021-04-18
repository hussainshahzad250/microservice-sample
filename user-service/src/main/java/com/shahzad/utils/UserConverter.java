package com.shahzad.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.shahzad.dto.UserRequest;
import com.shahzad.dto.UserResponse;
import com.shahzad.entity.User;

/**
 * @author shahzad.hussain
 */
public class UserConverter {

	public static User getEntityFromRequest(UserRequest request) {
		if (request != null) {
			User response = new User();
			response.setUserId(request.getUserId());
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setEmail(request.getEmail());
			response.setDepartmentId(request.getDeparmentId());
			return response;
		}
		return null;
	}

	public static UserResponse getResponseFromEntity(User request) {
		if (request != null) {
			UserResponse response = new UserResponse();
			response.setUserId(request.getUserId());
			response.setUserId(request.getUserId());
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setEmail(request.getEmail());
			response.setDeparmentId(request.getDepartmentId());
			return response;
		}
		return null;
	}

	public static User getEntityFromResponse(UserResponse request, User response) {
		if (request != null) {
			response.setUserId(request.getUserId());
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setEmail(request.getEmail());
			response.setDepartmentId(request.getDeparmentId());
			return response;
		}
		return null;
	}

	public static List<UserResponse> getResponseListFromEntityList(List<User> requestList) {
		if (!CollectionUtils.isEmpty(requestList))
			return requestList.stream().map(o -> getResponseFromEntity(o)).collect(Collectors.toList());
		return null;
	}
}