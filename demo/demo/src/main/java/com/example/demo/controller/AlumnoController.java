package com.example.demo.controller;

import com.example.demo.model.Alumno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "http://localhost:4200")
public class AlumnoController {

    private final List<Alumno> alumnos = List.of(
        new Alumno(1L, "Ana López", "Ingeniería en Software"),
        new Alumno(2L, "Carlos Ruiz", "Ingeniería en Software")
    );

    // GET http://localhost:8080/api/alumnos
    @GetMapping
    public List<Alumno> obtenerAlumnos() {
        return alumnos;
    }

    // GET http://localhost:8080/api/alumnos/1
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumno(@PathVariable Long id) {
        return alumnos.stream()
            .filter(a -> a.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}