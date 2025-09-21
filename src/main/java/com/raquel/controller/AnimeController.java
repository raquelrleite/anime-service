package com.raquel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// Controller: é como um garçom — recebe os pedidos HTTP (GET, POST, DELETE...) e repassa para o service
@RestController
@RequestMapping("v1/animes")  // Define o caminho base da URL. Todas as rotas vão começar com v1/animes

public class AnimeController {

    @GetMapping("lista") // Essa rota responde a GET v1/animes/lista — usada para listar os animes
    public List<String> listaAnimes() {
        return List.of("Naruto", "DBZ");
    }
}
