<h2 align="center">Spring Kotlin API Auth with PostgreSQL</h2>

<p align="center">
  <a href="https://github.com/joaogcs/spring-kotlin-user-auth-postgresql/actions"><img alt="Actions Status" src="https://github.com/joaogcs/spring-kotlin-user-auth-postgresql/workflows/CI/badge.svg"></a>
  <a href="https://github.com/relekang/python-semantic-release"><img alt="Semantic Release" src="https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg"></a>
  <a href="https://github.com/joaogcs/spring-kotlin-user-auth-postgresql/blob/master/LICENSE"><img alt="GitHub" src="https://img.shields.io/github/license/joaogcs/spring-kotlin-user-auth-postgresql"/></a>
  <a href="https://open.vscode.dev/joaogcs/spring-kotlin-user-auth-postgresql"><img alt="Open in Visual Studio Code" src="https://open.vscode.dev/badges/open-in-vscode.svg"/></a>
</p>

# 
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
```console
$ DOCKER_BUILDKIT=1 docker-compose -f ./docker/local/postgresql/docker-compose.yml up -d
```
Then run the application:
```console
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
