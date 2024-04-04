package com.example.service;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.example.entity.Employee;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class EmployeeService {

    private final CqlSession cqlSession;
    private final PreparedStatement insertStatement;
    private final PreparedStatement updateStatement;
    private final PreparedStatement deleteStatement;

    private final PreparedStatement getStatement;


    public EmployeeService(CqlSessionBuilder cqlSessionBuilder) {
        this.cqlSession = cqlSessionBuilder.build();
        this.insertStatement = cqlSession.prepare("INSERT INTO scylla_demo.emp (eid, name, department) VALUES (?, ?, ?)");
        this.updateStatement = cqlSession.prepare("UPDATE scylla_demo.emp SET department = ? WHERE eid = ? and name =? ");
        this.deleteStatement = cqlSession.prepare("DELETE FROM scylla_demo.emp WHERE eid = ? and name =? ");
        this.getStatement = cqlSession.prepare("SELECT * FROM scylla_demo.emp");

    }

    public Employee insertEmployee(Employee employee) {
        cqlSession.execute(insertStatement.bind(employee.getEid(), employee.getName(), employee.getDepartment()));
        return employee;
    }

  public Employee updateEmployee(int id, String name, Employee employee) {
        cqlSession.execute(updateStatement.bind(employee.getDepartment(), id, name));
        return employee;
    }


    public void deleteEmployee(int id) {
        cqlSession.execute(deleteStatement.bind(id));
    }

    public List<Employee> getAllEmployees() {
        ResultSet resultSet = cqlSession.execute(getStatement.bind());
        List<Employee> employees = new ArrayList<>();

        for (Row row : resultSet) {
            Employee employeeDTO = new Employee();
            employeeDTO.setEid(row.getInt("eid"));
            employeeDTO.setName(row.getString("name"));
            employeeDTO.setDepartment(row.getString("department"));
            employees.add(employeeDTO);
        }

        return employees;
    }
}





