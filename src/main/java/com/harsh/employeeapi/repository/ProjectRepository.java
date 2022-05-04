package com.harsh.employeeapi.repository;

import com.harsh.employeeapi.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Integer> {
}
