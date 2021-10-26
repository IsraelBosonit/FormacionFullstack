package com.example.DB1.domain;

import com.example.DB1.infrastructure.controller.dto.input.PersonaInputDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    private Integer id_persona;
    @NotNull
    private String usuario;
    @NotNull
    private String password;
    @NotNull
    private String name;
    private String surname;
    @NotNull
    private String company_email;
    @NotNull
    private String personal_email;
    @NotNull
    private String city;
    @NotNull
    private Boolean active;
    @NotNull
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
    public Persona(PersonaInputDTO in){
        this.setUsuario(in.getUsuario());
        this.setPassword(in.getPassword());
        this.setName(in.getName());
        this.setSurname(in.getSurname());
        this.setCompany_email(in.getCompany_email());
        this.setPersonal_email(in.getPersonal_email());
        this.setCity(in.getCity());
        this.setActive(in.getActive());
        this.setCreated_date(in.getCreated_date());
        this.setImagen_url(in.getImagen_url());
        this.setTermination_date(in.getTermination_date());
    }

}
