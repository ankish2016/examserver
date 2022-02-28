package com.exam.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.server.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
