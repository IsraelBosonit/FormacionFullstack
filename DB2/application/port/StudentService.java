package com.example.DB1.application.port;

import com.example.DB1.domain.Student;

public interface StudentService {
    void comprobarNulos(Student s) throws Exception;
    void comprobarAsignado(Student s) throws Exception;
    Student FindStudentById(String id) throws Exception;

}
