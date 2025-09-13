package com.example.EmployeeAPI.Controller;

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
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestParam Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping
    public Employee deleteEmployee(@RequestParam Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PatchMapping
    public Employee PartialUpdate(@RequestParam Long id,@RequestParam Double salary,@RequestParam String empDepartment){
        return employeeService.partialUpdate(id, salary,empDepartment);
    }

//    @GetMapping("/search")
//    public List<Employee> searchByFilter(@RequestParam String name,@RequestParam String dept){
//        return employeeService.searchByFilter(name,dept);
//    }

//    @GetMapping("/search/name")
//    public List<Employee> searchByName(@RequestParam String name){
//        return employeeService.searchByName(name);
//    }

    @GetMapping("/search")
    public List<Employee> searchByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String dept,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary) {
        return employeeService.searchByFilter(name, dept, minSalary, maxSalary);
    }

}
