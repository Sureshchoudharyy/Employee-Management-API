package com.example.EmployeeAPI.Service;

import com.example.EmployeeAPI.Entity.Employee;
import com.example.EmployeeAPI.Repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found!"));
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found!"));

        emp.setEmpName(employee.getEmpName());
        emp.setSalary(employee.getSalary());
        emp.setEmpDepartment(employee.getEmpDepartment());

        return employeeRepo.save(emp);
    }

    public Employee deleteEmployee(Long id) {
        Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found!"));

        employeeRepo.delete(emp);
        return emp;
    }

    public Employee partialUpdate(Long id, Double salary, String empDepartment) {
        Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found!"));

        emp.setSalary(salary);
        emp.setEmpDepartment(empDepartment);
        return employeeRepo.save(emp);
    }

    public List<Employee> searchByFilter(String name, String dept, Double minSalary, Double maxSalary) {
        return employeeRepo.searchEmployees(name, dept, minSalary, maxSalary);
    }
}
