package com.training.studentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.studentapp.model.MarksEntity;

public interface MarksRepository extends JpaRepository<MarksEntity, Integer>{

}
