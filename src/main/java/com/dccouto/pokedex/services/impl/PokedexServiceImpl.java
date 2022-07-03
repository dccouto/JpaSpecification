package com.dccouto.pokedex.services.impl;

import com.dccouto.pokedex.models.Pokemon;
import com.dccouto.pokedex.repositories.PokedexRepository;
import com.dccouto.pokedex.services.PodedexService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PokedexServiceImpl implements PodedexService {

    private final PokedexRepository pokedexRepository;
    @Override
    public Page<Pokemon> findAll(Pageable pageable) {
        return pokedexRepository.findAll(pageable);
    }
}
