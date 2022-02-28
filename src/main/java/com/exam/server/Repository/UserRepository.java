package com.exam.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.server.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserName(String username);
}
