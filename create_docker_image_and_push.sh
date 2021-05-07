#!/usr/bin/env bash
source .env
#Empaquetando
mvn clean package install
#Creando contenedor
docker build -t pepesan/pokedex-api-rest-dev:latest .
docker build -t pepesan/pokedex-api-rest-dev:1.1 .
docker login -u $REPO_USER -p $REPO_PASS
docker push pepesan/pokedex-api-rest-dev:latest
docker push pepesan/pokedex-api-rest-dev:1.1
