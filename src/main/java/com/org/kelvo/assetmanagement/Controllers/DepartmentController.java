package com.org.kelvo.assetmanagement.Controllers;

import com.org.kelvo.assetmanagement.Entities.Department;
import com.org.kelvo.assetmanagement.Repositories.DepartmentRepository;
import com.org.kelvo.assetmanagement.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")

    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> departmentList = departmentService.getAllDepartments();

        return new ResponseEntity<List<Department>>(departmentList,HttpStatus.OK);
    }

    @PostMapping("/departments")
    public Department addNewDepartment(@RequestBody Department department){

        return departmentService.addNewDepartment(department);
    }

    @GetMapping("/departments/{departmentId}")
    public Optional<Department> getDepartmentById(@PathVariable Long departmentId){

        return departmentService.findDepartmentById(departmentId);
    }

}
