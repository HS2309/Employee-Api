package com.harsh.employeeapi.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int id;

    private String name;

    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "created_time",
            updatable = false,
            columnDefinition = "timestamp default current_timestamp")
    private Timestamp createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time",
            columnDefinition = "timestamp default current_timestamp")
    private Timestamp updatedTime;

    @ManyToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_projects",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private Set<Employee> employeeSet;

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Project() {
    }

    public Project(int id,
                   String name,
                   String description,
                   boolean isActive,
                   Timestamp createdTime,
                   Timestamp updatedTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

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

}