package com.example.student.service;

import com.example.student.dto.StudentRequest;
import com.example.student.dto.StudentResponse;
import com.example.student.dto.StudentResponseList;
import com.example.student.exception.EntityNotFoundException;
import com.example.student.mapper.StudentMapper;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponseList findAll() {
        return studentMapper.studentListToStudentResponseList(
                studentRepository.findAll());
    }

    @Override
    public StudentResponse findById(Long id) {
        return studentMapper.studentToResponse(studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format(
                                "Student with ID {0} not found!", id))));
    }

    @Override
    public StudentResponse save(Student student) {
        return studentMapper.studentToResponse(studentRepository.save(student));
    }

    @Override
    public void deleteByID(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        Student newStudent = new Student();
        newStudent.setName(request.getName());
        newStudent.setSurname(request.getSurname());
        newStudent.setPhone(request.getPhone());
        newStudent.setEmail(request.getEmail());
        return studentMapper.studentToResponse(
                studentRepository.save(newStudent));
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {
        Student existed = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format(
                                "Student with ID {0} not found!", id)));
        existed.setName(request.getName());
        existed.setSurname(request.getSurname());
        existed.setPhone(request.getPhone());
        existed.setEmail(request.getEmail());
        return studentMapper.studentToResponse(
                studentRepository.save(existed));
    }
}

