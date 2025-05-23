package com.example.pruebaTecnica.repository;

import com.example.pruebaTecnica.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository<Boleto, Long> {
}