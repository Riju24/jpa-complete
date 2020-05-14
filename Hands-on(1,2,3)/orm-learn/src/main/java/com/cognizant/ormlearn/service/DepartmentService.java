package com.cognizant.ormlearn.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.DepartmentRepository;
import com.cognizant.ormlearn.model.Department;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Transactional
	public Department get(Integer id)
	{
		return departmentRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Department dep)
	{
		departmentRepository.save(dep);
	}
}
