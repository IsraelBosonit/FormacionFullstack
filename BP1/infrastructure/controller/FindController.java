package com.example.DB1.infrastructure.controller;

import com.example.DB1.application.port.PersonaRepositorio;
import com.example.DB1.application.port.PersonaService;
import com.example.DB1.domain.Persona;
import com.example.DB1.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("persona")
@RestController
public class FindController {

    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaService personaService;

    @GetMapping("/{id}")
    public PersonaOutputDTO getPersonabyId(@PathVariable Integer id)throws Exception{
        Persona p=personaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new PersonaOutputDTO(p);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDTO> getPersonabyNombre(@PathVariable String nombre)throws Exception{
        List<Persona> l=personaRepositorio.findByusuario(nombre);
        List<PersonaOutputDTO> lout=new ArrayList<>();
        for (Persona p : l) {
            lout.add(new PersonaOutputDTO(p));
        }
        return lout;
    }
    @GetMapping
    public List<PersonaOutputDTO> getAll()throws Exception{
        List<Persona> l=personaRepositorio.findAll();
        List<PersonaOutputDTO> lout=new ArrayList<>();
        for (Persona p : l) {
            lout.add(new PersonaOutputDTO(p));
        }
        return lout;
    }
}
