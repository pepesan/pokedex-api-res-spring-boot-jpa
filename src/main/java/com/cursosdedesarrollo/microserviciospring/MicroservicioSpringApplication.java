package com.cursosdedesarrollo.microserviciospring;

import com.cursosdedesarrollo.microserviciospring.domain.Pokemon;
import com.cursosdedesarrollo.microserviciospring.domain.PokemonCSVImport;
import com.cursosdedesarrollo.microserviciospring.repository.PokemonRepository;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MicroservicioSpringApplication extends SpringBootServletInitializer {

    static Logger milog = LoggerFactory.getLogger(MicroservicioSpringApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MicroservicioSpringApplication.class, args);
    }
    protected static Boolean sanitizeArgs(String[] args){
        return args.length>0;
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MicroservicioSpringApplication.class);
    }

    public static void loadCSVData(PokemonRepository repository){
        PokemonCSVImport pi= new PokemonCSVImport();
        List<Pokemon> csvList=pi.importCSV("pokemon.csv");
        for (Pokemon pokemon: csvList) {
            repository.save(pokemon);
        }
        List<Pokemon> databaseList= Lists.newArrayList(repository.findAll());
        milog.info("Data list: {0} ", databaseList.toString());
    }
    public static void loadSampleData(PokemonRepository pokemonRepository){
        Pokemon p = new Pokemon();
        p.setName("Squirtle");
        pokemonRepository.save(p);
        List<Pokemon> databaseList= Lists.newArrayList(pokemonRepository.findAll());
        milog.info("Data list: {0} ",databaseList.toString());
    }

    @Bean
    public CommandLineRunner demo(PokemonRepository pokemonRepository) {
        return args ->
            loadCSVData(pokemonRepository);

    }
}
