package com.example.DB1.domain;

import com.example.DB1.StringPrefixedSequenceIdGenerator;
import com.example.DB1.application.port.PersonaRepositorio;
import com.example.DB1.infrastructure.controller.dto.input.ProfesorInputDTO;
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
public class Profesor {
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    @GenericGenerator(
            name = "profesor_seq",
            strategy = "com.example.DB1.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "PRF"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    private String id_profesor;
    @JoinColumn(name="id_persona")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Persona persona;
    private String coments;
    @NotNull
    private String branch;
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Student> students;
    public Profesor(ProfesorInputDTO p){
        this.setPersona(personaRepositorio.findById(p.getId_persona()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        this.setComents(p.getComents());
        this.setBranch(p.getBranch());
    }
}
