package com.userservice.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.main.VO.Department;
import com.userservice.main.VO.ResponseTemplateVO;
import com.userservice.main.entity.User;
import com.userservice.main.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("inside saveUser method of UserService");
		return userRepo.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {

		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepo.findByUserId(userId);

		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
		
	}

}
