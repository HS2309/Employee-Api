package harsh.projects.employeeapi.services;

import harsh.projects.employeeapi.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
