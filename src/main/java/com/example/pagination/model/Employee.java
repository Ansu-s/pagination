package com.example.pagination.model;

import com.example.pagination.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String designation;

    public EmployeeEntity toEntity() {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDesignation(this.getDesignation());
        return entity;
    }

    public Employee fromEntity(EmployeeEntity employeeEntity) {
        this.setId(this.getId());
        this.setName(this.getName());
        this.setDesignation(this.getDesignation());
        return this;
    }
}
