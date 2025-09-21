package com.raquel.controller;

import com.raquel.domain.Anime;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller: é como um garçom — recebe os pedidos HTTP (GET, POST, DELETE...) e repassa para o service
@RestController
@RequestMapping("v1/animes")  // Define o caminho base da URL. Todas as rotas vão começar com v1/animes

public class AnimeController {

    @GetMapping("lista")
    //Pode chamar pelo lista ou por nome
    public List<Anime> listAll(@RequestParam(required = false) String name) {
        var animes = Anime.listaAnimes();// pega todos os animes
        if (name == null) { // se não passou nome, retorna tudo
            return animes;
        }
        // se passou nome, filtra e retorna apenas o que bate
        return Anime.listaAnimes().stream()
                .filter(anime -> anime.getName().equalsIgnoreCase(name))
                .toList();
    }

    @GetMapping("{id}")
    // Chamar por ID
    public Anime findById(@PathVariable Long id) {
        return Anime.listaAnimes().stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElse(null); // retorna null se não encontrar
    }

}


