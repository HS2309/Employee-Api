package com.harsh.employeeapi.services;

import com.harsh.employeeapi.dtos.ProjectWithEmployeeDto;
import com.harsh.employeeapi.dtos.ProjectDto;
import com.harsh.employeeapi.exception.ResourceNotFoundException;
import com.harsh.employeeapi.mapper.MapStructMapper;
import com.harsh.employeeapi.model.Project;
import com.harsh.employeeapi.repository.EmployeeRepository;
import com.harsh.employeeapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProjectServices {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<ProjectDto> getAllProjects(){
        return mapStructMapper.getProjectDtoList((List<Project>)projectRepository.findAll());
    }

    public Optional<ProjectWithEmployeeDto> getProjectById(int projectId){
        Project project = projectRepository.findById(projectId).orElseThrow(()-> new ResourceNotFoundException("Project with project Id : "+projectId+" does not exist."));
        ProjectWithEmployeeDto projectWithEmployeeDto = mapStructMapper.projectToProjectWithEmployeeDto(project);
        projectWithEmployeeDto.setEmployeeSet(mapStructMapper.getMyEmployees(project.getEmployeeSet()));
        return Optional.of(projectWithEmployeeDto);
    }

    public ProjectDto createProject(ProjectWithEmployeeDto postProject){
        List<Integer> employeeIds = employeeRepository.findAllIds();
        List<Integer> nonExistentEmployeeIds=postProject.getEmployeeSet().stream().
                flatMap(t-> Stream.of(t.getId())).
                filter(t -> !employeeIds.contains(t)).collect(Collectors.toList());
        if(!nonExistentEmployeeIds.isEmpty()){
            throw new ResourceNotFoundException("Employees With Id :"+nonExistentEmployeeIds+" does not exist.");
        }
        Project project = mapStructMapper.projectWithEmployeeDtoToProject(postProject);
        project.setEmployeeSet(mapStructMapper.employeeDtoToEmployee(postProject.getEmployeeSet()));
        projectRepository.save(project);
        return mapStructMapper.getProject(project);
    }

    public ProjectDto updateProject(ProjectWithEmployeeDto postProject, int projectId) {
        if(!projectRepository.existsById(projectId)) {
            throw new ResourceNotFoundException("Project with Project Id "+projectId+" does not exist");
        }
        List<Integer> employeeIds = employeeRepository.findAllIds();
        List<Integer> nonExistentEmployeeIds=postProject.getEmployeeSet().stream().
                flatMap(t-> Stream.of(t.getId())).
                filter(t -> !employeeIds.contains(t)).collect(Collectors.toList());
        if(!nonExistentEmployeeIds.isEmpty()){
            throw new ResourceNotFoundException("Employees With Id :"+nonExistentEmployeeIds+" does not exist.");
        }
        postProject.setId(projectId);
        Project project = mapStructMapper.projectWithEmployeeDtoToProject(postProject);
        projectRepository.save(project);
        return mapStructMapper.getProject(project);
    }

    public void deleteProjectById(int projectId) {
        if(!projectRepository.existsById(projectId)) {
            throw new ResourceNotFoundException("Project with Project Id "+projectId+" does not exist");
        }
        projectRepository.deleteById(projectId);
    }

    public void deleteAllProjects(){
        projectRepository.deleteAll();
    }
}