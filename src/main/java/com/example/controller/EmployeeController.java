package com.example.controller;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.example.entity.Employee;
import com.example.service.EmployeeService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Post("/create")
    public Employee createEmployee(@Body Employee employee){
        return employeeService.insertEmployee(employee);
    }

    @Post("/update")
    public Employee updateEmployee(@Body Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @Post("/delete/{id}")
    public void deleteEmployee(int id){
        employeeService.deleteEmployee(id);
    }

    @Get("/all")
    public ResultSet getAllEmployees(Employee employee){
        return employeeService.getEmployee(employee);
    }
}
