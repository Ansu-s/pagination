package com.example.pagination.controller;

import com.example.pagination.dto.ResponseDTO;
import com.example.pagination.entity.EmployeeEntity;
import com.example.pagination.service.Impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping
//    public List<EmployeeEntity> allEmp(){
//        employeeService.addEmployees();
//        return  employeeService.findAllEmployees();
//    }
    @GetMapping
    public ResponseDTO<List<EmployeeEntity>> allEmp(){
        List<EmployeeEntity> allEmployees = employeeService.findAllEmployees();
        return  new ResponseDTO<>(allEmployees.size(), allEmployees);
    }
}
