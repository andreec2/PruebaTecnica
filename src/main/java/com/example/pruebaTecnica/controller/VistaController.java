package com.example.pruebaTecnica.controller;

import com.example.pruebaTecnica.model.Usuario;
import com.example.pruebaTecnica.model.Vuelo;
import com.example.pruebaTecnica.repository.VueloRepository;
import com.example.pruebaTecnica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class VistaController {

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/inicio")
    public String mostrarInicio(Model model) {
        List<Vuelo> vuelos = vueloRepository.findAll();
        model.addAttribute("vuelos", vuelos);
        return "inicio";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }



}
