package com.training.studentapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.training.studentapp.model.StudentEntity;
import com.training.studentapp.model.MarksEntity;

import com.training.studentapp.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    // Get all students
    @GetMapping("/student")
    public ResponseEntity<List<StudentEntity>> getStudent() {
        List<StudentEntity> students = service.getStudent();
        return ResponseEntity.ok(students);
    }

    // Get student by ID
    @GetMapping("/student/{stdId}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Integer stdId) {
        return service.getStudentById(stdId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Insert student
    @PostMapping("/student")
    public ResponseEntity<String> insertStud(@RequestBody StudentEntity stud) {
        String response = service.saveStud(stud);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Update student
    @PutMapping("/student")
    public ResponseEntity<String> updateStud(@RequestBody StudentEntity stud) {
        String response = service.saveStud(stud);
        return ResponseEntity.ok(response);
    }

    // Delete student by ID
    @DeleteMapping("/student/{stdId}")
    public ResponseEntity<String> deleteStudById(@PathVariable Integer stdId) {
        String response = service.deleteStudById(stdId);
        return ResponseEntity.ok(response);
    }

    // Get marks by student ID
    @GetMapping("/marks/{stdId}")
    public ResponseEntity<MarksEntity> getMarks(@PathVariable Integer stdId) {
        return service.getMarksById(stdId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
