package com.dccouto.pokedex.controllers.dto;

import com.dccouto.pokedex.models.Pokemon;
import com.dccouto.pokedex.models.Pokemon_;
import com.dccouto.pokedex.models.Type;
import com.dccouto.pokedex.models.Type_;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class FilterPokemon {
    private String name;
    private List<FilterType> types = new ArrayList<>();

    public Specification<Pokemon> toSpec(){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.hasText(this.getName())) {
                Path<String> fieldName = root.get(Pokemon_.NAME);
                Predicate predicateName = criteriaBuilder.equal(fieldName, this.getName());
                predicates.add(predicateName);
            }

            this.getTypes().stream().forEach(type -> {
                Path<String> fieldName = root.join(Pokemon_.TYPES).get(Type_.DESCRIPTION);
                Predicate predicateName = criteriaBuilder.equal(fieldName, type.getType());
                predicates.add(predicateName);
            });
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class FilterType{
    private String type;
}
