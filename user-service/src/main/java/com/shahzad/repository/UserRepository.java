package com.shahzad.repository;

import com.shahzad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shahzad.hussain
 */

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserId(Long userId);
}