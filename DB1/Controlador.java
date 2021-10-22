package com.example.DB1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaService personaService;

    @PostMapping
    public Persona anadirPersona(@RequestBody Persona p) throws Exception {
        personaService.ComprabarNulos(p);
        personaService.ComprobarLongitudUsuario(p);
        personaRepositorio.save(p);
        return p;


    }
    @GetMapping("/{id}")
    public Persona getPersonabyId(@PathVariable Integer id)throws Exception{
        return personaRepositorio.findById(id).orElseThrow(()->new Exception("No encontrado"));
    }
    @PutMapping("/{id}")
    public Persona modificarPersona(@PathVariable Integer id, @RequestBody Persona p) throws Exception {
        personaService.ComprabarNulos(p);
        personaService.ComprobarLongitudUsuario(p);
        personaRepositorio.findById(id).orElseThrow(()->new Exception("No encontrado"));
        personaRepositorio.save(p);
        return p;
    }
    @DeleteMapping("/{id}")
    public void deletePersonabyId(@PathVariable Integer id)throws Exception{
        personaRepositorio.findById(id).orElseThrow(()->new Exception("No encontrado"));
        personaRepositorio.deleteById(id);
    }
    @GetMapping("/nombre/{nombre}")
    public List<Persona> getPersonabyNombre(@PathVariable String nombre)throws Exception{
        return personaRepositorio.findByusuario(nombre);
    }
    @GetMapping
    public List<Persona> getAll()throws Exception{
        return personaRepositorio.findAll();
    }
}
