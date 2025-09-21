package com.raquel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;

@Getter
@AllArgsConstructor
public class Anime {
    private Long id;
    private String name;

    public static List<Anime> listaAnimes() { // static pra nao precisar criar objeto
        var dbz = new Anime(1L, "Dragon Ball");
        var cavaz = new Anime(2L, " Cavaleiros do Zodíaco");
        var saiow = new Anime(3L, "Sailor Moon");
        return List.of(dbz, cavaz, saiow);
    }
   }
