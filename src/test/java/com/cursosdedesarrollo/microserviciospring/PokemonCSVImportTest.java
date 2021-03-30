package com.cursosdedesarrollo.microserviciospring;

import com.cursosdedesarrollo.microserviciospring.domain.PokemonCSVImport;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PokemonCSVImportTest {
    @Test
    public void contexLoads() throws Exception {
        assertThat(new PokemonCSVImport()).isNotNull();
        assertThat(new PokemonCSVImport().logger).isNotNull();
    }
}
