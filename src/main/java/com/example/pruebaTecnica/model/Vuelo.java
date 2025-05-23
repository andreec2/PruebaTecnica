package com.example.pruebaTecnica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "vuelos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoVuelo;

    private String origen;

    private String destino;

    private LocalDateTime fechaHoraSalida;

    private LocalDateTime fechaHoraLlegada;

    private String aerolinea;

    private double tarifa;

    private int asientosDisponibles;

    private boolean esDirecto;

    private String estado;

    @ManyToMany(mappedBy = "vuelos", fetch = FetchType.LAZY)
    @JsonIgnore // IMPORTANTE: Evita recursión con reservas
    private List<Reserva> reservas;

    public LocalTime getFechaSalida() {
        return null;
    }
}


