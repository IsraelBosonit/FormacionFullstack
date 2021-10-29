package com.example.DB1.infrastructure.controller.dto.output;

import com.example.DB1.domain.Estudiante_Asignatura;
import com.example.DB1.domain.Persona;
import com.example.DB1.domain.Profesor;
import com.example.DB1.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDTO {
    private String id_student;
    private Integer num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;

    public StudentOutputDTO(Student student) {
        this.setId_student(student.getId_student());
        this.setNum_hours_week(student.getNum_hours_week());
        this.setComents(student.getComents());
        this.setId_profesor(student.getProfesor().getId_profesor());
    }
}
