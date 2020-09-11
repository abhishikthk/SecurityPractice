package com.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{

}
