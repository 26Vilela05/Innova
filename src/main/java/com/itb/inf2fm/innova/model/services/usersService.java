package com.itb.inf2fm.innova.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itb.inf2fm.innova.model.entity.users;
import com.itb.inf2fm.innova.model.repository.usersRepository;

@Service
public class usersService {

    @Autowired              // Injeção de dependência
    private usersRepository usersRepository;

    // Método responsável em listar todos os Usuarios cadastrados no banco de dados

    public List<users> findAll() {
        return usersRepository.findAll();
    }

    // Método responsável em Criar o Usuario no banco de dados
    public users save(users users) {
        return usersRepository.save(users);
    }

     // Login
    public users login(String email, String passwordHash) {
        return usersRepository.findByEmailAndPasswordHash(email, passwordHash);
    }
    
    // Verificar se email existe
    public boolean emailExiste(String email) {
        return usersRepository.existsByEmail(email);
    }


    // Método responsável em listar o usuario por id

    public users findById(Long id) {
        return usersRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario não encontrado" + id));
    }

    // Método responsável em atualizar usuario
    public users update(Long id, users users) {
        users usersExistente = findById(id);
        usersExistente.setName(users.getName());
        usersExistente.setEmail(users.getEmail());
        usersExistente.setPasswordHash(users.getPasswordHash());
        return usersRepository.save(usersExistente);
    }

    // Método responsável em excluir a usuario ( exclusão física )
    public void delete(Long id) {


        users userExistente = findById(id);
        usersRepository.delete(userExistente);
    }


}
