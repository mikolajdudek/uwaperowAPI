package pl.connectapp.uwaperow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.connectapp.uwaperow.model.Employee;
import pl.connectapp.uwaperow.repository.EmployeeRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    public final EmployeeRepository employeeRepository;

    public List<Employee> getEmploye() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeById(long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public void deleteEmployeeById(long id){
        employeeRepository.deleteById(id);
    }

    public void deleteEmployee(){
        employeeRepository.deleteAll();
    }
}
