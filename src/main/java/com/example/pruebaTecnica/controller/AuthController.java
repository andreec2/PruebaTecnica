package com.example.pruebaTecnica.controller;

import com.example.pruebaTecnica.model.Usuario;
import com.example.pruebaTecnica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam String correo, @RequestParam String contraseña) {
        Usuario nuevo = new Usuario();
        nuevo.setCorreo(correo);
        nuevo.setPassword(contraseña);
        usuarioService.save(nuevo);
        return "redirect:/login";
    }
}
