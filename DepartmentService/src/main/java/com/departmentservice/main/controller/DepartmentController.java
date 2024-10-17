package com.departmentservice.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.departmentservice.main.entity.Department;
import com.departmentservice.main.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("inside saveDepartment method of DepartmentController");
		return departmentService.saveDepartment(department);

	}

	@GetMapping("/{id}")
	public Department findByDepartmentId(@PathVariable("id") Long departmentId) {
		log.info("inside findByDepartmentId method of DepartmentController");
		return departmentService.findByDepartmentId(departmentId);
	}

	@GetMapping("/getDepartments")
	public List<Department> fetchDepartments() {
		log.info("inside fetchDepartments method of DepartmentController");
		return departmentService.findDepartments();
	}
}
