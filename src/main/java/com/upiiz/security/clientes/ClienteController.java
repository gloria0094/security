package com.upiiz.security.clientes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    // Definimos los endpoints
    @GetMapping
    public String getAll() {
        return "Todos los clientes - Libre para todos";
    }

    @PostMapping
    public String nuevo() {
        return "Solo para todos - permitido para CREATE";
    }

    @DeleteMapping
    public String eliminarCliente() {
        return "Solo para los usuarios con DELETE";
    }
}