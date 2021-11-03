package com.example.DB1.infrastructure.controller;

import com.example.DB1.application.port.Auxiliar;
import com.example.DB1.application.port.ProfesorRepositorio;
import com.example.DB1.application.port.ProfesorService;
import com.example.DB1.domain.Profesor;
import com.example.DB1.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.example.DB1.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("profesor")
@RestController
public class CreateProfesorController {
    @Autowired
    ProfesorService profesorService;
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @Autowired
    Auxiliar auxiliar;

    @PostMapping
    public ProfesorOutputDTO añadirProfesor(@RequestBody ProfesorInputDTO p) throws Exception {
        Profesor profesor=auxiliar.CreateProfesor(p);
        profesorService.ComprobarNulos(profesor);
        profesorRepositorio.save(profesor);
        return new ProfesorOutputDTO(profesor);
    }
}
