package com.training.studentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.studentapp.model.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer>{

}
