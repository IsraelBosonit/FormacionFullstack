package com.example.DB1.infrastructure.controller.dto.output;

import com.example.DB1.domain.Estudiante_Asignatura;
import com.example.DB1.domain.Persona;
import com.example.DB1.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputEstudianteDTO extends PersonaOutputDTO{
    private String id_student;
    private Integer num_hours_week;
    private String coments;
    private String branch;
    private String id_profesor;
    private String id_persona;
    private String comentsProfesor;
    private String branchProfesor;
    private List<Estudiante_Asignatura> asignaturas;
    public PersonaOutputEstudianteDTO(Persona p){
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
        this.setId_student(p.getStudent().getId_student());
        this.setNum_hours_week(p.getStudent().getNum_hours_week());
        this.setComents(p.getStudent().getComents());
        this.setId_profesor(p.getProfesor().getId_profesor());
        this.setId_persona(p.getProfesor().getPersona().getId_persona());
        this.setComentsProfesor(p.getProfesor().getComents());
        this.setBranchProfesor(p.getProfesor().getBranch());
        this.setAsignaturas(p.getStudent().getAsignaturas());

    }
}
