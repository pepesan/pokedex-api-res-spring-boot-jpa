package com.cursosdedesarrollo.microserviciospring;

import com.cursosdedesarrollo.microserviciospring.domain.Pokemon;
import com.cursosdedesarrollo.microserviciospring.repository.PokemonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PokemonRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void whenFindByName_thenReturnPokemon() {
        // given
        Pokemon pokemon = new Pokemon();
        pokemon.setName("Pokemon");
        entityManager.persist(pokemon);
        entityManager.flush();

        // when
        Pokemon found = pokemonRepository.findByName(pokemon.getName());

        // then
        assertEquals(found.getName(), pokemon.getName());
    }




}
