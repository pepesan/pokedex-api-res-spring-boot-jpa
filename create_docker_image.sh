#!/usr/bin/env bash
#Empaquetando
mvn clean package
#Creando contenedor
docker build -t pepesan/pokedex-microservice:latest .
