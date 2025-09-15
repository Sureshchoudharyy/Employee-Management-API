package com.example.EmployeeAPI.Service;

import com.example.EmployeeAPI.DTO.EmployeeDTO;
import com.example.EmployeeAPI.Entity.Employee;
import com.example.EmployeeAPI.Repo.EmployeeJdbcRepo;
import com.example.EmployeeAPI.Repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeJdbcRepo employeeJdbcRepo;
//    private EmployeeRepo employeeRepo;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeJdbcRepo.findAll();
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeJdbcRepo.findById(id);
    }

    @Transactional
    public int createEmployee(EmployeeDTO employee) {
        return employeeJdbcRepo.create(employee);
    }

    public int updateEmployee(EmployeeDTO employee) {
        return employeeJdbcRepo.update(employee);
    }

    public int deleteEmployee(Long id) {
        return employeeJdbcRepo.delete(id);
    }

//    public Employee partialUpdate(Long id, Double salary, String empDepartment) {
//        Employee emp = employeeRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found!"));
//
//        emp.setSalary(salary);
//        emp.setEmpDepartment(empDepartment);
//        return employeeRepo.save(emp);
//    }
//
//    public List<Employee> searchByFilter(String name, String dept, Double minSalary, Double maxSalary) {
//        return employeeRepo.searchEmployees(name, dept, minSalary, maxSalary);
//    }
}
