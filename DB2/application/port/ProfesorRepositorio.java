package com.example.DB1.application.port;

import com.example.DB1.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepositorio extends JpaRepository<Profesor,String> {

}
