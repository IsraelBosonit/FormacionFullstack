package com.example.DB1.application.port;

import com.example.DB1.domain.Student;

public interface StudentService {
    public void comprobarNulos(Student s) throws Exception;
    public void comprobarAsignado(Student s) throws Exception;
}
