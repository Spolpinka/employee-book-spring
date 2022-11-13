package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("name should be set");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(), employeeRequest.getLastName(),
                employeeRequest.getDepartment(), employeeRequest.getSalary());
        employees.put(employee.getId(), employee);
        return employee;
    }

    public int sum() {
        int sum = 0;
        for (Map.Entry<Integer, Employee> entry :
                employees.entrySet()) {
            sum += entry.getValue().getSalary();
        }
        return sum;
    }

    public Employee min() {
        int minSalary = sum();
        Employee minEmp = null;
        for (Map.Entry<Integer, Employee> entry :
                employees.entrySet()) {
            if (entry.getValue().getSalary() < minSalary) {
                minSalary = entry.getValue().getSalary();
                minEmp = entry.getValue();
            }
        }
        return minEmp;
    }

    public Employee max() {
        int max = 0;
        Employee maxEmp = null;
        for (Map.Entry<Integer, Employee> entry :
                employees.entrySet()) {
            if (entry.getValue().getSalary() > max) {
                max = entry.getValue().getSalary();
                maxEmp = entry.getValue();
            }
        }
        return maxEmp;
    }

    public List<Employee> highSalary() {
        List<Employee> employeeList = new ArrayList<>();
        float medium = mediumSalary();
        for (Map.Entry<Integer, Employee> entry :
                employees.entrySet()) {
            if (entry.getValue().getSalary() > medium) {
                employeeList.add(entry.getValue());
            }
        }
        return employeeList;
    }

    public float mediumSalary() {
        int sum = 0;
        for (Map.Entry<Integer, Employee> entry:
                employees.entrySet()) {
            sum += entry.getValue().getSalary();
        }
        return sum / employees.size();
    }
}
