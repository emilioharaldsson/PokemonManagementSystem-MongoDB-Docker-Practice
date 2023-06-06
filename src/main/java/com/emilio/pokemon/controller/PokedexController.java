package com.emilio.pokemon.controller;

import com.emilio.pokemon.dao.PokedexDAO;
import com.emilio.pokemon.model.Pokedex;
import com.emilio.pokemon.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokedex")
public class PokedexController {
    @Autowired
    private PokedexDAO pokedexDAO;

    @Autowired
    private PokedexService pokedexService;
    @GetMapping(value = "/{pokemonName}", produces = "application/json")
    public Pokedex getPokemonByName(@PathVariable String pokemonName){
        Pokedex pokemon = pokedexDAO.findByName(pokemonName);
        return pokemon;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Pokedex> getAllPokemon(){
        return pokedexDAO.findAll();
    }

    @GetMapping(value= "/type", produces = "application/json")
    public List<Pokedex> getPokemonByType(@RequestParam String types){
        return pokedexService.getPokemonByType(types);
    }

    @GetMapping(value="/move", produces ="application/json")
    public List<Pokedex> getPokemonByMove(@RequestParam String moveName){
        return pokedexService.getPokemonByMove(moveName);
    }

}
