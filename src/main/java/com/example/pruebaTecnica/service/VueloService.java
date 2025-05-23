package com.example.pruebaTecnica.service;

import com.example.pruebaTecnica.model.Vuelo;
import com.example.pruebaTecnica.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    // CREATE
    public Vuelo save(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    // READ
    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    public Optional<Vuelo> findById(Long id) {
        return vueloRepository.findById(id);
    }

    // UPDATE
    public Vuelo update(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    // DELETE
    public void deleteById(Long id) {
        vueloRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return vueloRepository.existsById(id);
    }
}