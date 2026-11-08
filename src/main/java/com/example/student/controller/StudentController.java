package com.example.student.controller;

import com.example.student.dto.StudentRequest;
import com.example.student.dto.StudentResponse;
import com.example.student.dto.StudentResponseList;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/{id}")
    public StudentResponse getStudentByID(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public StudentResponseList findAll() {
        return service.findAll();
    }

    @PostMapping("/save")
    public StudentResponse createStudent(@RequestBody StudentRequest request) {
        return service.createStudent(request);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable Long id,
                                         @RequestBody StudentRequest request) {
        return service.update(id, request);
    }
}
