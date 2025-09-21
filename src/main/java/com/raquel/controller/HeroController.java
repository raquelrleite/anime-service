package com.raquel.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/heroes")
public class HeroController {

    private static List<String> HEROES = List.of("Naruto", "Kakashi", "Goku", "Sasuke", "Jiraya");

    @GetMapping //Lista TODOS os heróis
    public List<String> listaAllHeroes() {
        return HEROES;
    }

    @GetMapping ("filter") // Endpoint GET /filter — lista os heróis pelo nome
    // Exemplo de chamada: /filter?name=Naruto
    // @RequestParam Diz pro Spring: "espero um parâmetro chamado name na URL". (?name=valor)
    public List<String> listaHeroesNames(@RequestParam(required = false) String name) { //vem vazio se usuario nao colocar o nome
        return HEROES.stream() // stream() → cria um fluxo de dados da lista
                .filter(hero -> hero.equalsIgnoreCase(name)) // mantém apenas os heróis cujo nome ignora maiúsculas/minúsculas.
                .toList(); // transforma de volta em uma lista para retornar na API.
    }


    @GetMapping ("filterList")
    public List<String> listaHeroesNames(@RequestParam List<String> names) { //permite enviar vários nomes
        // Filtra a lista HEROES, mantendo apenas os heróis que estão na lista 'names'
        return HEROES.stream()
                .filter(names::contains) // ::contains verifica se o herói está dentro da lista recebida
                .toList();
    }

    @GetMapping ("{name}")
    public String findByName(@PathVariable String name) {
        return HEROES.stream()
                .filter(hero -> hero.equalsIgnoreCase(name))
                .findFirst() //pega o primeiro elemento que passou no filtro.
                .orElse(""); //se nenhum herói bateu com o nome, retorna uma string vazia ("") em vez de null ou erro.
    }



}
