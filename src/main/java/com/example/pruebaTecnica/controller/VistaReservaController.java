package com.example.pruebaTecnica.controller;

import com.example.pruebaTecnica.model.Reserva;
import com.example.pruebaTecnica.model.Usuario;
import com.example.pruebaTecnica.model.Vuelo;
import com.example.pruebaTecnica.repository.UsuarioRepository;
import com.example.pruebaTecnica.repository.VueloRepository;
import com.example.pruebaTecnica.service.ReservaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VistaReservaController {

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/reservar")
    @Transactional
    public String reservarVuelo(@RequestParam("vueloId") Long vueloId,
                                @RequestParam("categoriaAsiento") String categoriaAsiento,
                                @RequestParam("cantidadPasajeros") int cantidadPasajeros,
                                @AuthenticationPrincipal UserDetails userDetails,
                                Model model) {
        try {
            // Buscar vuelo
            Vuelo vuelo = vueloRepository.findById(vueloId).orElse(null);
            if (vuelo == null) {
                model.addAttribute("error", "Vuelo no encontrado.");
                model.addAttribute("vuelos", vueloRepository.findAll());
                return "inicio";
            }


            Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(userDetails.getUsername());
            System.out.println();
            if (usuarioOpt.isEmpty()) {
                model.addAttribute("error", "Usuario no encontrado.");
                model.addAttribute("vuelos", vueloRepository.findAll());
                return "inicio";
            }

            Usuario usuario = usuarioOpt.get();
            System.out.println(usuario + "aqui esta el usuario bobo :v");
            // Crear nueva reserva
            Reserva reserva = new Reserva();
            reserva.setUsuario(usuario);
            reserva.setVuelos(Collections.singletonList(vuelo));
            reserva.setFechaReserva(LocalDateTime.now());
            reserva.setCategoriaAsiento(categoriaAsiento);
            reserva.setCantidadPasajeros(cantidadPasajeros);
            reserva.setAsientosReservados(true);
            usuario.agregarReserva(reserva);

            // Guardar la reserva
            Reserva reservaGuardada = reservaService.save(reserva);

            // Verificar que se guardó correctamente
            if (reservaGuardada != null && reservaGuardada.getId() != null) {
                model.addAttribute("mensaje", "Reserva realizada con éxito. ID: " + reservaGuardada.getId());
            } else {
                model.addAttribute("error", "Error al guardar la reserva.");
            }

        } catch (Exception e) {
            model.addAttribute("error", "Error al procesar la reserva: " + e.getMessage());
            e.printStackTrace(); // Para debug
        }

        model.addAttribute("vuelos", vueloRepository.findAll());
        return "inicio";
    }

    @GetMapping("/mis-reservas")
    public String verMisReservas(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(userDetails.getUsername());
        if (usuarioOpt.isEmpty()) {
            model.addAttribute("error", "Usuario no encontrado.");
            return "inicio";
        }

        Usuario usuario = usuarioOpt.get();
        Long idUsuario = usuario.getId(); 
        System.out.println(usuario + " aqui esta el usuario bobo :v" + " con id: " + idUsuario);

        List<Reserva> todasLasReservas = reservaService.findAll();
        System.out.println(todasLasReservas + " aqui estan las reservas bobo :v");
        List<Reserva> misReservas = todasLasReservas.stream()
                .filter(r -> r.getUsuario().getId().equals(idUsuario))
                .toList();
        
        System.out.println(todasLasReservas + " aqui estan las reservas de usuario bobo :v");


        model.addAttribute("reservas", misReservas);

        return "mis-reservas";
    }

}