package com.example.DB1.application.port;

import com.example.DB1.domain.Estudiante_Asignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Estudiante_AsignaturaServiceImpl implements Estudiante_AsignaturaService{
    @Autowired
    StudentRepositorio studentRepositorio;
    @Override
    public void ComprobarNulos(Estudiante_Asignatura a) throws Exception {
        if(a.getInitial_date()==null){
            throw new Exception("InitialDate no puede ser null");
        }
    }

    @Override
    public void ComprobarStudent(Estudiante_Asignatura a) throws Exception {
        studentRepositorio.findById(a.getStudent().getId_student()).orElseThrow(()->new Exception("El estudiante no existe"));
    }
}
