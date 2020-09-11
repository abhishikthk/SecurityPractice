package com.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Phone;

public interface PhoneRepo extends JpaRepository<Phone, Long>{

}
