package com.example.DB1.application.port;

import com.example.DB1.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona, String> {

    List<Persona> findByusuario(String usuario);
}

