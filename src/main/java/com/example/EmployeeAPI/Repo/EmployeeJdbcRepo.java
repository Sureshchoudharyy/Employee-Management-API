package com.example.EmployeeAPI.Repo;

import com.example.EmployeeAPI.DTO.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJdbcRepo {

    private final JdbcTemplate jdbcTemplate;
    private EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();

    public EmployeeJdbcRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<EmployeeDTO> findAll(){
        String sql_query = "select * from employee";
        return jdbcTemplate.query(sql_query,employeeRowMapper);
    }

    public EmployeeDTO findById(Long id){
        String sql_query = "select * from employee where id=?";
        return jdbcTemplate.queryForObject(sql_query,employeeRowMapper,id);
    }

    public int create(EmployeeDTO e){
        String sql_query = "insert into employee(emp_name,salary,emp_department) values (?,?,?)";
        return jdbcTemplate.update(sql_query,e.getEmpName(),e.getSalary(),e.getEmpDepartment());
    }

    public int update(EmployeeDTO e){
        String sql_query = "update employee set emp_name = ?, salary = ?, emp_department = ? where id=?";
        return jdbcTemplate.update(sql_query, e.getEmpName(),e.getSalary(),e.getEmpDepartment(),e.getId());
    }

    public int delete(Long id){
        String sql_query = "delete from employee where id=?";
        return jdbcTemplate.update(sql_query,id);
    }
}
