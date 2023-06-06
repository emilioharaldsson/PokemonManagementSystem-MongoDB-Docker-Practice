package com.emilio.pokemon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Pokedex")
public class Pokedex {
    @Id
    private String id;
    private int num;
    private String name;
    private List<String> types;
    private int hp;
    private int atk;
    private int def;
    private int sp_atk;
    private int sp_def;
    private int spd;
    private List<String> move;
}
