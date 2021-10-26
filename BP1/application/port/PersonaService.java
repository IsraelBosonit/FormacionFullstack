package com.example.DB1.application.port;

import com.example.DB1.domain.Persona;

public interface PersonaService {
    public void ComprabarNulos(Persona p) throws Exception;
    public void ComprobarLongitudUsuario(Persona p) throws Exception;
}
