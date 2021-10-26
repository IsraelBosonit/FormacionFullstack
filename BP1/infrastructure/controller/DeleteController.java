package com.example.DB1.infrastructure.controller;

import com.example.DB1.application.port.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
@RequestMapping("persona")
@RestController
public class DeleteController {
    @Autowired
    PersonaRepositorio personaRepositorio;
    @DeleteMapping("/{id}")
    public void deletePersonabyId(@PathVariable Integer id)throws Exception{
        personaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        personaRepositorio.deleteById(id);
    }
}
