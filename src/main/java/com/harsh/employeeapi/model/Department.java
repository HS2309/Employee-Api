package com.harsh.employeeapi.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "department_description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_time",updatable = false,columnDefinition = "timestamp default current_timestamp")
    private Timestamp createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time",columnDefinition = "timestamp default current_timestamp")
    private Timestamp updatedTime;

    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
    private List<Employee> employee = new ArrayList<>();

    public Department() {
    }

    public Department(int id){
        super();
        this.id = id;
    }
    public Department(int id,
                      String name,
                      String description,
                      Timestamp createdTime,
                      Timestamp updatedTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + id +
                ", departmentName='" + name + '\'' +
                ", departmentDescription='" + description + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
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

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}