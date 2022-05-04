package com.harsh.employeeapi.controller;

import com.harsh.employeeapi.dtos.CreateEmployeeDto;
import com.harsh.employeeapi.dtos.EmployeeDetailedDto;
import com.harsh.employeeapi.dtos.EmployeeDto;
import com.harsh.employeeapi.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.of(Optional.of(employeeServices.getAllEmployees()));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDetailedDto> getEmployeeById(@PathVariable int employeeId){
        return ResponseEntity.ok(employeeServices.getByEmployeeId(employeeId).get());
    }

    @PostMapping
    public ResponseEntity<CreateEmployeeDto> createEmployee(@RequestBody CreateEmployeeDto createEmployee){
        return ResponseEntity.ok().body(employeeServices.createEmployee(createEmployee));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<CreateEmployeeDto> updateEmployee(@RequestBody CreateEmployeeDto employee, @PathVariable int employeeId){
        return ResponseEntity.ok().body(employeeServices.updateEmployee(employee,employeeId));
    }

    @DeleteMapping
        public ResponseEntity<Void> deleteAllEmployees(){
        employeeServices.deleteAllEmployees();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/department/{departmentId}")
    public ResponseEntity<Void> deleteAllEmployeesByDepartmentId(@PathVariable int departmentId){

       employeeServices.deleteAllEmployeesByDepartmentId(departmentId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId){
        employeeServices.deleteEmployeeById(employeeId);
        return ResponseEntity.ok().build();
    }
}