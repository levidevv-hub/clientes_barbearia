package com.guilhermelevi.usuario.business;

import com.guilhermelevi.usuario.business.dto.ClienteDTO;
import com.guilhermelevi.usuario.business.mapper.IMapper;
import com.guilhermelevi.usuario.infrastructure.entity.ClienteEntity;
import com.guilhermelevi.usuario.infrastructure.repository.IClienteRepository;
import com.guilhermelevi.usuario.infrastructure.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private final IClienteRepository repository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final IMapper mapper;

    public ClienteDTO salvarCliente(ClienteDTO clienteDTO) {

        if(repository.existsByNome(clienteDTO.getNome())){
            throw new RuntimeException();
        }

        return mapper.paraDto(repository.save(
                mapper.paraEntity(clienteDTO)
        ));
    }

    public String autenticarUsuario(ClienteDTO clienteDTO) {

        ClienteEntity cliente = repository.findByTelefone(clienteDTO.getTelefone())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return "Bearer " + jwtUtil.generateToken(cliente.getTelefone());
    }

}
