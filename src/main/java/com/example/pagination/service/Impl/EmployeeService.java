package com.example.pagination.service.Impl;

import com.example.pagination.entity.EmployeeEntity;
import com.example.pagination.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public void addEmployees() {
        List<EmployeeEntity> employeeList = generateEmployeeList(100);
        employeeRepository.saveAll(employeeList);
    }

    private List<EmployeeEntity> generateEmployeeList(int count) {
        List<EmployeeEntity> employees = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            EmployeeEntity employee = new EmployeeEntity();
            employee.setId((long) i);
            employee.setName("EMP" + i);
            employee.setDesignation("Employee");
            employees.add(employee);
        }
        return employees;
    }

    public List<EmployeeEntity> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
