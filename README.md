
[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white

<h1 align="center" style="font-weight: bold;">Desafio Back-end PicPay 💻</h1>

![spring][SPRING_BADGE]
![java][JAVA_BADGE]

<p align="center">
 <a href="#started">Getting Started</a> 
  <a href="#routes">API Endpoints</a> 
   <a href="https://github.com/PicPay/picpay-desafio-backend">Repositório do Desafio</a> 
</p>

<p align="center">
  <b>Sistema para transferência de dinheiro entre dois tipos de usuários, onde apenas um tipo de usuário pode realizar transferências.</b>​
</p>


<h2 id="started">🚀 Para dar início ao sistema.</h2>


<h3>Pré-requisitos</h3>

- [Java 17](https://github.com/)
- [PostgreSql](https://github.com)
- [Spring Boot](https://github.com)
  

<h2 id="routes">📍 API Endpoints</h2>

| route               | description                                          
|----------------------|-----------------------------------------------------
|  <kbd>POST /transacao</kbd>    | Permite realizar transferências entre os usuários. [response details](#post-transacao)
|  <kbd>POST /usuario</kbd>  | Permite criar um usuário. [request details](#post-usuario)
|  <kbd>GET /usuario</kbd>  | Permite buscar todos os usuários cadastrado no sistema. [request details](#get-usuario)


<h3 id="post-transacao">POST /transacao</h3>

**REQUEST**
```json
{
    "remetente": 1,
    "destino": 8,
    "valor": 50.0
}
```
**RESPONSE**
```json
{
    "id": 3,
    "valor": 50.0,
    "destino": {
        "id": 8,
        "primeiroNome": "caio",
        "ultimoNome": "caetano",
        "cpf": "123.456.789-33",
        "email": "caio@example.com",
        "senha": "senha123",
        "caixa": 550.50,
        "tipoUsuario": "lojista"
    },
    "remetente": {
        "id": 1,
        "primeiroNome": "João",
        "ultimoNome": "Silva",
        "cpf": "123.456.789-00",
        "email": "joao.silva@example.com",
        "senha": "senhaSegura123",
        "caixa": 1450.50,
        "tipoUsuario": "usuario"
    },
    "dataTransacao": "2025-01-29T13:17:52.4999575"
}
```



<h3 id="post-usuario">POST /usuario</h3>

**REQUEST**
```json
{
  "primeiroNomer": "caio",
  "segundoNome": "caetano",
  "cpf": "123.456.789-33",
  "email": "caio@example.com",
  "senha": "senha123",
  "caixa": 500.50,
  "tipoUsuario": "lojista"
}
```
**RESPONSE**
```json
{
    "id": 8,
    "primeiroNome": "caio",
    "ultimoNome": "caetano",
    "cpf": "123.456.789-33",
    "email": "caio@example.com",
    "senha": "senha123",
    "caixa": 500.50,
    "tipoUsuario": "lojista"
}
```

<h3 id="post-auth-detail">GET /usuario</h3>

**RESPONSE**
```json
{
    "id": 8,
    "primeiroNome": "caio",
    "ultimoNome": "caetano",
    "cpf": "123.456.789-33",
    "email": "caio@example.com",
    "senha": "senha123",
    "caixa": 500.50,
    "tipoUsuario": "lojista"
}
```
