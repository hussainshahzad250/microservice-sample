package com.shahzad.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;

import javax.net.ssl.SSLHandshakeException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shahzad.dto.Response;

/**
 * @since Dec 17, 2020
 * @author shahzad.hussain
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	private static final String ERROR_MSG = "Something went Wrong, Please try Later";

	@ExceptionHandler(value = FileNotFoundException.class)
	@ResponseBody
	public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException ex) {
		logger.info("FileNotFound Exception occurs => {}", ex);
		return new ResponseEntity<>(new Response("File does not exist", HttpStatus.NOT_FOUND), HttpStatus.OK);
	}

	@ExceptionHandler(value = BadRequestException.class)
	@ResponseBody
	public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
		logger.info("BadRequestException occurs => {}", ex);
		return new ResponseEntity<>(new Response(ex.getMessage(), ex.getHttpStatus()), HttpStatus.OK);
	}

	@ExceptionHandler(value = ObjectNotFoundException.class)
	@ResponseBody
	public ResponseEntity<Object> handleObjectNotFoundException(ObjectNotFoundException ex) {
		logger.info("ObjectNotFoundException occurs => {}", ex);
		return new ResponseEntity<>(new Response(ex.getMessage(), ex.getHttpStatus()), HttpStatus.OK);
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleException(Exception ex) {
		logger.info("Exception  occurs => {}", ex);
		return new ResponseEntity<>(new Response(ERROR_MSG, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public ResponseEntity<Object> handleFileNotFoundException(HttpRequestMethodNotSupportedException ex) {
		logger.info("HttpRequestMethodNotSupportedException occurs => {}", ex);
		return new ResponseEntity<>(new Response(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	@ResponseBody
	public ResponseEntity<Object> handleFileNotFoundException(MissingServletRequestParameterException ex) {
		logger.info("MissingServletRequestParameterException Exception occurs => {}", ex);
		return new ResponseEntity<>(new Response(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = SSLHandshakeException.class)
	@ResponseBody
	public ResponseEntity<Response> handleSSLHandshakeException(SSLHandshakeException ex) {
		logger.info("SSLHandshake Exception occurs => {}", ex);
		return new ResponseEntity<>(new Response(ERROR_MSG, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = EOFException.class)
	@ResponseBody
	public ResponseEntity<Object> handleEOFException(EOFException ex) {
		logger.info("EOF Exception occurs => {}", ex);
		return new ResponseEntity<>(new Response(ERROR_MSG, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

}