package com.harsh.employeeapi.controller;

import com.harsh.employeeapi.dtos.DepartmentWithEmployeeListDto;
import com.harsh.employeeapi.dtos.DepartmentDto;
import com.harsh.employeeapi.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentServices departmentServices;

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentWithEmployeeListDto> getDepartmentById(@PathVariable  int departmentId){
        return ResponseEntity.of(departmentServices.getDepartmentById(departmentId));
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.of(
                Optional.of(
                        departmentServices.getAllDepartments()
                ));
    }

    @PostMapping()
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok().body(departmentServices.createDepartment(departmentDto));
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto,
                                       @PathVariable int departmentId){
        return ResponseEntity.ok().body(departmentServices.updateDepartment(departmentDto,departmentId));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable int departmentId){
        departmentServices.deleteDepartmentById(departmentId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteAllDepartments(){
        departmentServices.deleteAllDepartments();
        return ResponseEntity.ok().build();
    }
}
