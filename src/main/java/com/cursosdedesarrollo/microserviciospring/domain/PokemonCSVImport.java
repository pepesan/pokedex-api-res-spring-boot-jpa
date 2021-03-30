package com.cursosdedesarrollo.microserviciospring.domain;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class PokemonCSVImport {
    public Logger logger = LoggerFactory.getLogger(PokemonCSVImport.class);
    public List<Pokemon> importCSV(String filePath){
        List<Pokemon> list = new LinkedList<>();
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            InputStream is = new ClassPathResource(filePath).getInputStream();
            MappingIterator<Pokemon> readValues =
                    mapper.readerWithSchemaFor(Pokemon.class).with(bootstrapSchema).readValues(is);
            list=readValues.readAll();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return list;
    }
}
