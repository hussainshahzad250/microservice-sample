package com.shahzad.service;
import com.shahzad.dto.TestRequest;
import com.shahzad.dto.TestResponse;
import java.util.List;

/**
 * @author shahzad.hussain 
 */
public interface TestService{
	Long add(TestRequest request);
	TestResponse getById(Long id);
	List<TestResponse> getAll();
	void delete(Long id);
	boolean exist(Long id);
	boolean update(TestResponse request);
}