package com.project.empleadoservice.controller;

import com.project.empleadoservice.entity.Employee;
import com.project.empleadoservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees = employeeService.getAll();
        if (employees.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Integer id){
        Employee employees = employeeService.getEmployeeById(id);
        if (employees == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

    @PostMapping()
    public ResponseEntity<Employee> getById(@RequestBody Employee employee){
        Employee newEmployee = employeeService.save(employee);
        return ResponseEntity.ok(newEmployee);
    }
}
