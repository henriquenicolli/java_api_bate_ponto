# REP API

## Descrição
A **REP API** é uma API desenvolvida em **Spring Boot** para gerenciar registros de ponto, empregados, empresas e autenticação de usuários.

## Requisitos
- Java 17+
- Maven
- Docker

## Instalação e Execução


1. Navegue até o diretório do projeto:
   ```sh
   cd nome-do-projeto
   ```
2. Roda a stack local com docker
    ```sh
   cd /test/docker-compose
   docker-compose up -d
   ```
3. Compile e rode a aplicação:
   ```sh
   mvn spring-boot:run
   ```



A API estará disponível em `http://localhost:10000`.

## Endpoints

### Autenticação

- **Gerar Token**  
  `POST /v1/rep/authenticate`
    - Request Body:
      ```json
      {
        "username": "root",
        "password": "admin"
      }
      ```
    - Response:
      ```json
      {
        "token": "eyJhbGciOiJIUzI1NiJ9..."
      }
      ```

### Registros de Ponto

- **Buscar Registros do Mês**  
  `GET /v1/rep/registroPonto?mes_selecionado={mes}&id_funcionario={id}`

- **Criar Registro de Ponto**  
  `POST /v1/rep/registroPonto/salvar`
    - Request Body:
      ```json
      {
        "dataMarcacaoPonto": "2023-12-31",
        "horaMarcacaoPonto": "18:00:00",
        "cpfFuncionario": "123.456.789-00",
        "latitude": -23.5632108,
        "longitude": -46.6542501,
        "motivoMarcacao": "Inicio de expediente"
      }
      ```

- **Atualizar Registro de Ponto**  
  `PATCH /v1/rep/registroPonto/atualizar`
    - Request Body: mesmo formato do POST

- **Deletar Registro de Ponto**  
  `DELETE /v1/rep/registroPonto/deletar`
    - Request Body:
      ```json
      {
        "numeroSequencialRegistro": 11
      }
      ```

### Empregados

- **Salvar um novo empregado**  
  `POST /v1/rep/empregado/salvar`
    - Request Body:
      ```json
      {
        "empNome": "Henrique Biondo",
        "cpf": "123.456.789-00",
        "dataAdmissao": "2023-01-01",
        "email": "joao.silva@example.com",
        "departamento": "Desenvolvimento",
        "cargo": "Desenvolvedor"
      }
      ```

- **Buscar empregados de uma empresa**  
  `GET /v1/rep/empregado/buscar/{id_empresa}`

### Empresas

- **Salvar uma empresa**  
  `POST /v1/rep/empresa/salvar`
    - Request Body:
      ```json
      {
        "nomeEmpresa": "Empresa Exemplo",
        "razaoSocial": "Empresa Exemplo Ltda",
        "cnpj": "12345678901234"
      }
      ```

### Usuários

- **Criar Usuário**  
  `POST /v1/rep/usuario/salvar`
    - Request Body:
      ```json
      {
        "login": "biondo",
        "senha": "admin",
        "email": "usuarioExemplo@email.com"
      }
      ```

## Autenticação
A API utiliza **JWT Bearer Token** para autenticação. Inclua o token no cabeçalho de cada requisição:
```sh
Authorization: Bearer SEU_TOKEN_AQUI
```


