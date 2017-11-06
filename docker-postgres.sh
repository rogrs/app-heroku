#!/bin/bash
  
docker run --detach \
  --name postgres-db \
  --env POSTGRES_PASSWORD=app-heroku-2017 \
  --env POSTGRES_USER=app-heroku \
  --publish 5432:5432 \
  postgres:9.4.4
