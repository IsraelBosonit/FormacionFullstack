package com.example.DB1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    PersonaRepositorio personaRepositorio;
    @PostMapping
    public Persona anadirPersona(@RequestBody Persona p){
        personaRepositorio.save(p);
        return p;
    }
    @GetMapping("{id}")
    public Persona getPersonabyId(@RequestParam Integer id)throws Exception{
        return personaRepositorio.findById(id).orElseThrow(()->new Exception("No encontrado"));
    }
    @PutMapping("{id}")
    public Persona modificarPersona(@RequestParam Integer id, @RequestBody Persona p){
        personaRepositorio.deleteById(id);
        personaRepositorio.save(p);
        return p;
    }
    @DeleteMapping("{id}")
    public void deletePersonabyId(@RequestParam Integer id)throws Exception{
        personaRepositorio.deleteById(id);
    }
    @GetMapping("/nombre{nombre}")
    public List<Persona> getPersonabyNombre(@RequestParam String nombre)throws Exception{
        return personaRepositorio.findByUsuario(nombre);
    }
    @GetMapping
    public List<Persona> getAll()throws Exception{
        return personaRepositorio.findAll();
    }
}
