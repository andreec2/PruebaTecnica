package com.example.pruebaTecnica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aeropuerto {
    private Long id;
    private String codigo;
    private String ciudad;
    private String nombre;
    private String pais;
}

