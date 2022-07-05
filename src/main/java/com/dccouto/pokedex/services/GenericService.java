package com.dccouto.pokedex.services;

import com.dccouto.pokedex.models.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

interface GenericService<ENTIDADE, ID, DTO> {
    Page<DTO> findAll(Pageable pageable);
}
