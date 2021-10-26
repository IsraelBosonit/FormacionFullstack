package com.example.DB1.infrastructure.controller;

import com.example.DB1.domain.Persona;
import com.example.DB1.application.port.PersonaRepositorio;
import com.example.DB1.application.port.PersonaService;
import com.example.DB1.infrastructure.controller.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UpdateController {

    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaService personaService;

    @PutMapping("/{id}")
    public PersonaDto modificarPersona(@PathVariable Integer id, @RequestBody PersonaDto p) throws Exception {
        personaService.ComprabarNulos(p);
        personaService.ComprobarLongitudUsuario(p);
        personaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        personaRepositorio.save(p);
        return p;
    }
}
