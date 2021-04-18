package com.shahzad.service;

import java.util.List;

import com.shahzad.VO.ResponseTemplateVO;
import com.shahzad.dto.UserRequest;
import com.shahzad.dto.UserResponse;
import com.shahzad.entity.User;
import com.shahzad.exception.ObjectNotFoundException;

/**
 * @author shahzad.hussain
 */
public interface UserService {
	Long add(UserRequest request);

	UserResponse getById(Long id);

	List<UserResponse> getAll();

	void delete(Long id);

	boolean exist(Long id);

	boolean update(UserResponse request);

	ResponseTemplateVO getUserWithDepartment(Long userId) throws ObjectNotFoundException;

	User saveUser(User user);
}