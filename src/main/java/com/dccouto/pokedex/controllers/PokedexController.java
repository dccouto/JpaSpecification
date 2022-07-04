package com.dccouto.pokedex.controllers;

import com.dccouto.pokedex.controllers.dto.FilterPokemon;
import com.dccouto.pokedex.models.Pokemon;
import com.dccouto.pokedex.services.PodedexService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/pokedex")
@RequiredArgsConstructor
public class PokedexController {

    private final PodedexService podedexService;


    @GetMapping
    public Page<Pokemon> findAll(Pageable pageable){
        return podedexService.findAll(pageable);
    }
    @PostMapping("/filter")
    public ResponseEntity<Page<Pokemon>> findAllByFilter(@RequestBody FilterPokemon filter, Pageable pageable){
        return ResponseEntity.ok(podedexService.findAllByFilter(filter ,pageable));
    }
}
