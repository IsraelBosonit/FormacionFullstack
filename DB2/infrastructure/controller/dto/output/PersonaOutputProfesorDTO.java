package com.example.DB1.infrastructure.controller.dto.output;

import com.example.DB1.domain.Persona;
import com.example.DB1.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputProfesorDTO extends PersonaOutputDTO{
    private String id_profesor;
    private String coments;
    private String branch;
    private List<Student> students;
    public PersonaOutputProfesorDTO(Persona p){
        this.setId_persona(p.getId_persona());
        this.setUsuario(p.getUsuario());
        this.setPassword(p.getPassword());
        this.setName(p.getName());
        this.setSurname(p.getSurname());
        this.setCompany_email(p.getCompany_email());
        this.setPersonal_email(p.getPersonal_email());
        this.setCity(p.getCity());
        this.setActive(p.getActive());
        this.setCreated_date(p.getCreated_date());
        this.setImagen_url(p.getImagen_url());
        this.setTermination_date(p.getTermination_date());
        this.setId_profesor(p.getProfesor().getId_profesor());
        this.setComents(p.getProfesor().getComents());
        this.setBranch(p.getProfesor().getBranch());
        this.setStudents(p.getProfesor().getStudents());
    }
}
