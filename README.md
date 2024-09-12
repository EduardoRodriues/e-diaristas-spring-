# Projeto E-Diaristas

Projeto desenvolvido durante a imersão multistack da [treinaweb](https://treinawen.com.br/) utilizando java e spring-boot

## Dependêcias do Projeto

- Spring Boot
- Spring Web MVC 
- Thymeleaf
- Spring Data JPA
- Bean Validation

## Dependências de Desenvolvimento

- Spring Boot Dev Tools
- Lombok 

## Requisitos

- Java 22
- Maven

## Como testar esse projeto na minha máquina?

Clone este repositório e entre na pasta do projeto.

```sh
git clone https://github.com/EduardoRodriues/e-diaristas-spring-.git
cd e-diaristas-spring-
```

Atualize as configurações do acesso ao banco de dados no arquivo [applications.properties](src/main/resources/application.properties)

```properties
spring.datasource.url=jdbc:mysql://host:porta/banco_de_dados
spring.datasource.username=usuario
spring.datasource.password=senha
```

Execute o projeto através do Maven.

```sh
mvn spring-boot:run
```

Acesse a aplicacão em [http://localhost:8080/admin/servico](http://localhost:8080/admin/servico)