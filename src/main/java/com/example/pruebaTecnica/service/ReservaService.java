package com.example.pruebaTecnica.service;

import com.example.pruebaTecnica.model.Reserva;
import com.example.pruebaTecnica.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // CREATE
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // READ
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    // UPDATE
    public Reserva update(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // DELETE
    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return reservaRepository.existsById(id);
    }
}