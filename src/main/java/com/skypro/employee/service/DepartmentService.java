package com.skypro.employee.service;

import com.skypro.employee.model.Employee;

import java.util.*;

public class DepartmentService {

    public DepartmentService() {
    }

    public final EmployeeService employeeService = new EmployeeService();

    public Collection<Employee> getDepEmployees(int id) {
        HashSet<Employee> result = new HashSet<>();
        Collection<Employee> all = employeeService.getAllEmployees();
        for (Employee emp :
                all) {
            if (emp.getDepartment() == id) {
                result.add(emp);
            }
        }
        return result;
    }

    public float getDepSumSalary(int id) {
        float result = 0;
        Set<Employee> all = (HashSet<Employee>) getDepEmployees(id);
        for (Employee emp :
                all) {
                result += emp.getSalary();
        }
        return result;
    }

    public float getDepMaxSalary(int id) {
        float result = 0;
        Set<Employee> all = (HashSet<Employee>) getDepEmployees(id);
        for (Employee emp :
                all) {
            if (result < emp.getSalary()) {
                result = emp.getSalary();
            }
        }
        return result;

    }

    public float getDepMinSalary(int id) {
        List<Employee> all = (ArrayList<Employee>) getDepEmployees(id);
        float min = all.get(0).getSalary();
        for (Employee emp :
                all) {
            if (min > emp.getSalary()) {
                min = emp.getSalary();
            }
        }
        return min;
    }

    public Map<Integer, List<Employee>> getDepsEmployees() {
        Collection<Employee> all = employeeService.getAllEmployees();
        List<Integer> deps = new ArrayList<>();
        Map<Integer, List<Employee>> result = new HashMap<>();
        for (Employee emp :
                all) {
            if (!deps.contains(emp.getDepartment())) {
                deps.add(emp.getDepartment());
            }
        }
        for (Integer i :
                deps) {
            result.put(i, (List<Employee>) getDepEmployees(i));
        }
        return result;
    }
}
