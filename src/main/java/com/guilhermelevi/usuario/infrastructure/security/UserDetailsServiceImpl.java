package com.guilhermelevi.usuario.infrastructure.security;


import com.guilhermelevi.usuario.infrastructure.entity.ClienteEntity;
import com.guilhermelevi.usuario.infrastructure.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Repositório para acessar dados de usuário no banco de dados
    @Autowired
    private IClienteRepository repository;

    // Implementação do método para carregar detalhes do usuário pelo e-mail
    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        // Busca o usuário no banco de dados pelo e-mail
        ClienteEntity clienteEntity = repository.findByTelefone(nome)
                .orElseThrow(() -> new UsernameNotFoundException("Cliente não encontrado: " + nome));

        // Cria e retorna um objeto UserDetails com base no usuário encontrado
        return org.springframework.security.core.userdetails.User
                .withUsername(clienteEntity.getNome()) // Define o nome de usuário como o e-mail
                .password(clienteEntity.getTelefone()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
