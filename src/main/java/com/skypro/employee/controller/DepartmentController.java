package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //    GET http://localhost:8080/department/{id}/employees
// — возвращает список сотрудников по департаменту.
    @GetMapping("/department/{id}/employees")
    public HashSet<Employee> getDepEmployees(@PathVariable String id) {
        return (HashSet<Employee>) departmentService.getDepEmployees(Integer.parseInt(id));
    }

    //GET http://localhost:8080/department/{id}/salary/sum
// — возвращает сумму зарплат по департаменту.
    @GetMapping("/department/{id}/salary/sum")
    public float getDepSumSalary(@PathVariable String id) {
        return departmentService.getDepSumSalary(Integer.parseInt(id));
    }

//GET http://localhost:8080/department/{id}/salary/max
// — возвращает максимальную зарплату по департаменту.
    @GetMapping("/department/{id}/salary/max")
    public float getDepMaxSalary (@PathVariable String id) {
        return departmentService.getDepMaxSalary(Integer.parseInt(id));
    }

    //GET http://localhost:8080/department/{id}/salary/min
// — возвращает минимальную зарплату по департаменту.
    @GetMapping("/department/{id}/salary/min")
    public float getDepMinSalary(@PathVariable String id) {
        return departmentService.getDepMinSalary(Integer.parseInt(id));
    }

    //GET http://localhost:8080/department/employees
// — возвращает сотрудников, сгруппированых по отделам в виде Map<Integer,List<Employees>>, где ключ — это номер отдела, а значение — список сотрудников данного отдела.
    @GetMapping("/department/employees")
    public Map<Integer, List<Employee>> getDepsEmployees() {
        return departmentService.getDepsEmployees();
    }

}
