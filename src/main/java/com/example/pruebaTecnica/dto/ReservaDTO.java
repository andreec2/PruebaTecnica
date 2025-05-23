package com.example.pruebaTecnica.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private Long id;
    private LocalDateTime fechaReserva;
    private String categoriaAsiento;
    private int cantidadPasajeros;
    private boolean asientosReservados;
    private String usuarioEmail;
    private String codigoVuelo;
    private String origen;
    private String destino;
    private LocalDateTime fechaSalida;
    private Double tarifa;
}