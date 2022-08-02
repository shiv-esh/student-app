package com.training.studentapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.studentapp.model.ContactEntity;
import com.training.studentapp.model.StudentEntity;
import com.training.studentapp.model.MarksEntity;
import com.training.studentapp.repo.ContactsRepo;
import com.training.studentapp.repo.MarksRepo;
import com.training.studentapp.repo.StudentRepo;

import com.training.studentapp.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
//	@Autowired
//	StudentRepo srepo;
//	@Autowired
//	ContactsRepo crepo;
//	
//	@Autowired
//	MarksRepo mrepo;
	
	
	
	@GetMapping("/student")
	public List<StudentEntity> getStudent(){
		return service.getStudent();
		
	}

	@GetMapping("/student/{stdId}")
	public StudentEntity getEmployee(@PathVariable Integer stdId){
		Optional<StudentEntity> entity =service.getStudentById(stdId);
		if(entity.isPresent()) {
			return entity.get();
		}else {
			return null;
		}
		
	}
	
	@PostMapping("/student")
	public String insertStud(@RequestBody StudentEntity stud) {
		return service.saveStud(stud);
	}
	@PutMapping("/student")
	public String updateStud(StudentEntity stud) {
		return service.saveStud(stud);
	}
	@DeleteMapping("/student")
	public String deleteStud(StudentEntity stud) {
		return service.deleteStud(stud);
	}
	@DeleteMapping("/student/{stdId}")
	public String deleteStudById(@PathVariable Integer stdId) {
		return service.deleteStudById(stdId);
	}
	@GetMapping("/marks/{stdId}")
	public MarksEntity getMarks(@PathVariable Integer stdId){
		Optional<MarksEntity> entity =service.getMarksById(stdId);
		if(entity.isPresent()) {
			return entity.get();
		}else {
			return null;
		}
}
}
