package com.techchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techchat.model.College;

public interface CollegeRepository extends JpaRepository<College, Long>{

}
