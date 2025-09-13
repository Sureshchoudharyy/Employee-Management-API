package com.example.EmployeeAPI.Repo;

import com.example.EmployeeAPI.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE " +
            "(:name IS NULL OR LOWER(e.empName) = LOWER(:name)) AND " +
            "(:dept IS NULL OR LOWER(e.empDepartment) = LOWER(:dept)) AND " +
            "(:minSalary IS NULL OR e.salary >= :minSalary) AND " +  
            "(:maxSalary IS NULL OR e.salary <= :maxSalary)")
    List<Employee> searchEmployees(
            @Param("name") String name,
            @Param("dept") String dept,
            @Param("minSalary") Double minSalary,
            @Param("maxSalary") Double maxSalary
    );

}

