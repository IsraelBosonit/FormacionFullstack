package com.example.DB1.infrastructure.controller;

import com.example.DB1.application.port.Auxiliar;
import com.example.DB1.application.port.PersonaRepositorio;
import com.example.DB1.application.port.PersonaService;
import com.example.DB1.domain.Persona;
import com.example.DB1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.example.DB1.infrastructure.controller.dto.output.PersonaOutputEstudianteDTO;
import com.example.DB1.infrastructure.controller.dto.output.PersonaOutputProfesorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("persona")
@RestController
public class FindPersonaController {

    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaService personaService;
    @Autowired
    Auxiliar auxiliar;

    @GetMapping("/{id}")
    public PersonaOutputDTO getPersonabyId(@PathVariable String id, @RequestParam(name="outputType", defaultValue = "simple") String outputType)throws Exception{
        Persona p=personaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        PersonaOutputDTO out = null;
        if(outputType.equals("simple")){
            out=new PersonaOutputDTO(p);
        }
        if(outputType.equals("profesor")){
            out=auxiliar.CreatePersonaOutputProfesorDTO(p);
        }
        if(outputType.equals("estudiante")){
            out= auxiliar.CreatePersonaOutputEstudianteDTO(p);
        }
        return out;
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDTO> getPersonabyNombre(@PathVariable String nombre, @RequestParam(name="outputType", defaultValue = "simple") String outputType)throws Exception{
        List<Persona> l=personaRepositorio.findByusuario(nombre);
        List<PersonaOutputDTO> lout=new ArrayList<>();
        for (Persona p : l) {
            if(outputType.equals("simple")){
                lout.add(new PersonaOutputDTO(p));
            }
            if(outputType.equals("profesor")){
                lout.add(auxiliar.CreatePersonaOutputProfesorDTO(p));
            }
            if(outputType.equals("estudiante")){
                lout.add(auxiliar.CreatePersonaOutputEstudianteDTO(p));
            }
        }
        return lout;
    }
    @GetMapping
    public List<PersonaOutputDTO> getAll(@RequestParam(name="outputType", defaultValue = "simple") String outputType)throws Exception{
        List<Persona> l=personaRepositorio.findAll();
        List<PersonaOutputDTO> lout=new ArrayList<>();
        for (Persona p : l) {
            if(outputType.equals("simple")){
                lout.add(new PersonaOutputDTO(p));
            }
            if(outputType.equals("profesor")){
                lout.add(auxiliar.CreatePersonaOutputProfesorDTO(p));
            }
            if(outputType.equals("estudiante")){
                lout.add(auxiliar.CreatePersonaOutputEstudianteDTO(p));
            }
        }
        return lout;
    }
}
