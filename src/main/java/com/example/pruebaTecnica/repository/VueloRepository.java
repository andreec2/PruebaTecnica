package com.example.pruebaTecnica.repository;

import com.example.pruebaTecnica.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {

}