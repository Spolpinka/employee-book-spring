package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * HTTP методы
 * GET - получение ресурса или набора ресурсов
 * POST - создание ресурса
 * PUT - модификация ресурса
 * PATCH - частичная модификация ресурса
 * DELETE - удаление ресурса
 */

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try {
            return employeeService.addEmployee(employeeRequest);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return null;
    }
    @GetMapping("/employee/salary/sum")
    public int sum() {
        return employeeService.sum();
    }
    @GetMapping("/employee/salary/min")
    public Employee min() {
        return employeeService.min();
    }

    @GetMapping("/employee/salary/max")
    public Employee max() {
        return employeeService.max();
    }
    @GetMapping("/employee/high-salary")
    public List<Employee> highSalary() {
        return employeeService.highSalary();
    }
}
