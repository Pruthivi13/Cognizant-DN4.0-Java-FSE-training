package com.cognizant.spring_learn.service;

import com.cognizant.dao.DepartmentDao;
import com.cognizant.model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}