package com.harsh.employeeapi.repository;

import com.harsh.employeeapi.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Integer> {

}
