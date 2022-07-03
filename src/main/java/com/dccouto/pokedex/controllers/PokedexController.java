package com.dccouto.pokedex.controllers;

import com.dccouto.pokedex.models.Pokemon;
import com.dccouto.pokedex.services.PodedexService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/pokedex")
@RequiredArgsConstructor
public class PokedexController {

    private final PodedexService podedexService;


    @GetMapping
    public ResponseEntity<Page<Pokemon>> findAll(Pageable pageable){
        return ResponseEntity.ok(podedexService.findAll(pageable));
    }
}
