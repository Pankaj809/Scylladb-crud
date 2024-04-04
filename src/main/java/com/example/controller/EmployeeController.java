package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import io.micronaut.http.annotation.*;

import java.util.List;

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

 @Put("/update/{id}")
    public Employee updateEmployee(int id, @Body Employee employee){
        return employeeService.updateEmployee(id, employee.getName(),employee);
    }

    @Post("/delete/{id}")
    public void deleteEmployee(int id){
        employeeService.deleteEmployee(id);
    }

    @Get("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
