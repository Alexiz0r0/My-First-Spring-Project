package com.project.empleadoservice.service;

import com.project.empleadoservice.entity.Employee;
import com.project.empleadoservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee save(Employee employee){
        Employee employeeNew = employeeRepository.save(employee);
        return employeeNew;
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Optional<Employee> getById(Integer id){
        return employeeRepository.findById(id);
    }
}
