package com.shahzad.repository;

import com.shahzad.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shahzad.hussain 
 */

public interface TestRepository extends JpaRepository<Test, Long>{
}