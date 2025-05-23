package com.example.pruebaTecnica.data;

import com.example.pruebaTecnica.model.Vuelo;
import com.example.pruebaTecnica.repository.VueloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import com.example.pruebaTecnica.model.Usuario;
import com.example.pruebaTecnica.repository.UsuarioRepository;


@Configuration
public class DataInitializer {

@Bean
public CommandLineRunner cargarDatosEjemplo(VueloRepository vueloRepository) {
    return args -> {
        if (vueloRepository.count() == 0) { // Solo insertar si está vacío

            List<Vuelo> vuelos = List.of(
                new Vuelo(null, "AV123", "Bogotá", "Medellín",
                        LocalDateTime.of(2025, 6, 1, 8, 0),
                        LocalDateTime.of(2025, 6, 1, 9, 0),
                        "Avianca", 250.00, 100, true, "Programado", null),

                new Vuelo(null, "LA456", "Bogotá", "Cali",
                        LocalDateTime.of(2025, 6, 2, 10, 30),
                        LocalDateTime.of(2025, 6, 2, 11, 30),
                        "LATAM", 180.00, 80, true, "Programado", null),

                new Vuelo(null, "AV789", "Medellín", "Cartagena",
                        LocalDateTime.of(2025, 6, 3, 14, 0),
                        LocalDateTime.of(2025, 6, 3, 15, 30),
                        "Avianca", 320.00, 60, true, "Programado", null),

                new Vuelo(null, "LA321", "Cali", "San Andrés",
                        LocalDateTime.of(2025, 6, 4, 12, 0),
                        LocalDateTime.of(2025, 6, 4, 14, 0),
                        "LATAM", 410.00, 70, true, "Programado", null),

                new Vuelo(null, "VE101", "Bogotá", "Barranquilla",
                        LocalDateTime.of(2025, 6, 5, 7, 45),
                        LocalDateTime.of(2025, 6, 5, 9, 15),
                        "Viva Air", 200.00, 90, true, "Programado", null),

                new Vuelo(null, "WZ202", "Cali", "Pereira",
                        LocalDateTime.of(2025, 6, 6, 6, 30),
                        LocalDateTime.of(2025, 6, 6, 7, 20),
                        "Wingo", 130.00, 50, true, "Programado", null),

                new Vuelo(null, "AV654", "Bogotá", "Santa Marta",
                        LocalDateTime.of(2025, 6, 7, 13, 15),
                        LocalDateTime.of(2025, 6, 7, 14, 45),
                        "Avianca", 290.00, 85, true, "Programado", null),

                new Vuelo(null, "LA777", "Cartagena", "Bogotá",
                        LocalDateTime.of(2025, 6, 8, 16, 0),
                        LocalDateTime.of(2025, 6, 8, 17, 30),
                        "LATAM", 310.00, 65, true, "Programado", null),

                new Vuelo(null, "VE808", "Medellín", "Cúcuta",
                        LocalDateTime.of(2025, 6, 9, 9, 45),
                        LocalDateTime.of(2025, 6, 9, 11, 15),
                        "Viva Air", 240.00, 75, true, "Programado", null),

                new Vuelo(null, "WZ909", "Bogotá", "Leticia",
                        LocalDateTime.of(2025, 6, 10, 11, 0),
                        LocalDateTime.of(2025, 6, 10, 13, 30),
                        "Wingo", 500.00, 40, true, "Programado", null)
            );

            vueloRepository.saveAll(vuelos);
            System.out.println("✔ 10 vuelos de prueba insertados");
        }
    };
}


    @Bean
    public CommandLineRunner crearUsuarioEjemplo(UsuarioRepository usuarioRepository) {
    return args -> {
        if (usuarioRepository.count() == 0) {
            Usuario usuario = new Usuario();
            usuario.setNombreCompleto("admin");
            usuario.setCorreo("admin@correo.com");
            usuario.setPassword("123456"); 
            usuario.setRol("ADMIN");
            //usuario.setTelefono("3000000000");
            usuarioRepository.save(usuario);
            System.out.println("✔ Usuario de prueba insertado");
        }
    };
}
}
