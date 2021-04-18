package com.shahzad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shahzad.dto.Response;

@RestController
public class FallBackController {

	@GetMapping("/userFallBack")
	public ResponseEntity<Response> userFallBack() {
		String message = "User Service is taking longer than Expected, Please try again later";
		return new ResponseEntity<>(new Response(message, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/departmentFallBack")
	public ResponseEntity<Response> departmentFallBack() {
		String message = "Department Service is taking longer than Expected, Please try again later";
		return new ResponseEntity<>(new Response(message, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}
}
