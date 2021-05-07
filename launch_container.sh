#!/usr/bin/env bash
source .env
docker run -p 5000:8080 -d --name pokedex pepesan/pokedex-api-rest-dev:1.1
