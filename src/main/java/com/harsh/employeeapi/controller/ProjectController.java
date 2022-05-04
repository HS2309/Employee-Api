package com.harsh.employeeapi.controller;

import com.harsh.employeeapi.dtos.ProjectDto;
import com.harsh.employeeapi.dtos.ProjectWithEmployeeDto;
import com.harsh.employeeapi.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectServices projectServices;

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectWithEmployeeDto> getProjectById(@PathVariable int projectId){
        return  ResponseEntity.of(projectServices.getProjectById(projectId));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
        return ResponseEntity.ok(projectServices.getAllProjects());
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectWithEmployeeDto postProject){
        return ResponseEntity.ok(projectServices.createProject(postProject));
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectWithEmployeeDto postProject, @PathVariable int projectId){
        return ResponseEntity.ok(projectServices.updateProject(postProject,projectId));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable int projectId){
        projectServices.deleteProjectById(projectId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllProjects(){
        projectServices.deleteAllProjects();
        return ResponseEntity.ok().build();
    }
}