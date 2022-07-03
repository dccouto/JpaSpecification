package com.dccouto.pokedex.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity(name = "TB_POKEMON")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;

    //Esse é o dono do relacionamento
    @ManyToMany(mappedBy = "pokemons")
    private List<Type> types;
}
