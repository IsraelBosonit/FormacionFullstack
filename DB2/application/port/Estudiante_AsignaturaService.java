package com.example.DB1.application.port;

import com.example.DB1.domain.Estudiante_Asignatura;

public interface Estudiante_AsignaturaService {
    void ComprobarNulos(Estudiante_Asignatura a) throws Exception;
    void ComprobarStudent(Estudiante_Asignatura a)throws Exception;
    Estudiante_Asignatura FindEstudiante_AsignaturaById(String id) throws Exception;
}
