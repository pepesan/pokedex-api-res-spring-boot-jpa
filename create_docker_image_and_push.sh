#!/usr/bin/env bash
source .env
#Empaquetando
mvn clean package install
#Creando contenedor
docker build -t pepesan/pokedex-api-rest-dev:latest .
docker login -u $REPO_USER -p $REPO_PASS
docker push pepesan/pokedex-api-rest-dev:latest
