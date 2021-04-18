package com.shahzad.service;

import com.shahzad.dto.DepartmentRequest;
import com.shahzad.dto.DepartmentResponse;
import com.shahzad.entity.Department;

import java.util.List;

/**
 * @author shahzad.hussain
 */
public interface DepartmentService {
	Long add(DepartmentRequest request);

	Department getById(Long id);

	List<DepartmentResponse> getAll();

	boolean exist(Long id);

	boolean update(DepartmentResponse request);
}