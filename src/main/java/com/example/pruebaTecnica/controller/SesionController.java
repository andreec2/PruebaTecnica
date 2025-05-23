package com.example.pruebaTecnica.controller;

import com.example.pruebaTecnica.model.Sesion;
import com.example.pruebaTecnica.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sesiones")
@CrossOrigin(origins = "*")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    // CREATE
    @PostMapping
    public ResponseEntity<Sesion> create(@RequestBody Sesion sesion) {
        Sesion savedSesion = sesionService.save(sesion);
        return new ResponseEntity<>(savedSesion, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Sesion>> getAll() {
        List<Sesion> sesiones = sesionService.findAll();
        return new ResponseEntity<>(sesiones, HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Sesion> getById(@PathVariable Long id) {
        Optional<Sesion> sesion = sesionService.findById(id);
        return sesion.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Sesion> update(@PathVariable Long id, @RequestBody Sesion sesion) {
        if (!sesionService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sesion.setId(id);
        Sesion updatedSesion = sesionService.update(sesion);
        return new ResponseEntity<>(updatedSesion, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!sesionService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sesionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}