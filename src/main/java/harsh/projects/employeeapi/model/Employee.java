package harsh.projects.employeeapi.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private int id;
    private String name;
    private String email;
    private LocalDate birth_date;
    @CreationTimestamp
    @Column(insertable = true,updatable = false)
    private LocalTime created_time;
    @UpdateTimestamp
    private LocalTime updated_time;

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

    public Employee() {
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public LocalTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalTime created_time) {
        this.created_time = created_time;
    }

    public LocalTime getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(LocalTime updated_time) {
        this.updated_time = updated_time;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", created_time='" + created_time + '\'' +
                ", updated_time='" + updated_time + '\'' +
                '}';
    }
}
