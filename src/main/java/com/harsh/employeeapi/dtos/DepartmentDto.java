package com.harsh.employeeapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

public class DepartmentDto {

    private int id;

    private String name;

    private String description;

    @JsonProperty("created-time")
    private Timestamp createdTime;

    @JsonProperty("updated-time")
    private Timestamp updatedTime;

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
}
