package com.org.kelvo.assetmanagement.Repositories;

import com.org.kelvo.assetmanagement.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
