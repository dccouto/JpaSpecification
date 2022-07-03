package com.dccouto.pokedex.controllers;

import com.dccouto.pokedex.models.Pokemom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;


@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    @GetMapping
    public ResponseEntity<Page<Pokemom>> findAll(Pageable pageable){
        ResponseEntity.ok(podedexService.findAll());
    }
}
