package com.shahzad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shahzad.dto.DepartmentRequest;
import com.shahzad.dto.DepartmentResponse;
import com.shahzad.entity.Department;
import com.shahzad.repository.DepartmentRepository;
import com.shahzad.utils.DepartmentConverter;

/**
 * @author Shahzad Hussain
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Long add(DepartmentRequest request) {
		Department entity = DepartmentConverter.getEntityFromRequest(request);
		if (entity != null) {
			departmentRepository.save(entity);
			return entity.getDepartmentId();
		}
		return 0l;
	}

	@Override
	public Department getById(Long id) {
		return departmentRepository.findById(id).orElse(null);
	}

	@Override
	public List<DepartmentResponse> getAll() {
		return DepartmentConverter.getResponseListFromEntityList(departmentRepository.findAll());
	}

	@Override
	public boolean exist(Long id) {
		if (getById(id) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(DepartmentResponse request) {
		Optional<Department> findById = departmentRepository.findById(request.getDepartmentId());
		if (findById.isPresent()) {
			Department entity = findById.get();
			DepartmentConverter.getEntityFromResponse(request, entity);
			if (entity != null) {
				departmentRepository.save(entity);
				return true;
			}
		}
		return false;
	}

}