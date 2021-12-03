# spring-kotlin-user-auth-postgresql
This API was developed using the stacks:
- Kotlin 1.6
- JVM 11
- Spring Boot
- Maven
- Docker
- Swagger
- jUnit5
- Mockito
# How to run
First make sure that you have installed the [docker-compose](https://docs.docker.com/compose/gettingstarted/), run docker-compose command to build local postgresql database:
```sh
$ DOCKER_BUILDKIT=1 docker-compose -f ./docker/local/postgresql/docker-compose.yml up -d
```
Then run the application:
```sh
$ ./mvnw spring-boot:run
```
To access the project documentation, access the url:
```
http://localhost:8080/swagger-ui.html
```
### How to check API health
To check API health you must GET url (authentication needed):
```
http://localhost:8080/actuator/health
```
### How to run tests
```sh
$ ./mvnw test
```

### How to playground
You can play in localhost either by Swagger or importing postman collection.

#### Users

**Administrator username/password:** admin/pass

**Common user username/password:** user/pass