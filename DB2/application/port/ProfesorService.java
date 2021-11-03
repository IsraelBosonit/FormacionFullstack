package com.example.DB1.application.port;

import com.example.DB1.domain.Profesor;

public interface ProfesorService {
    void ComprobarNulos(Profesor p) throws Exception;
    Profesor FindProfesorById(String id);
}
