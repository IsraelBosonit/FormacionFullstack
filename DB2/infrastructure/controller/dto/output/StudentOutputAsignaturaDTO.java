package com.example.DB1.infrastructure.controller.dto.output;

import com.example.DB1.domain.Estudiante_Asignatura;
import com.example.DB1.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputAsignaturaDTO{
    private String id_student;
    private Integer num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;
    private List<Estudiante_AsignaturaOutputDTO> asignaturas;

}
