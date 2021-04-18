package com.shahzad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shahzad.VO.Department;
import com.shahzad.VO.ResponseTemplateVO;
import com.shahzad.dto.UserRequest;
import com.shahzad.dto.UserResponse;
import com.shahzad.entity.User;
import com.shahzad.exception.ObjectNotFoundException;
import com.shahzad.repository.UserRepository;
import com.shahzad.utils.UserConverter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shahzad.hussain
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Environment environment;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Long add(UserRequest request) {
		User entity = UserConverter.getEntityFromRequest(request);
		if (entity != null) {
			userRepository.save(entity);
			return entity.getUserId();
		}
		return 0l;
	}

	@Override
	public UserResponse getById(Long id) {
		return UserConverter.getResponseFromEntity(userRepository.findById(id).orElse(null));
	}

	@Override
	public List<UserResponse> getAll() {
		return UserConverter.getResponseListFromEntityList(userRepository.findAll());
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public boolean exist(Long id) {
		if (getById(id) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(UserResponse request) {
		Optional<User> findById = userRepository.findById(request.getUserId());
		if (findById.isPresent()) {
			User entity = findById.get();
			UserConverter.getEntityFromResponse(request, entity);
			if (entity != null) {
				userRepository.save(entity);
				return true;
			}
		}

		return false;
	}

	@Override
	public User saveUser(User user) {
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	@Override
	public ResponseTemplateVO getUserWithDepartment(Long userId) throws ObjectNotFoundException {
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		if (user == null)
			throw new ObjectNotFoundException("User not found", HttpStatus.NOT_FOUND);
		String url = environment.getProperty("dept.url");
		Department department = restTemplate.getForObject(url + user.getDepartmentId(),
				Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}