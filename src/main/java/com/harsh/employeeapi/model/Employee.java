package com.harsh.employeeapi.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

    @CreationTimestamp
    @Column(name = "created_time",insertable = true,updatable = false,columnDefinition = "timestamp default current_timestamp")
    private Timestamp createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time",columnDefinition = "timestamp default current_timestamp")
    private Timestamp updatedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToMany(mappedBy = "employeeSet",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Set<Project> projectSet;

    public Department getDepartment() {
        return department;
    }

    public Set<Project> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }

    public Employee() {
    }
    public Employee(int id){
        this.id = id;
    }

    public Employee(int id,
                    String name,
                    String email,
                    Date birthDate,
                    Timestamp createdTime,
                    Timestamp updatedTime,
                    Department departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.department = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + id +
                ", employeeName='" + name + '\'' +
                ", employeeEmail='" + email + '\'' +
                ", employeeBirthDate=" + birthDate +
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
}