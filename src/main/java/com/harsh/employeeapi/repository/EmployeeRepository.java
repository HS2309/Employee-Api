package com.harsh.employeeapi.repository;

import com.harsh.employeeapi.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    @Transactional
    public void deleteAllByDepartmentId(int departmentId);

    Employee findByDepartmentId(int departmentID);

    @Query("select id from Employee")
    List<Integer> findAllIds();
}
