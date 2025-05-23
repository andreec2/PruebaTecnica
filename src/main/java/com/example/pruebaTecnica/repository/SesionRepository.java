package com.example.pruebaTecnica.repository;

import com.example.pruebaTecnica.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<Sesion, Long> {
}