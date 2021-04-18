package com.shahzad.repository;

import com.shahzad.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shahzad.hussain 
 */

public interface DepartmentRepository extends JpaRepository<Department, Long>{
}