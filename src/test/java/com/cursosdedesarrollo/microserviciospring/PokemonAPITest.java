package com.cursosdedesarrollo.microserviciospring;

import com.cursosdedesarrollo.microserviciospring.domain.Pokemon;
import com.cursosdedesarrollo.microserviciospring.repository.PokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.engine.Constants;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class PokemonAPITest {

    @Autowired
    private PokemonRepository controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnBulbasaur() throws Exception {
        this.mockMvc.perform(get("/pokemons")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Ivysaur")));

    }

    @Test
    public void testListOfPokemon() throws Exception{
        final ResultActions result = this.mockMvc.perform(get("/pokemons")).andExpect(status().isOk());
        result.andExpect(jsonPath("_embedded.pokemons[0].name", Matchers.is("Ivysaur")));
        //result.andExpect(jsonPath("_embedded.pokemons[0].name", is("Bulbasaur")));
    }
    @Autowired private ObjectMapper mapper;
    @Test
    public void testCreatePokemon() throws Exception{
        Pokemon pokemon = new Pokemon();
        pokemon.setName("Pokemon");
        final ResultActions result =
                this.mockMvc.perform(
                        post("/pokemons")
                        .content(mapper.writeValueAsBytes(pokemon))
                        .contentType(MediaType.APPLICATION_JSON_UTF8));
        result.andDo(print()).andExpect(status().isCreated());

        //result.andDo(print()).andExpect(jsonPath("name", Matchers.is("Pokemon")));
        //result.andExpect(jsonPath("_embedded.pokemons[0].name", is("Bulbasaur")));
    }
    /*
    @Test
    public void testGetPokemonFromId() throws Exception{
        final ResultActions result = this.mockMvc.perform(get("/pokemons/1")).andExpect(status().isOk());
        //result.andDo(print());
        result.andExpect(jsonPath("name", Matchers.is("Bulbasaur")));
    }

     */
    @Test
    public void testUpdatePokemon() throws Exception{
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName("Pokemon");
        final ResultActions result =
                this.mockMvc.perform(
                        put("/pokemons/1")
                                .content(mapper.writeValueAsBytes(pokemon))
                                .contentType(MediaType.APPLICATION_JSON_UTF8));
        result.andDo(print()).andExpect(status().is2xxSuccessful());

        //result.andDo(print()).andExpect(jsonPath("name", Matchers.is("Pokemon")));
        //result.andExpect(jsonPath("_embedded.pokemons[0].name", is("Bulbasaur")));
    }
    @Test
    public void testDeletePokemonFromId() throws Exception{
        final ResultActions result = this.mockMvc.perform(delete("/pokemons/1")).andExpect(status().is2xxSuccessful());
        result.andDo(print());
        //result.andExpect(jsonPath("name", Matchers.is("Bulbasaur")));
    }
}