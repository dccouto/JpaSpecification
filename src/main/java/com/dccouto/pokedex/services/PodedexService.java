package com.dccouto.pokedex.services;

import com.dccouto.pokedex.controllers.dto.FilterPokemon;
import com.dccouto.pokedex.models.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PodedexService extends GenericService<Pokemon, UUID> {
    Page<Pokemon> findAllByFilter(FilterPokemon filterPokemon, Pageable pageable);

}
