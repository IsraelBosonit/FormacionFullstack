package com.example.DB1.application.port;

import com.example.DB1.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositorio extends JpaRepository<Student, String> {
}
