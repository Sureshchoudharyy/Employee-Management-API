package com.example.EmployeeAPI.Controller;

import com.example.EmployeeAPI.DTO.EmployeeDTO;
import com.example.EmployeeAPI.Entity.Employee;
import com.example.EmployeeAPI.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public int createEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public int updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public int deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

//    @PatchMapping
//    public Employee PartialUpdate(@RequestParam Long id,@RequestParam Double salary,@RequestParam String empDepartment){
//        return employeeService.partialUpdate(id, salary,empDepartment);
//    }
//
//    @GetMapping("/search")
//    public List<Employee> searchByFilter(
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String dept,
//            @RequestParam(required = false) Double minSalary,
//            @RequestParam(required = false) Double maxSalary) {
//        return employeeService.searchByFilter(name, dept, minSalary, maxSalary);
//    }

}
