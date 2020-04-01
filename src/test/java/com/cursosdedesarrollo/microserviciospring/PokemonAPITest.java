package com.cursosdedesarrollo.microserviciospring;

import com.cursosdedesarrollo.microserviciospring.domain.Pokemon;
import com.cursosdedesarrollo.microserviciospring.repository.PokemonRepository;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

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
                .andExpect(content().string(containsString("Bulbasaur")));
    }

}