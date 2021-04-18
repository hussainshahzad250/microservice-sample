package com.shahzad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shahzad.VO.ResponseTemplateVO;
import com.shahzad.constants.RestMappingConstants;
import com.shahzad.dto.Response;
import com.shahzad.dto.UserRequest;
import com.shahzad.dto.UserResponse;
import com.shahzad.entity.User;
import com.shahzad.exception.ObjectNotFoundException;
import com.shahzad.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shahzad.hussain
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser of UserController");
		return userService.saveUser(user);
	}

	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) throws ObjectNotFoundException {
		log.info("Inside getUserWithDepartment of UserController");
		return userService.getUserWithDepartment(userId);
	}

	@PostMapping
	public ResponseEntity<Response> add(@RequestBody(required = true) UserRequest request)
			throws ObjectNotFoundException {
		Long response = userService.add(request);
		return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

//	@GetMapping(path = RestMappingConstants.ID_PARAM)
//	public ResponseEntity<Response> getById(@PathVariable(RestMappingConstants.ID) Long id)
//			throws ObjectNotFoundException {
//		UserResponse response = userService.getById(id);
//		if (response == null) {
//			throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
//	}

	@GetMapping
	public ResponseEntity<Response> getAll() throws ObjectNotFoundException {
		List<UserResponse> response = userService.getAll();
		if (CollectionUtils.isEmpty(response)) {
			throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

	@DeleteMapping(path = RestMappingConstants.ID_PARAM)
	public ResponseEntity<Response> delete(@PathVariable(RestMappingConstants.ID) Long id)
			throws ObjectNotFoundException {
		if (!userService.exist(id)) {
			throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
		}
		userService.delete(id);
		return new ResponseEntity<>(new Response("Success", HttpStatus.OK), HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<Response> update(@RequestBody(required = true) UserResponse request)
			throws ObjectNotFoundException {
		if (!userService.exist(request.getUserId())) {
			throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
		}
		Boolean response = userService.update(request);
		return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

}