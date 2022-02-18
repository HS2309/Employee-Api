package harsh.projects.employeeapi.controller;

import harsh.projects.employeeapi.model.Employee;
import harsh.projects.employeeapi.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeServices employeeServices;
    @RequestMapping("/api/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeServices.findByEmployeeId(id);
    }
    @RequestMapping("/api/employeelist")
    public List<Employee> getAllEmployee(){
        return employeeServices.getAllEmployee();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/employee")
    public void createEmployee(@RequestBody Employee e){
        employeeServices.createEmployee(e);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/api/employee/{id}")
    public void updateEmployee(@RequestBody Employee e,@PathVariable int id){
        employeeServices.updateEmployee(e,id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/api/employee/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeServices.deleteEmployee(id);
    }
}
