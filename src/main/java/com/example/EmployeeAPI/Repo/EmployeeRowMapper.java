package com.example.EmployeeAPI.Repo;

import com.example.EmployeeAPI.DTO.EmployeeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeRowMapper implements RowMapper<EmployeeDTO> {

    @Override
    public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDTO e = new EmployeeDTO();
        e.setId(rs.getLong("id"));
        e.setEmpName(rs.getString("emp_name"));
        e.setSalary(rs.getDouble("salary"));
        e.setEmpDepartment(rs.getString("emp_department"));
        return e;
    }
}
