package com.example.pruebaTecnica.repository;

import com.example.pruebaTecnica.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}