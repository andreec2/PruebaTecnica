package com.example.pruebaTecnica.controller;

import com.example.pruebaTecnica.model.Boleto;
import com.example.pruebaTecnica.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boletos")
@CrossOrigin(origins = "*")
public class BoletoController {

    @Autowired
    private BoletoService boletoService;

    // CREATE
    @PostMapping
    public ResponseEntity<Boleto> create(@RequestBody Boleto boleto) {
        Boleto savedBoleto = boletoService.save(boleto);
        return new ResponseEntity<>(savedBoleto, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Boleto>> getAll() {
        List<Boleto> boletos = boletoService.findAll();
        return new ResponseEntity<>(boletos, HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Boleto> getById(@PathVariable Long id) {
        Optional<Boleto> boleto = boletoService.findById(id);
        return boleto.map(b -> new ResponseEntity<>(b, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Boleto> update(@PathVariable Long id, @RequestBody Boleto boleto) {
        if (!boletoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boleto.setId(id);
        Boleto updatedBoleto = boletoService.update(boleto);
        return new ResponseEntity<>(updatedBoleto, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!boletoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boletoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}