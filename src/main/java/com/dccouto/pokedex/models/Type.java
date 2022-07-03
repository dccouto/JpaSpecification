package com.dccouto.pokedex.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "TB_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    private String description;

    @ManyToMany
    @JoinTable(name = "REL_POKEMON_TYPE",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
    private List<Pokemon> pokemons;

}
