package harsh.projects.employeeapi.services;

import harsh.projects.employeeapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    @Autowired
    EmployeeRepository employeeRepository;
    List<Employee>employeeList = new ArrayList<>();
    public Optional<Employee> findByEmployeeId(int id) {
        return employeeRepository.findById(id);
    }
    public List<Employee> getAllEmployee(){
        List<Employee> employeeList=new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }
    public void createEmployee(Employee e){
        employeeRepository.save(e);
    }
    public void updateEmployee(Employee e,int id){
        e.setId(id);
        employeeRepository.save(e);
    }
    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
}