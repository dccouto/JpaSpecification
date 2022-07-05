package com.dccouto.pokedex.services.impl;

import com.dccouto.pokedex.controllers.dto.FilterPokemon;
import com.dccouto.pokedex.dto.PokemonDto;
import com.dccouto.pokedex.models.Pokemon;
import com.dccouto.pokedex.repositories.PokedexRepository;
import com.dccouto.pokedex.services.PodedexService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PokedexServiceImpl implements PodedexService {

    private final ModelMapper modelMapper;
    private final PokedexRepository pokedexRepository;
    @Override
    public Page<PokemonDto> findAll(Pageable pageable) {
        Page<Pokemon> pagePokemon = pokedexRepository.findAll(pageable);
        Page<PokemonDto> pageDto = pagePokemon.map(Pokemon::convertToDto);
        return pageDto;
    }
    @Override
    public Page<PokemonDto> findAllByFilter(@NotNull FilterPokemon filterPokemon, Pageable pageable) {
        Page<Pokemon> entityPage = pokedexRepository.findAll(filterPokemon.toSpec(), pageable);
        return entityPage.map(Pokemon::convertToDto);
    }
}
