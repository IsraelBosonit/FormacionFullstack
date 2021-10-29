package com.example.DB1.infrastructure.controller.dto.output;

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
public class ProfesorOutputDTO {
    private String id_profesor;
    private String id_persona;
    private String coments;
    private String branch;
    public ProfesorOutputDTO(Profesor p){
        this.setId_profesor(p.getId_profesor());
        this.setId_persona(p.getPersona().getId_persona());
        this.setComents(p.getComents());
        this.setBranch(p.getBranch());
    }
}
