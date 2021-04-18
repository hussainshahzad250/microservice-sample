package com.shahzad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shahzad.entity.Test;
import com.shahzad.dto.TestRequest;
import com.shahzad.dto.TestResponse;
import java.util.List;
import java.util.Optional;

import com.shahzad.repository.TestRepository;
import com.shahzad.utils.TestConverter;

/**
 * @author shahzad.hussain
 */
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRepository;

	@Override
	public Long add(TestRequest request) {
		Test entity = TestConverter.getEntityFromRequest(request);
		if (entity != null) {
			testRepository.save(entity);
			return entity.getId();
		}
		return 0l;
	}

	@Override
	public TestResponse getById(Long id) {
		return TestConverter.getResponseFromEntity(testRepository.findById(id).orElse(null));
	}

	@Override
	public List<TestResponse> getAll() {
		return TestConverter.getResponseListFromEntityList(testRepository.findAll());
	}

	@Override
	public void delete(Long id) {
		testRepository.deleteById(id);
	}

	@Override
	public boolean exist(Long id) {
		if (getById(id) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(TestResponse request) {
		Optional<Test> findById = testRepository.findById(request.getTestId());
		if (findById.isPresent()) {
			Test entity = findById.get();
			TestConverter.getEntityFromResponse(request, entity);
			if (entity != null) {
				testRepository.save(entity);
				return true;
			}
		}
		return false;
	}

}