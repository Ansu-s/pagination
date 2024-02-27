package com.example.pagination.repository;

import com.example.pagination.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
