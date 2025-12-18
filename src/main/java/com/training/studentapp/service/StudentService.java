package com.training.studentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.training.studentapp.model.StudentEntity;
import com.training.studentapp.model.MarksEntity;
import com.training.studentapp.repo.MarksRepository;
import com.training.studentapp.repo.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MarksRepository marksRepository;

    // Get all students
    public List<StudentEntity> getStudent() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<StudentEntity> getStudentById(int stdId) {
        return studentRepository.findById(stdId);
    }

    // Save / Update student (IMPORTANT FIX HERE)
    public String saveStud(StudentEntity student) {

        // 🔥 VERY IMPORTANT FOR @MapsId
        if (student.getMarks() != null) {
            student.getMarks().setStudent(student);
        }

        if (student.getContact() != null) {
            student.getContact().setStudent(student);
        }

        studentRepository.save(student);
        return "Student inserted/updated successfully";
    }

    // Delete student
    public String deleteStud(StudentEntity student) {
        studentRepository.delete(student);
        return "Student deleted successfully";
    }

    // Optional: delete by ID (recommended)
    public String deleteStudById(int studId) {
        if (!studentRepository.existsById(studId)) {
            return "Student not found";
        }
        studentRepository.deleteById(studId);
        return "Student deleted successfully";
    }


    public Optional<MarksEntity> getMarksById(int stdid) {
        return marksRepository.findById(stdid);
    }
}
