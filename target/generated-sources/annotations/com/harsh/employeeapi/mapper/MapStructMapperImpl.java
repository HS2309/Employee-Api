package com.harsh.employeeapi.mapper;

import com.harsh.employeeapi.dtos.CreateEmployeeDto;
import com.harsh.employeeapi.dtos.DepartmentDto;
import com.harsh.employeeapi.dtos.EmployeeDetailedDto;
import com.harsh.employeeapi.dtos.EmployeeDto;
import com.harsh.employeeapi.dtos.ProjectDto;
import com.harsh.employeeapi.dtos.ProjectWithEmployeeDto;
import com.harsh.employeeapi.model.Department;
import com.harsh.employeeapi.model.Employee;
import com.harsh.employeeapi.model.Project;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-02T12:22:25+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Private Build)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public EmployeeDetailedDto employeeWithDepartmentDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        String email = null;
        Date birthDate = null;
        Timestamp createdTime = null;
        Timestamp updatedTime = null;

        id = employee.getId();
        name = employee.getName();
        email = employee.getEmail();
        birthDate = employee.getBirthDate();
        createdTime = employee.getCreatedTime();
        updatedTime = employee.getUpdatedTime();

        DepartmentDto departmentDto = null;
        Set<ProjectDto> projectDtoList = null;

        EmployeeDetailedDto employeeDetailedDto = new EmployeeDetailedDto( id, name, email, birthDate, createdTime, updatedTime, departmentDto, projectDtoList );

        return employeeDetailedDto;
    }

    @Override
    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setName( employeeDto.getName() );
        employee.setEmail( employeeDto.getEmail() );
        employee.setBirthDate( employeeDto.getBirthDate() );
        employee.setCreatedTime( employeeDto.getCreatedTime() );
        employee.setUpdatedTime( employeeDto.getUpdatedTime() );

        return employee;
    }

    @Override
    public EmployeeDto employeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setName( employee.getName() );
        employeeDto.setEmail( employee.getEmail() );
        employeeDto.setBirthDate( employee.getBirthDate() );
        employeeDto.setCreatedTime( employee.getCreatedTime() );
        employeeDto.setUpdatedTime( employee.getUpdatedTime() );

        return employeeDto;
    }

    @Override
    public Employee createEmployeeDtoToEmployee(CreateEmployeeDto createEmployeeDto) {
        if ( createEmployeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( createEmployeeDto.getId() );
        employee.setName( createEmployeeDto.getName() );
        employee.setEmail( createEmployeeDto.getEmail() );
        employee.setBirthDate( createEmployeeDto.getBirthDate() );
        employee.setCreatedTime( createEmployeeDto.getCreatedTime() );
        employee.setUpdatedTime( createEmployeeDto.getUpdatedTime() );

        return employee;
    }

    @Override
    public CreateEmployeeDto employeeToCreateEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        CreateEmployeeDto createEmployeeDto = new CreateEmployeeDto();

        createEmployeeDto.setId( employee.getId() );
        createEmployeeDto.setName( employee.getName() );
        createEmployeeDto.setEmail( employee.getEmail() );
        createEmployeeDto.setBirthDate( employee.getBirthDate() );
        createEmployeeDto.setCreatedTime( employee.getCreatedTime() );
        createEmployeeDto.setUpdatedTime( employee.getUpdatedTime() );

        return createEmployeeDto;
    }

    @Override
    public Department departmentDtoToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( departmentDto.getId() );
        department.setName( departmentDto.getName() );
        department.setDescription( departmentDto.getDescription() );
        department.setCreatedTime( departmentDto.getCreatedTime() );
        department.setUpdatedTime( departmentDto.getUpdatedTime() );

        return department;
    }

    @Override
    public DepartmentDto departmentToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( department.getId() );
        departmentDto.setName( department.getName() );
        departmentDto.setDescription( department.getDescription() );
        departmentDto.setCreatedTime( department.getCreatedTime() );
        departmentDto.setUpdatedTime( department.getUpdatedTime() );

        return departmentDto;
    }

    @Override
    public Project projectWithEmployeeDtoToProject(ProjectWithEmployeeDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setEmployeeSet( employeeDtoToEmployee( projectDto.getEmployeeSet() ) );
        project.setId( projectDto.getId() );
        project.setName( projectDto.getName() );
        project.setDescription( projectDto.getDescription() );
        project.setActive( projectDto.isActive() );
        project.setCreatedTime( projectDto.getCreatedTime() );
        project.setUpdatedTime( projectDto.getUpdatedTime() );

        return project;
    }

    @Override
    public ProjectDto getProject(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( project.getId() );
        projectDto.setName( project.getName() );
        projectDto.setDescription( project.getDescription() );
        projectDto.setActive( project.isActive() );
        projectDto.setCreatedTime( project.getCreatedTime() );
        projectDto.setUpdatedTime( project.getUpdatedTime() );

        return projectDto;
    }

    @Override
    public ProjectWithEmployeeDto projectToProjectWithEmployeeDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectWithEmployeeDto projectWithEmployeeDto = new ProjectWithEmployeeDto();

        projectWithEmployeeDto.setId( project.getId() );
        projectWithEmployeeDto.setName( project.getName() );
        projectWithEmployeeDto.setDescription( project.getDescription() );
        projectWithEmployeeDto.setActive( project.isActive() );
        projectWithEmployeeDto.setCreatedTime( project.getCreatedTime() );
        projectWithEmployeeDto.setUpdatedTime( project.getUpdatedTime() );
        projectWithEmployeeDto.setEmployeeSet( getMyEmployees( project.getEmployeeSet() ) );

        return projectWithEmployeeDto;
    }

    @Override
    public List<DepartmentDto> getDepartmentDtoList(List<Department> departmentList) {
        if ( departmentList == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( departmentList.size() );
        for ( Department department : departmentList ) {
            list.add( departmentToDepartmentDto( department ) );
        }

        return list;
    }

    @Override
    public Set<ProjectDto> getProjectDtoSet(Set<Project> projectSet) {
        if ( projectSet == null ) {
            return null;
        }

        Set<ProjectDto> set = new HashSet<ProjectDto>( Math.max( (int) ( projectSet.size() / .75f ) + 1, 16 ) );
        for ( Project project : projectSet ) {
            set.add( getProject( project ) );
        }

        return set;
    }

    @Override
    public Set<EmployeeDto> getMyEmployees(Set<Employee> employeeSet) {
        if ( employeeSet == null ) {
            return null;
        }

        Set<EmployeeDto> set = new HashSet<EmployeeDto>( Math.max( (int) ( employeeSet.size() / .75f ) + 1, 16 ) );
        for ( Employee employee : employeeSet ) {
            set.add( employeeToEmployeeDto( employee ) );
        }

        return set;
    }

    @Override
    public Set<Employee> employeeDtoToEmployee(Set<EmployeeDto> employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Set<Employee> set = new HashSet<Employee>( Math.max( (int) ( employeeDto.size() / .75f ) + 1, 16 ) );
        for ( EmployeeDto employeeDto1 : employeeDto ) {
            set.add( employeeDtoToEmployee( employeeDto1 ) );
        }

        return set;
    }

    @Override
    public List<EmployeeDto> getAllEmployees(List<Employee> employeesDtoList) {
        if ( employeesDtoList == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employeesDtoList.size() );
        for ( Employee employee : employeesDtoList ) {
            list.add( employeeToEmployeeDto( employee ) );
        }

        return list;
    }

    @Override
    public List<ProjectDto> getProjectDtoList(List<Project> projectList) {
        if ( projectList == null ) {
            return null;
        }

        List<ProjectDto> list = new ArrayList<ProjectDto>( projectList.size() );
        for ( Project project : projectList ) {
            list.add( getProject( project ) );
        }

        return list;
    }
}
