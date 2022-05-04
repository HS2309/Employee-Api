package com.harsh.employeeapi.services;

import com.harsh.employeeapi.dtos.DepartmentDto;
import com.harsh.employeeapi.model.Department;
import com.harsh.employeeapi.repository.EmployeeRepository;
import com.harsh.employeeapi.dtos.DepartmentWithEmployeeListDto;
import com.harsh.employeeapi.exception.DuplicateIdException;
import com.harsh.employeeapi.exception.ResourceNotFoundException;
import com.harsh.employeeapi.mapper.MapStructMapper;
import com.harsh.employeeapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    MapStructMapper mapStructMapper;


    public List<DepartmentDto> getAllDepartments(){
        return mapStructMapper.getDepartmentDtoList((List<Department>) departmentRepository.findAll());
    }

    public Optional<DepartmentWithEmployeeListDto> getDepartmentById(int departmentId){
        DepartmentWithEmployeeListDto DepartmentWithEmployeeListDto = new DepartmentWithEmployeeListDto();
        Department department = departmentRepository.findById(departmentId).
                orElseThrow(()->new ResourceNotFoundException("Department with Department Id "+ departmentId+" does not exist"));

        DepartmentWithEmployeeListDto.setDepartment(mapStructMapper.departmentToDepartmentDto( department ));
        DepartmentWithEmployeeListDto.setEmployees(mapStructMapper.getAllEmployees(department.getEmployee()));
        return Optional.of(DepartmentWithEmployeeListDto);
    }

    public DepartmentDto createDepartment(DepartmentDto departmentDto){
        int departmentId = departmentDto.getId();
        if(employeeRepository.existsById(departmentId))
        {
            throw new DuplicateIdException("Department with the Id "+departmentDto.getId()+" already exist.");
        }
        Department department = mapStructMapper.departmentDtoToDepartment(departmentDto);
        return mapStructMapper.departmentToDepartmentDto(departmentRepository.save(department));
    }

    public DepartmentDto updateDepartment(DepartmentDto departmentDto,int departmentId){
       if(!departmentRepository.existsById(departmentId))
        {
            throw new ResourceNotFoundException("Department with the Id "+departmentId+" does not exist.");
        }
        departmentDto.setId(departmentId);
        Department department = mapStructMapper.departmentDtoToDepartment(departmentDto);
        return mapStructMapper.departmentToDepartmentDto(departmentRepository.save(department));
    }

    public void deleteDepartmentById(int departmentId){
        if(!departmentRepository.existsById(departmentId))
        {
            throw new ResourceNotFoundException("Department with Department Id "+departmentId+" does not exist");
        }
        departmentRepository.deleteById(departmentId);
    }

    public void deleteAllDepartments(){
        departmentRepository.deleteAll();
    }
}