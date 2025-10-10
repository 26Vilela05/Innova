package com.itb.inf2fm.innova.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.itb.inf2fm.innova.model.entity.users;
import com.itb.inf2fm.innova.model.services.usersService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// No spring é comum adicionarmos anotações (annotation) em classes, atributos e métodos
// Uma annotation é uma forma de adicionar informações (metadados) ao seu código que podem
// ser interpretadas pelo compilador ou em tempo de execução por ferramentas e frameworks
// como o Spring
// Uma annotation é uma palavra iniciada com '@' que você coloca acima de uma class, método,
// atributo ou parâmetro, para dar instruções extras ao Java ou a algum framework sobre como
// aquele elemento deve ser tratado.

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class usersController {

    @Autowired
    private usersService usersService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("API funcionando! Servidor ativo em: " + java.time.LocalDateTime.now());
    }

    @GetMapping("/test")
    public ResponseEntity<List<users>> listar() {
        return ResponseEntity.ok(usersService.findAll());
    }

    @GetMapping("/health")
    public ResponseEntity<Object> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", java.time.LocalDateTime.now());
        response.put("service", "FashionSpace API");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<users>> findAll() {

        return ResponseEntity.ok(usersService.findAll());
    }

    // @RequestBody : Corpo da Requisição ( Recebendo um objeto JSON )
    // RespondeEntity: Toda resposta HTTP (status, cabeçalhos e corpo), aqui temos
    // mais controle sobre o que é devolvido para o cliente
    // 1. Status HTTP ( 200 ok, 201 CREATED, 404 NOT FOUND etc...)
    // 2. Headers: ( cabeçalhos extras, como Location, Authorization etc...)
    // 3. Body: ( o objeto que será convertido em JSON/XML para o cliente )

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody users users) {
        if (usersService.emailExiste(users.getEmail())) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email já cadastrado");
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(usersService.save(users));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> dados) {
        users users = usersService.login(dados.get("email"), dados.get("passwordHash"));
        if (users != null) {
            return ResponseEntity.ok(users);
        }
        Map<String, String> response = new HashMap<>();
        response.put("message", "Email ou passwordHash incorretos");
        return ResponseEntity.status(401).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listarUsuarioPorId(@PathVariable String id) {
        try {
            return ResponseEntity.ok(usersService.findById(Long.parseLong(id)));
        } catch (NumberFormatException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", 400);
            errorResponse.put("error", "Bad Request");
            errorResponse.put("message", "O id informado não é válido: " + id);
            return ResponseEntity.badRequest().body(errorResponse);

        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", 404);
            errorResponse.put("error", "Not Found");
            errorResponse.put("message", "Usuario não encontrada com o id " + id);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable String id, @RequestBody users users) {
        try {
            Long usersId = Long.parseLong(id);
            users usersExistente = usersService.findById(usersId); // já lança exceção se não achar

            usersExistente.setName(users.getName());
            usersExistente.setEmail(users.getEmail());
            usersExistente.setPasswordHash(users.getPasswordHash());

            users userAtualizada = usersService.save(usersExistente);

            return ResponseEntity.ok(userAtualizada);
        } catch (NumberFormatException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", 400);
            errorResponse.put("error", "Bad Request");
            errorResponse.put("message", "O id informado não é válido: " + id);
            return ResponseEntity.badRequest().body(errorResponse);

        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", 404);
            errorResponse.put("error", "Not Found");
            errorResponse.put("message", "Usuario não encontrada com o id " + id);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirUsuario(@PathVariable String id) {
        try {
            Long usersId = Long.parseLong(id);
            usersService.delete(usersId); // chama o service
            Map<String, String> response = new HashMap<>();
            response.put("message", "Usuario deletada com sucesso");
            return ResponseEntity.ok(response);
        } catch (NumberFormatException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", 400);
            errorResponse.put("error", "Bad Request");
            errorResponse.put("message", "O id informado não é válido: " + id);
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", 404);
            errorResponse.put("error", "Not Found");
            errorResponse.put("message", "Usuario não encontrada com o id " + id);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

}
