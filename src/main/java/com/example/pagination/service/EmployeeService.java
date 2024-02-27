package com.example.pagination.service;

import com.example.pagination.entity.EmployeeEntity;
import com.example.pagination.model.Employee;
import com.example.pagination.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmp(Employee employee) {
        EmployeeEntity entity = employee.toEntity();
        entity = employeeRepository.save(entity);
        return employee.fromEntity(entity);
    }

    public List<EmployeeEntity> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<EmployeeEntity> findByASpecificField(String field) {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<EmployeeEntity> findEmpWithPagination(int offset, int pageSize) {
        Page<EmployeeEntity> pagedEmployeeEntities = employeeRepository.findAll(PageRequest.of(offset, pageSize));
        return pagedEmployeeEntities;
    }

    public Page<EmployeeEntity> findEmpWithPaginationSort(int offset, int pageSize, String field) {
        Page<EmployeeEntity> pagedEmployeeEntitiesSorted = employeeRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return pagedEmployeeEntitiesSorted;
    }

    @PostConstruct
    public void addEmployees() {
        List<EmployeeEntity> employeeList = generateEmployeeList(200);
        employeeRepository.saveAll(employeeList);
    }

    private List<EmployeeEntity> generateEmployeeList(int count) {
        List<EmployeeEntity> employees = new ArrayList<>();
        EmployeeEntity employee = null;
        for (int i = 1; i <= count; i++) {
            employee = new EmployeeEntity();
            employee.setId((long) i);
            employee.setName("EMP" + i);
            if (i % 2 == 0) {
                employee.setDesignation("Engineer");
            } else employee.setDesignation("Manager");
            employees.add(employee);
        }
        return employees;
    }
}
