package com.dccouto.pokedex.repositories.custom;

import com.dccouto.pokedex.models.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

class PokedexRepositoryImpl implements PokedexRepositoryCustom{
    @Override
    public Page<Pokemon> findByFilter(Pageable pageable) {
        return null;
    }
}
