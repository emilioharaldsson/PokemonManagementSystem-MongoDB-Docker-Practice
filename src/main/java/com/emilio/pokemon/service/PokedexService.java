package com.emilio.pokemon.service;

import com.emilio.pokemon.dao.PokedexDAO;
import com.emilio.pokemon.model.Pokedex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PokedexService {
    @Autowired
    private PokedexDAO pokedexDAO;

    public List<Pokedex> getPokemonByType(String typesInput){
        List<String> types = Arrays.asList(typesInput.split(","));
        return pokedexDAO.findByTypesContains(types);
    }

    public List<Pokedex> getPokemonByMove(String moveName){
        return pokedexDAO.findByMoveName(moveName.replace("_", " "));
    }
}
