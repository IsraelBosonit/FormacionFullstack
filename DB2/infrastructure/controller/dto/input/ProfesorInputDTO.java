package com.example.DB1.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDTO {
    private String id_persona;
    private String coments;
    private String branch;
}
