package com.guilhermelevi.usuario.controller;

import com.guilhermelevi.usuario.business.ClienteService;
import com.guilhermelevi.usuario.business.dto.ClienteDTO;
import com.guilhermelevi.usuario.business.mapper.IMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;
    private final IMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteDTO> salvarCliente(@RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(service.salvarCliente(cliente));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(service.autenticarUsuario(cliente));
    }

}
