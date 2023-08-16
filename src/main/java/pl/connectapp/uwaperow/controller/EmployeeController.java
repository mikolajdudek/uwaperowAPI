package pl.connectapp.uwaperow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.connectapp.uwaperow.model.Employee;
import pl.connectapp.uwaperow.service.EmployeeService;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employes")
    public List<Employee> getEmployes(){
        return employeeService.getEmploye();
    }

    @GetMapping("/employes/{id}")
    public Employee getEmployesById(@PathVariable long id){
        return employeeService.getEmployeById(id);
    }

    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(){
        employeeService.deleteEmployee();
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployeeById(id);
    }
}
