package com.harsh.employeeapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class DepartmentWithEmployeeListDto {

    @JsonProperty("department")
    private DepartmentDto department;

    @JsonProperty("employee")
    private List<EmployeeDto> employees;

    // Getters and Setters
    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
