package ems.demo.springproject.service;

import ems.demo.springproject.entityvalues.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private final List<Employee> employees =new ArrayList<>();
    private int currendId=1;
    public List<Employee>getAllEmployees(){
        return employees;
    }
    public Employee getEmployeeById(int id){
        return employees.stream()
                .filter(emp ->emp.getId()==id)
                .findFirst()
                .orElse(null);
    }
    public Employee saveEmployee(Employee employee){
        if(employee.getId()==0){
            employee.setId(currendId++);
            employees.add(employee);
        }
        return employee;
    }
    public void deleteEmployee(int id){
        employees.removeIf(emp->emp.getId()==id);
    }
}
