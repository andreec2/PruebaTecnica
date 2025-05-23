package com.example.pruebaTecnica.service;

import com.example.pruebaTecnica.model.Sesion;
import com.example.pruebaTecnica.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    // CREATE
    public Sesion save(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    // READ
    public List<Sesion> findAll() {
        return sesionRepository.findAll();
    }

    public Optional<Sesion> findById(Long id) {
        return sesionRepository.findById(id);
    }

    // UPDATE
    public Sesion update(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    // DELETE
    public void deleteById(Long id) {
        sesionRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return sesionRepository.existsById(id);
    }
}