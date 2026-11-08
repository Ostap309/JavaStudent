package com.example.student.service;

import com.example.student.dto.StudentRequest;
import com.example.student.dto.StudentResponse;
import com.example.student.dto.StudentResponseList;
import com.example.student.model.Student;

import java.util.List;

public interface StudentService {
    StudentResponseList findAll();
    StudentResponse findById(Long id);
    StudentResponse save(Student student);
    void deleteByID(Long id);
    StudentResponse createStudent(StudentRequest request);
    StudentResponse update(Long id, StudentRequest request);
}
