package com.example.DB1.domain;

import com.example.DB1.StringPrefixedSequenceIdGenerator;
import com.example.DB1.application.port.PersonaRepositorio;
import com.example.DB1.application.port.ProfesorRepositorio;
import com.example.DB1.infrastructure.controller.dto.input.StudentInputDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @GenericGenerator(
            name = "student_seq",
            strategy = "com.example.DB1.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "STD"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    private String id_student;
    @JoinColumn(name="id_persona")
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Persona persona;
    @NotNull
    private Integer num_hours_week;
    private String coments;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id_profesor")
    private Profesor profesor;
    private String branch;
    @OneToMany(mappedBy="student", cascade = CascadeType.ALL)
    private List<Estudiante_Asignatura> asignaturas;

    public Student(StudentInputDTO s) {
        this.setPersona(personaRepositorio.findById(s.getId_persona()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        this.setNum_hours_week(s.getNum_hours_week());
        this.setProfesor(profesorRepositorio.findById(s.getId_profesor()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        this.setComents(s.getComents());
        this.setBranch(s.getBranch());
    }
}
