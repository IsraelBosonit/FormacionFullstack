package com.example.DB1.infrastructure.controller;

import com.example.DB1.application.port.*;
import com.example.DB1.domain.Estudiante_Asignatura;
import com.example.DB1.domain.Student;
import com.example.DB1.infrastructure.controller.dto.input.Estudiante_AsignaturaInputDTO;
import com.example.DB1.infrastructure.controller.dto.input.StudentInputDTO;
import com.example.DB1.infrastructure.controller.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RequestMapping("student")
@RestController
public class UpdateStudentController {
    @Autowired
    StudentRepositorio studentRepositorio;
    @Autowired
    StudentService studentService;
    @Autowired
    Estudiante_AsignaturaRepositorio estudiante_asignaturaRepositorio;
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @PutMapping("/{id}")
    public StudentOutputDTO modificarEstudiante(@PathVariable String id, @RequestBody StudentInputDTO s) throws Exception {
        Student student=studentRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        if(s.getId_persona()!=null){
            student.setPersona(personaRepositorio.findById(s.getId_persona()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        }
        if(s.getNum_hours_week()!=null){
            student.setNum_hours_week(s.getNum_hours_week());
        }
        if(s.getComents()!=null){
            student.setComents(s.getComents());
        }
        if(s.getId_profesor()!=null){
            student.setProfesor(profesorRepositorio.findById(s.getId_profesor()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        }
        if(s.getBranch()!=null){
            student.setBranch(s.getBranch());
        }
        studentService.comprobarNulos(student);
        studentRepositorio.save(student);
        return new StudentOutputDTO(student);
    }
    @PutMapping("/asignar_asignaturas/{id}")
    public StudentOutputDTO añadirAsignaturas(@PathVariable String id, @RequestBody List<String> asignaturas){
        Student student=studentRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        for(String s:asignaturas){
            Estudiante_AsignaturaInputDTO est=new Estudiante_AsignaturaInputDTO(student,s,"",new Date(),null);
            Estudiante_Asignatura a=new Estudiante_Asignatura(est);
            student.getAsignaturas().add(a);
        }
        studentRepositorio.save(student);
        return new StudentOutputDTO(student);
    }

    @PutMapping("/desasignar_asignaturas/{id}")
    public StudentOutputDTO quitarAsignaturas(@PathVariable String id, @RequestBody List<String> asignaturas){
        Student student=studentRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        for(String s:asignaturas){
            Estudiante_Asignatura asig=estudiante_asignaturaRepositorio.findByasignatura(s);
            student.getAsignaturas().remove(asig);
            estudiante_asignaturaRepositorio.deleteById(asig.getId_asignatura());
        }
        studentRepositorio.save(student);
        return new StudentOutputDTO(student);
    }

}
