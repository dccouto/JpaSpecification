package com.dccouto.pokedex.repositories;

import com.dccouto.pokedex.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PokedexRepository extends JpaRepository<Pokemon, Long>,
        JpaSpecificationExecutor<Pokemon> {
}
