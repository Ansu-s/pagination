package com.example.pagination.controller;

import com.example.pagination.dto.ResponseDTO;
import com.example.pagination.entity.EmployeeEntity;
import com.example.pagination.model.Employee;
import com.example.pagination.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/all")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmp(@RequestBody Employee employee){
        return employeeService.addEmp(employee);
    }

    @GetMapping
    public ResponseDTO<List<EmployeeEntity>> allEmp() {
        List<EmployeeEntity> allEmployees = employeeService.findAllEmployees();
        return new ResponseDTO<>(allEmployees.size(), allEmployees);
    }

    @GetMapping("/{field}")
    public ResponseDTO<List<EmployeeEntity>> sortedEmp(@PathVariable String field) {
        List<EmployeeEntity> allEmployeesSorted = employeeService.findByASpecificField(field);
        return new ResponseDTO<>(allEmployeesSorted.size(), allEmployeesSorted);
    }

    @GetMapping("/page/{offset}/{pageSize}")
    public ResponseDTO<Page<EmployeeEntity>> pagedEmp(@PathVariable int offset, @PathVariable int pageSize) {
        Page<EmployeeEntity> pagedEmp = employeeService.findEmpWithPagination(offset, pageSize);
        return new ResponseDTO<>(pagedEmp.getSize(), pagedEmp);
    }

    @GetMapping("/page/{field}/{offset}/{pageSize}")
    public ResponseDTO<Page<EmployeeEntity>> pagedEmp(@PathVariable String field, @PathVariable int offset, @PathVariable int pageSize) {
        Page<EmployeeEntity> pagedEmpSorted = employeeService.findEmpWithPaginationSort(offset, pageSize, field);
        return new ResponseDTO<>(pagedEmpSorted.getSize(), pagedEmpSorted);
    }

}
