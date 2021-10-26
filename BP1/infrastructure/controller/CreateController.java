package com.example.DB1.infrastructure.controller;

import com.example.DB1.domain.Persona;
import com.example.DB1.application.port.PersonaRepositorio;
import com.example.DB1.application.port.PersonaService;
import com.example.DB1.infrastructure.controller.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateController {
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaService personaService;

    @PostMapping
    public PersonaDto anadirPersona(@RequestBody PersonaDto p) throws Exception {
        personaService.ComprabarNulos(p);
        personaService.ComprobarLongitudUsuario(p);
        personaRepositorio.save(p);
        return p;


    }
}
