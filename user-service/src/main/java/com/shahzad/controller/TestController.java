package com.shahzad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import com.shahzad.constants.RestMappingConstants;
import com.shahzad.dto.Response;
import com.shahzad.exception.ObjectNotFoundException;
import com.shahzad.dto.TestRequest;
import com.shahzad.dto.TestResponse;
import java.util.List;
import com.shahzad.service.TestService;

/**
 * @author shahzad.hussain 
 */
@RestController
@RequestMapping(value = "/test")
public class TestController{

	@Autowired
	private TestService testService;

	@PostMapping
	public ResponseEntity<Response> add(@RequestBody(required = true) TestRequest request)throws ObjectNotFoundException{
	Long response = testService.add(request);
	return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(path = RestMappingConstants.ID_PARAM)
	public ResponseEntity<Response> getById(@PathVariable(RestMappingConstants.ID) Long id)throws ObjectNotFoundException{
	TestResponse response = testService.getById(id);
	if(response==null){
		throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Response> getAll()throws ObjectNotFoundException{
	List<TestResponse> response = testService.getAll();
	if(CollectionUtils.isEmpty(response)){
		throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

	@DeleteMapping(path = RestMappingConstants.ID_PARAM)
	public ResponseEntity<Response> delete(@PathVariable(RestMappingConstants.ID) Long id)throws ObjectNotFoundException{
	if(!testService.exist(id)){
		throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
	}
	testService.delete(id);
	return new ResponseEntity<>(new Response("Success", HttpStatus.OK), HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<Response> update(@RequestBody(required = true) TestResponse request)throws ObjectNotFoundException{
	if(!testService.exist(request.getTestId())){
		throw new ObjectNotFoundException("Record not found", HttpStatus.NOT_FOUND);
	}
	Boolean response = testService.update(request);
	return new ResponseEntity<>(new Response("Success", response, HttpStatus.OK), HttpStatus.OK);
	}

}