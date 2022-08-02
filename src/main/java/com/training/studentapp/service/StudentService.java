package com.training.studentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.training.studentapp.model.StudentEntity;
import com.training.studentapp.model.MarksEntity;
import com.training.studentapp.repo.MarksRepo;
import com.training.studentapp.repo.StudentRepo;

@Service
public class StudentService {
@Autowired
StudentRepo repo;

@Autowired
MarksRepo marksrepo;
public List<StudentEntity> getStudent() {
	return repo.findAll();
	
}

public Optional<StudentEntity> getStudentById(int stdid) {
	return repo.findById(stdid);
	
}


public String saveStud(StudentEntity stud) {
	repo.save(stud);
	return "Student inserted/updated";
}

public String deleteStud(StudentEntity stud) {
	repo.delete(stud);
	return "Student deleted";
}

public String deleteStudById(int studId) {
	repo.deleteById(studId);
	return "Student deleted";
}

public Optional<MarksEntity> getMarksById(int stdid) {
	return marksrepo.findById(stdid);
}

}
