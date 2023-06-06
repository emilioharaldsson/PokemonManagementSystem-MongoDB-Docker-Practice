package com.emilio.pokemon.dao;

import com.emilio.pokemon.model.Pokedex;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PokedexDAO extends MongoRepository<Pokedex, String> {
    Pokedex findByName(String name);
    List<Pokedex> findAll();
    @Query("{ 'types': { $in: [?0] } }")
    List<Pokedex> findByTypesContains(List<String> types);

    @Query("{ 'move' : {$in : [?0] } }")
    List<Pokedex> findByMoveName(String moveName);
}
