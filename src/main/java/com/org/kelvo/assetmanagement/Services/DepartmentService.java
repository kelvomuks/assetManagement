package com.org.kelvo.assetmanagement.Services;

import com.org.kelvo.assetmanagement.Entities.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    
    List<Department> getAllDepartments();

    Department addNewDepartment(Department department);

    Optional<Department> findDepartmentById(Long departmentId);
}
