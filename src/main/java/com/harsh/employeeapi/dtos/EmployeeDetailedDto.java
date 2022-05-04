package com.harsh.employeeapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

public class EmployeeDetailedDto {

    private int id;

    private String name;

    private String email;

    @JsonProperty("birth-date")
    private Date birthDate;

    @JsonProperty("created-time")
    private Timestamp createdTime;

    @JsonProperty("updated-time")
    private Timestamp updatedTime;

    @JsonProperty("Department")
    private DepartmentDto departmentDto;

    @JsonProperty("Projects")
    private Set<ProjectDto> projectDtoList;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public Set<ProjectDto> getProjectDtoList() {
        return projectDtoList;
    }

    public void setProjectDtoList(Set<ProjectDto> projectDtoList) {
        this.projectDtoList = projectDtoList;
    }


    public EmployeeDetailedDto(int id, String name, String email, Date birthDate, Timestamp createdTime, Timestamp updatedTime, DepartmentDto departmentDto, Set<ProjectDto> projectDtoList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.departmentDto = departmentDto;
        this.projectDtoList = projectDtoList;
    }
}
