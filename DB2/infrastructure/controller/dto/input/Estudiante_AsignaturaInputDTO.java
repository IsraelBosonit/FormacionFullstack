package com.example.DB1.infrastructure.controller.dto.input;

import com.example.DB1.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante_AsignaturaInputDTO {
    private Student student;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;
}
