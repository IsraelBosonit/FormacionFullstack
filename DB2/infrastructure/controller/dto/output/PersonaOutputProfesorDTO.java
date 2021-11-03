package com.example.DB1.infrastructure.controller.dto.output;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputProfesorDTO extends PersonaOutputDTO{
    private String id_profesor;
    private String coments;
    private String branch;
    private List<StudentOutputAsignaturaDTO> students;

}
