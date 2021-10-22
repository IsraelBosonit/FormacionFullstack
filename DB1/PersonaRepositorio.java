package com.example.DB1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

    List<Persona> findByusuario(String usuario);
}

