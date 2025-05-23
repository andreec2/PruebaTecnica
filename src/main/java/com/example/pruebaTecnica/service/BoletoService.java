package com.example.pruebaTecnica.service;

import com.example.pruebaTecnica.model.Boleto;
import com.example.pruebaTecnica.repository.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    // CREATE
    public Boleto save(Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    // READ
    public List<Boleto> findAll() {
        return boletoRepository.findAll();
    }

    public Optional<Boleto> findById(Long id) {
        return boletoRepository.findById(id);
    }

    // UPDATE
    public Boleto update(Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    // DELETE
    public void deleteById(Long id) {
        boletoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return boletoRepository.existsById(id);
    }
}