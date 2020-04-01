package com.cursosdedesarrollo.microserviciospring;

import com.cursosdedesarrollo.microserviciospring.domain.Pokemon;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

public class PokemonRepositoryControllerTest extends PokemonRestControllerIntegrationTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getPokemonList() throws Exception {
        String uri = "/pokemons";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Contenido: listado: " + content);
        //Pokemon[] productlist = super.mapFromJson(content, Pokemon[].class);
        //assertTrue(productlist.length > 0);
    }
    @Test
    public void getPokemonById() throws Exception {
        String uri = "/pokemons/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Contenido: listado: " + content);
        //Pokemon[] productlist = super.mapFromJson(content, Pokemon[].class);
        //assertTrue(productlist.length > 0);
    }
    @Test
    public void createPokemon() throws Exception {
        String uri = "/pokemons";
        Pokemon pokemon = new Pokemon();
        pokemon.setName("Ginger");
        String inputJson = super.mapToJson(pokemon);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Contenido: create: " + content);
        //assertEquals(content, "Product is created successfully");
    }
    @Test
    public void updatePokemon() throws Exception {
        String uri = "/pokemons";
        Pokemon pokemon = new Pokemon();
        pokemon.setName("Ginger");
        String inputJson = super.mapToJson(pokemon);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Contenido: update: " + content);

        uri = "/pokemons/2";
        pokemon = new Pokemon();
        pokemon.setName("Pokemon");
        inputJson = super.mapToJson(pokemon);
        mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        status = mvcResult.getResponse().getStatus();
        // System.out.println(status);
        //assertEquals(200, status);
        content = mvcResult.getResponse().getContentAsString();
        System.out.println("Contenido: update 2: " + content);
        uri = "/pokemons/2";
        mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        status = mvcResult.getResponse().getStatus();
        System.out.println(status);
        //assertEquals(200, status);
        content = mvcResult.getResponse().getContentAsString();
        System.out.println("Contenido: update: " + content);
    }
    @Test
    public void deleteProduct() throws Exception {
        String uri = "/pokemons/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        //assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Contenido: delete: " +content);
        //assertEquals(content, "Product is deleted successsfully");
    }
}
