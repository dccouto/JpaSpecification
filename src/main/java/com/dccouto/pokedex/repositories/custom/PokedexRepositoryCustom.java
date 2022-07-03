package com.dccouto.pokedex.repositories.custom;

import com.dccouto.pokedex.models.Pokemon;
import com.dccouto.pokedex.repositories.PokedexRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

interface PokedexRepositoryCustom {
    Page<Pokemon> findByFilter(Pageable pageable);
}
