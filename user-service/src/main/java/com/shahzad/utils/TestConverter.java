package com.shahzad.utils;

import com.shahzad.entity.Test;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;
import com.shahzad.dto.TestRequest;
import com.shahzad.dto.TestResponse;

/**
 * @author shahzad.hussain 
 */
public class TestConverter {

	public static TestRequest getSample() {
		TestRequest response = new TestRequest();
		response.setDepartment("department");
		response.setPostedOn("postedOn");
		return response;
	}

	public static Test getEntityFromRequest(TestRequest request) {
		if(request!=null){
			Test response = new Test();
			response.setDepartment(request.getDepartment());
			response.setPostedOn(request.getPostedOn());
			return response;
		}
		return null;
	}

	public static TestResponse getResponseFromEntity(Test request) {
		if(request!=null){
			TestResponse response = new TestResponse();
			response.setTestId(request.getId());
			response.setDepartment(request.getDepartment());
			response.setPostedOn(request.getPostedOn());
			return response;
		}
		return null;
	}

	public static Test getEntityFromResponse(TestResponse request,Test response) {
		if (request!=null){
			response.setDepartment(request.getDepartment());
			response.setPostedOn(request.getPostedOn());
			return response;
		}
		return null;
	}

	public static List<TestResponse> getResponseListFromEntityList(List<Test> requestList) {
		if (!CollectionUtils.isEmpty(requestList)){
			List<TestResponse> responseList = new ArrayList<>();
			for (Test request:requestList){
				responseList.add(getResponseFromEntity(request));
			}
			return responseList;
		}
		return null;
	}
}