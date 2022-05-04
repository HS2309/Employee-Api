package com.harsh.employeeapi.services;

import com.harsh.employeeapi.dtos.CreateEmployeeDto;
import com.harsh.employeeapi.dtos.EmployeeDto;
import com.harsh.employeeapi.dtos.EmployeeDetailedDto;
import com.harsh.employeeapi.exception.DuplicateIdException;
import com.harsh.employeeapi.exception.ResourceNotFoundException;
import com.harsh.employeeapi.mapper.MapStructMapper;
import com.harsh.employeeapi.model.Employee;
import com.harsh.employeeapi.repository.DepartmentRepository;
import com.harsh.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    public List<EmployeeDto> getAllEmployees() {
        return mapStructMapper.getAllEmployees((List<Employee>) employeeRepository.findAll());
    }

    public Optional<EmployeeDetailedDto> getByEmployeeId(int employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Not found employee with id : " + employeeId));
        EmployeeDetailedDto employeeDepartmentDto = mapStructMapper.employeeWithDepartmentDto(employee);

        employeeDepartmentDto.setDepartmentDto(mapStructMapper.departmentToDepartmentDto(employee.getDepartment()));
        employeeDepartmentDto.setProjectDtoList(mapStructMapper.getProjectDtoSet(employee.getProjectSet()));
        return Optional.of(employeeDepartmentDto);
    }

    public CreateEmployeeDto createEmployee(CreateEmployeeDto newEmployee) {
        int departmentId = newEmployee.getDepartmentId();
        int employeeId = newEmployee.getId();
        if (employeeRepository.existsById(employeeId)) {
            throw new DuplicateIdException("Employee with the Id " + employeeId + " already exist.");
        }
        if (!departmentRepository.existsById(departmentId)) {
            throw new ResourceNotFoundException("Department with Department Id " + departmentId + " does not exist");
        }
        Employee employee = mapStructMapper.createEmployeeDtoToEmployee(newEmployee);
        employee.setDepartment(departmentRepository.findById(departmentId).get());
        CreateEmployeeDto createEmployeeDto = mapStructMapper.employeeToCreateEmployeeDto(
                employeeRepository.save(employee)
        );
        createEmployeeDto.setDepartmentId(departmentId);
        return createEmployeeDto;
    }

    public CreateEmployeeDto updateEmployee(CreateEmployeeDto newEmployee, int employeeId) {
        int departmentId = newEmployee.getDepartmentId();
        if (!employeeRepository.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee with the Id " + employeeId + " does not exist.");
        }
        if (!departmentRepository.existsById(departmentId)) {
            throw new ResourceNotFoundException("Department with Department Id " + departmentId + " does not exist");
        }
        Employee employee = mapStructMapper.createEmployeeDtoToEmployee(newEmployee);
        employee.setId(employeeId);
        employee.setDepartment(departmentRepository.findById(departmentId).get());
        CreateEmployeeDto createEmployeeDto = mapStructMapper.employeeToCreateEmployeeDto(
                employeeRepository.save(employee)
        );
        createEmployeeDto.setDepartmentId(departmentId);
        return createEmployeeDto;
    }


    public void deleteEmployeeById(int employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee with Employee Id : " + employeeId + " dose not exist");
        }
        employeeRepository.deleteById(employeeId);
    }

    public void deleteAllEmployeesByDepartmentId(int departmentId) {
        if (employeeRepository.findByDepartmentId(departmentId) == null) {
            throw new ResourceNotFoundException("Employee with department id :" + departmentId + "does not exist");
        }
        employeeRepository.deleteAllByDepartmentId(departmentId);
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}