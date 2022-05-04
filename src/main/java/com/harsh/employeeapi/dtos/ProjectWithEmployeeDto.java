package com.harsh.employeeapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Set;

public class ProjectWithEmployeeDto {

    private int id;

    private String name;

    private String description;

    @JsonProperty("active")
    private boolean isActive;

    @JsonProperty("created-time")
    private Timestamp createdTime;

    @JsonProperty("updated-time")
    private Timestamp updatedTime;

    @JsonProperty("employee")
    private Set<EmployeeDto> employeeSet;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Set<EmployeeDto> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<EmployeeDto> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public ProjectWithEmployeeDto(){

    }

    public ProjectWithEmployeeDto(int id, String name, String description, boolean isActive, Timestamp createdTime, Timestamp updatedTime, Set<EmployeeDto> employeeSet) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.employeeSet = employeeSet;
    }
}
