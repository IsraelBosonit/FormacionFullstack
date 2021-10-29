package com.example.DB1.application.port;

import com.example.DB1.domain.Persona;

public interface PersonaService {
    void ComprabarNulos(Persona p) throws Exception;
    void ComprobarLongitudUsuario(Persona p) throws Exception;
    void ComprobarAsignado(Persona p) throws Exception;
}
