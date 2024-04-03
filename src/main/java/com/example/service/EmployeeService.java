package com.example.service;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.example.entity.Employee;

import jakarta.inject.Singleton;

@Singleton
public class EmployeeService {

    private final CqlSession cqlSession;
    private final PreparedStatement insertStatement;
    private final PreparedStatement updateStatement;
    private final PreparedStatement deleteStatement;

    private final PreparedStatement getEmployee;

    public EmployeeService(CqlSessionBuilder cqlSessionBuilder) {
        this.cqlSession = cqlSessionBuilder.build();
        this.insertStatement = cqlSession.prepare("INSERT INTO scylla_demo.emp (eid, name, department) VALUES (?, ?, ?)");
        this.updateStatement = cqlSession.prepare("UPDATE scylla_demo.emp SET department = ? WHERE eid = ? and name =? ");
        this.deleteStatement = cqlSession.prepare("DELETE FROM scylla_demo.emp WHERE eid = ? and name =? ");
        this.getEmployee = cqlSession.prepare("SELECT * FROM scylla_demo.emp WHERE eid = ? and name = ?");

    }

    public Employee insertEmployee(Employee employee) {
        cqlSession.execute(insertStatement.bind(employee.getEid(), employee.getName(), employee.getDepartment()));
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        cqlSession.execute(updateStatement.bind(employee.getDepartment(), employee.getEid()));
        return employee;
    }

    public void deleteEmployee(int id) {
        cqlSession.execute(deleteStatement.bind(id));
    }

    public ResultSet getEmployee(Employee employee) {
        return cqlSession.execute(getEmployee.bind(employee.getEid(), employee.getName()));


    }

}
