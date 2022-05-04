package com.harsh.employeeapi.mapper;

import com.harsh.employeeapi.dtos.*;
import com.harsh.employeeapi.model.Department;
import com.harsh.employeeapi.model.Employee;
import com.harsh.employeeapi.model.Project;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    // Entity --> DTO
    EmployeeDetailedDto employeeWithDepartmentDto(Employee employee);
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
    EmployeeDto employeeToEmployeeDto(Employee employee);
    Employee createEmployeeDtoToEmployee(CreateEmployeeDto createEmployeeDto);
    CreateEmployeeDto employeeToCreateEmployeeDto(Employee employee);

    Department departmentDtoToDepartment(DepartmentDto departmentDto);
    DepartmentDto departmentToDepartmentDto(Department department);

    Project projectWithEmployeeDtoToProject(ProjectWithEmployeeDto projectDto);
    ProjectDto getProject(Project project);
    ProjectWithEmployeeDto projectToProjectWithEmployeeDto(Project project);

    // collection conversions between Entity and DTO
    List<DepartmentDto> getDepartmentDtoList(List<Department> departmentList);
    Set<ProjectDto> getProjectDtoSet(Set<Project> projectSet);
    Set<EmployeeDto> getMyEmployees(Set<Employee> employeeSet);
    Set<Employee> employeeDtoToEmployee(Set<EmployeeDto> employeeDto);
    List<EmployeeDto> getAllEmployees(List<Employee> employeesDtoList);
    List<ProjectDto> getProjectDtoList(List<Project> projectList);

}