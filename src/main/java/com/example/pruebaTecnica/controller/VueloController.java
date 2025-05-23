package com.example.pruebaTecnica.controller;

import com.example.pruebaTecnica.model.Vuelo;
import com.example.pruebaTecnica.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vuelos")
@CrossOrigin(origins = "*")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    // CREATE
    @PostMapping
    public ResponseEntity<Vuelo> create(@RequestBody Vuelo vuelo) {
        Vuelo savedVuelo = vueloService.save(vuelo);
        return new ResponseEntity<>(savedVuelo, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Vuelo>> getAll() {
        List<Vuelo> vuelos = vueloService.findAll();
        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> getById(@PathVariable Long id) {
        Optional<Vuelo> vuelo = vueloService.findById(id);
        return vuelo.map(v -> new ResponseEntity<>(v, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> update(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        if (!vueloService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        vuelo.setId(id);
        Vuelo updatedVuelo = vueloService.update(vuelo);
        return new ResponseEntity<>(updatedVuelo, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!vueloService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        vueloService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}