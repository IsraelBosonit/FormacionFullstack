package com.example.DB1.application.port;

import com.example.DB1.domain.Estudiante_Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Estudiante_AsignaturaRepositorio extends JpaRepository<Estudiante_Asignatura,String> {
    Estudiante_Asignatura findByasignatura(String asignatura);

}
