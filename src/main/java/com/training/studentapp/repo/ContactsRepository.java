package com.training.studentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.studentapp.model.ContactEntity;

public interface ContactsRepository extends JpaRepository<ContactEntity, Integer>{

}
