package com.example.pruebaTecnica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aerolinea {
    private Long id;
    private String nombre;
    private String codigo;
}
