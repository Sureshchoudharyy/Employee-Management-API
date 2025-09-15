package com.example.EmployeeAPI.DTO;

public class EmployeeDTO {
    private Long id;
    private String empName;
    private Double salary;
    private String empDepartment;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String empName, Double salary, String empDepartment) {
        this.id = id;
        this.empName = empName;
        this.salary = salary;
        this.empDepartment = empDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }
}
