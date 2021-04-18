package com.shahzad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shahzad.constants.RestMappingConstants;
import com.shahzad.dto.DepartmentRequest;
import com.shahzad.dto.DepartmentResponse;
import com.shahzad.dto.Response;
import com.shahzad.entity.Department;
import com.shahzad.exception.ObjectNotFoundException;
import com.shahzad.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shahzad.hussain
 */
@RestController
@RequestMapping(value = "/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<Response> saveDepartment(@RequestBody(required = true) DepartmentRequest request)
			throws ObjectNotFoundException {
		log.info("Inside saveDepartment method of DepartmentController");
		Long response = departmentService.add(request);
		return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(path = RestMappingConstants.ID_PARAM)
	public Department findDepartmentById(@PathVariable(RestMappingConstants.ID) Long id)
			throws ObjectNotFoundException {
		log.info("Inside findDepartmentById method of DepartmentController");
		Department response = departmentService.getById(id);
		if (response == null)
			throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
		return response;
	}

	@GetMapping
	public ResponseEntity<Response> findAllDepartments() throws ObjectNotFoundException {
		log.info("Inside findAllDepartments method of DepartmentController");
		List<DepartmentResponse> response = departmentService.getAll();
		if (CollectionUtils.isEmpty(response))
			throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<Response> update(@RequestBody(required = true) DepartmentResponse request)
			throws ObjectNotFoundException {
		if (!departmentService.exist(request.getDepartmentId()))
			throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
		Boolean response = departmentService.update(request);
		return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

}