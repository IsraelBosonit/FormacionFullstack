package com.example.DB1.infrastructure.controller;

import com.example.DB1.domain.Persona;
import com.example.DB1.application.port.PersonaRepositorio;
import com.example.DB1.application.port.PersonaService;
import com.example.DB1.infrastructure.controller.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
public class FindController {

    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaService personaService;

    @GetMapping("/{id}")
    public PersonaDto getPersonabyId(@PathVariable Integer id)throws Exception{
        return personaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaDto> getPersonabyNombre(@PathVariable String nombre)throws Exception{
        return personaRepositorio.findByusuario(nombre);
    }
    @GetMapping
    public List<PersonaDto> getAll()throws Exception{
        return personaRepositorio.findAll();
    }
}
