package com.example.DB1.infrastructure.controller.dto.output;

import com.example.DB1.domain.Estudiante_Asignatura;
import com.example.DB1.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante_AsignaturaOutputDTO {
    private String id_asignatura;
    private String id_student;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;

    public Estudiante_AsignaturaOutputDTO(Estudiante_Asignatura a){
        this.setId_asignatura(a.getId_asignatura());
        this.setId_student(a.getStudent().getId_student());
        this.setAsignatura(a.getAsignatura());
        this.setComents(a.getComents());
        this.setInitial_date(a.getInitial_date());
        this.setFinish_date(a.getFinish_date());
    }
}
