package com.dccouto.pokedex.models;

import com.dccouto.pokedex.dto.PokemonDto;
import com.dccouto.pokedex.dto.TypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_POKEMON")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //Esse é o dono do relacionamento
    @ManyToMany(mappedBy = "pokemons")
    private List<Type> types;

    public PokemonDto convertToDto(){
        return new PokemonDto(id, name, types.stream().map(Type::convertToDto).collect(Collectors.toList()));
    }

}
