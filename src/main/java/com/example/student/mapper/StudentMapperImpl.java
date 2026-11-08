package com.example.student.mapper;

import com.example.student.dto.*;
import com.example.student.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student requestToStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setSurname(studentRequest.getSurname());
        student.setPhone(studentRequest.getPhone());
        student.setEmail(studentRequest.getEmail());

        return student;
    }

    @Override
    public StudentResponse studentToResponse(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getPhone()
        );
    }

    @Override
    public StudentFullResponse studentToFullResponse(Student student) {
        return new StudentFullResponse(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getPhone(),
                student.getEmail()
        );
    }

    @Override
    public StudentResponseForList studentToStudentResponseForList(Student student) {
        return new StudentResponseForList(
                student.getId(),
                student.getName(),
                student.getPhone()
        );
    }

    @Override
    public List<StudentResponseForList> studentListToListOfStudentResponse(List<Student> studentList) {
        return studentList.stream()
                .map(this::studentToStudentResponseForList)
                .toList();
    }

    @Override
    public StudentResponseList studentListToStudentResponseList(List<Student> students) {
        return new StudentResponseList(studentListToListOfStudentResponse(students));
    }
}
