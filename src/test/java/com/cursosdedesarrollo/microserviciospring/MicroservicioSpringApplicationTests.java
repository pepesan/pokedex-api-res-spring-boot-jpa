package com.cursosdedesarrollo.microserviciospring;

import com.cursosdedesarrollo.microserviciospring.repository.PokemonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroservicioSpringApplicationTests {
    @Autowired
    public PokemonRepository pokemonRepository;

    @Test
    public void contextLoads() {
        assertThat(true).isNotNull();
        MicroservicioSpringApplication.loadCSVData(pokemonRepository);
        assertThat(pokemonRepository.count()).isEqualTo(721);
    }

}
