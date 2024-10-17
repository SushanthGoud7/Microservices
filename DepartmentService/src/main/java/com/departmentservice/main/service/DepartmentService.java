package com.departmentservice.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departmentservice.main.entity.Department;
import com.departmentservice.main.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;

	public Department saveDepartment(Department department) {
		log.info("inside saveDepartment method of DepartmentService");
		return departmentRepo.save(department);
	}

	public Department findByDepartmentId(Long departmentId) {
		log.info("inside findByDepartmentId method of DepartmentService");
		return departmentRepo.findByDepartmentId(departmentId);
	}

	public List<Department> findDepartments() {
		log.info("inside findDepartments method of DepartmentService");
		return departmentRepo.findAll();
	}

}
