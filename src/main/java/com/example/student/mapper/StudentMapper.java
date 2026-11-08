package com.example.student.mapper;

import com.example.student.dto.*;
import com.example.student.model.Student;

import java.util.List;

public interface StudentMapper {
    Student requestToStudent(StudentRequest studentRequest);
    StudentResponse studentToResponse(Student student);
    StudentFullResponse studentToFullResponse(Student student);
    StudentResponseForList studentToStudentResponseForList(Student student);
    List<StudentResponseForList> studentListToListOfStudentResponse(List<Student> studentList);
    StudentResponseList studentListToStudentResponseList(List<Student> students);
}
