package com.example.pruebaTecnica.controller;

import com.example.pruebaTecnica.dto.ReservaDTO;
import com.example.pruebaTecnica.model.Reserva;
import com.example.pruebaTecnica.model.Usuario;
import com.example.pruebaTecnica.model.Vuelo;
import com.example.pruebaTecnica.repository.UsuarioRepository;
import com.example.pruebaTecnica.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ReservasRestController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/mis-reservas")
    public ResponseEntity<?> getMisReservas(@AuthenticationPrincipal UserDetails userDetails) {
    try {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(userDetails.getUsername());
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        List<Reserva> todasLasReservas = reservaService.findAll();
        List<Reserva> reservasUsuario = todasLasReservas.stream()
                .filter(r -> r.getUsuario() != null && r.getUsuario().getId().equals(usuario.getId()))
                .collect(Collectors.toList());

        List<ReservaDTO> reservasDTO = reservasUsuario.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(reservasDTO);

    } catch (Exception e) {
        return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
    }
    }

    private ReservaDTO convertToDTO(Reserva reserva) {
        ReservaDTO dto = new ReservaDTO();
        dto.setId(reserva.getId());
        dto.setFechaReserva(reserva.getFechaReserva());
        dto.setCategoriaAsiento(reserva.getCategoriaAsiento());
        dto.setCantidadPasajeros(reserva.getCantidadPasajeros());
        dto.setAsientosReservados(reserva.isAsientosReservados());

        if (reserva.getUsuario() != null) {
            dto.setUsuarioEmail(reserva.getUsuario().getCorreo());
        }

        if (reserva.getVuelos() != null && !reserva.getVuelos().isEmpty()) {
            Vuelo vuelo = reserva.getVuelos().get(0);
            dto.setCodigoVuelo(vuelo.getCodigoVuelo());
            dto.setOrigen(vuelo.getOrigen());
            dto.setDestino(vuelo.getDestino());
            dto.setFechaSalida(vuelo.getFechaHoraSalida());
            dto.setTarifa(vuelo.getTarifa());
        }

        return dto;
    }
}
