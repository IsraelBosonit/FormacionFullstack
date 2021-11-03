package com.example.DB1.infrastructure.controller;

import com.example.DB1.application.port.Auxiliar;
import com.example.DB1.application.port.StudentRepositorio;
import com.example.DB1.application.port.StudentService;
import com.example.DB1.domain.Student;
import com.example.DB1.infrastructure.controller.dto.input.StudentInputDTO;
import com.example.DB1.infrastructure.controller.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("student")
@RestController
public class CreateStudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepositorio studentRepositorio;
    @Autowired
    Auxiliar auxiliar;
    @PostMapping
    public StudentOutputDTO añadirEstudiante(@RequestBody StudentInputDTO s) throws Exception {
        Student student=auxiliar.CreateStudent(s);
        studentService.comprobarNulos(student);
        studentRepositorio.save(student);
        StudentOutputDTO out=auxiliar.CreateStudentOutputDTO(student);
        return out;

    }

}
