package com.org.kelvo.assetmanagement.Services.templates;

import com.org.kelvo.assetmanagement.Entities.Department;
import com.org.kelvo.assetmanagement.Repositories.DepartmentRepository;
import com.org.kelvo.assetmanagement.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department addNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }
}
