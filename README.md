# Spring Boot Heroku demo 
[![Build Status](https://travis-ci.org/rogrs/app-heroku.svg?branch=master)](https://travis-ci.org/rogrs/app-heroku)
[![codecov](https://codecov.io/gh/rogrs/app-heroku/branch/master/graph/badge.svg)](https://codecov.io/gh/rogrs/app-heroku) 
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

> Projeto de Crud utilizando Java, springboot e Postgres SQL

This is a small demo application for showing how to run a [Spring Boot](http://projects.spring.io/spring-boot/)
application on [Heroku](http://heroku.com). For more information see the Dev Center article on 
[Deploying Spring Boot Applications to Heroku](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku).

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)


## Running the application

To run the application from your IDE, simply run the `br.com.rogrs.Application` class as
a Java Application.
Alternatively the application can be started from the terminal using maven with `mvn spring-boot:run`.
After starting the application, point your browser to http://localhost:8080.

## Using a Postgres database for persistence

For running the application using a real [Postgres](http://www.postgresql.org/) database, uncomment all property
definitions in the `application.properties` file and put the configuration for your Postgres instance there.
You can also use [Docker](http://docker.com) for starting a Postgres database. Just run the `docker-postgres.sh` script
and it will create a Postgres container for you. When using docker, all you have to change in the
`application.properties` file is `spring.datasource.url`. For boot2docker users, the host name should already be
correct. For Linux users it has to be changed to localhost.

## License

Code is under the [Apache Licence v2](https://www.apache.org/licenses/LICENSE-2.0.txt).
