package com.example.DB1.application.port;

import com.example.DB1.domain.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Override
    public void ComprabarNulos(Persona p) throws Exception {
        if(p.getUsuario()==null){
            throw new Exception("Usuario no puede ser nulo");
        }
        if(p.getPassword()==null){
            throw new Exception("Password no puede ser nulo");
        }
        if(p.getName()==null){
            throw new Exception("Name no puede ser nulo");
        }
        if(p.getCompany_email()==null){
            throw new Exception("Company_email no puede ser nulo");
        }
        if(p.getPersonal_email()==null){
            throw new Exception("Personal_email no puede ser nulo");
        }
        if(p.getCity()==null){
            throw new Exception("Ciudad no puede ser nulo");
        }
        if(p.getActive()==null){
            throw new Exception("Active no puede ser nulo");
        }
        if(p.getCreated_date()==null){
            throw new Exception("Created date no puede ser nulo");
        }
    }

    @Override
    public void ComprobarLongitudUsuario(Persona p) throws Exception {
        if(p.getUsuario().length()>10||p.getUsuario().length()<6){
            throw new Exception("Formato de usuario incorrecto, la longitud debe ser entre 6 y 10 ");
        }
    }
    public void ComprobarAsignado(Persona p) throws Exception {
        if(p.getStudent()!=null || p.getProfesor()!=null){
            throw new Exception("Esta persona tiene un estudiante/profesor asignado");
        }
    }
}
