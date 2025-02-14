# Desafio Prático de Programação – Gestão de Funcionários

Este projeto foi desenvolvido como parte de um desafio para uma vaga de emprego. Ele consiste em criar uma aplicação Java utilizando Spring Boot para gerenciar dados de funcionários de uma indústria, atendendo a uma série de requisitos especificados.

---

## Visão Geral do Projeto

A aplicação tem como objetivo:

1. **Gerenciar os dados de pessoas/funcionários** em um banco de dados (neste caso, H2 em memória).
2. **Executar operações** como cadastro, exclusão, aumento salarial, agrupamento por função, listagem de aniversariantes em determinados meses, cálculo do total de salários, dentre outras.
3. **Disponibilizar endpoints REST** para que cada funcionalidade possa ser acessada via HTTP.

---

## Requisitos Atendidos

De acordo com o enunciado do desafio, foram implementados os seguintes pontos:

1. **Classe `Pessoa`** com atributos:
   - `nome (String)`
   - `dataNascimento (LocalDate)`

2. **Classe `Funcionario`** que estende `Pessoa`, com atributos:
   - `salario (BigDecimal)`
   - `funcao (String)`

3. **Operações solicitadas**:
   1. **Inserir todos os funcionários** (com base na tabela fornecida).
   2. **Remover o funcionário “João”** da lista.
   3. **Imprimir todos os funcionários** com informações de nome, data de nascimento e salário formatado.
   4. **Conceder 10% de aumento** para todos os funcionários.
   5. **Agrupar funcionários por função** em um `Map<String, List<Funcionario>>`.
   6. **Imprimir funcionários agrupados** por função.
   7. **Imprimir funcionários que fazem aniversário** nos meses 10 e 12.
   8. **Imprimir o funcionário mais velho** (exibindo nome e idade).
   9. **Imprimir a lista de funcionários em ordem alfabética**.
   10. **Imprimir o total dos salários** de todos os funcionários.
   11. **Imprimir quantos salários mínimos** cada funcionário recebe, considerando o valor de R\$ 1.212,00.

---

## Estrutura do Projeto

```
gestaoFuncionarios
├── src/main/java/com/iniflex/gestaoFuncionarios
│   ├── GestaoFuncionariosApplication.java        // Classe principal que inicializa o Spring Boot
│   ├── controller
│   │   └── FuncionarioController.java            // Endpoints REST para manipular dados de Funcionário
│   ├── entity
│   │   ├── Pessoa.java                           // Classe base com atributos nome e dataNascimento
│   │   └── Funcionario.java                      // Classe que estende Pessoa e adiciona salario e funcao
│   ├── repository
│   │   └── FuncionarioRepository.java            // Interface de acesso ao banco de dados (Spring Data JPA)
│   └── service
│       └── FuncionarioService.java               // Lógica de negócio para operações com Funcionários
└── pom.xml                                        // Gerenciamento de dependências Maven
```

---

## Endpoints Disponíveis

Todos os endpoints estão sob o path base:  
```
/api/funcionarios
```

### 1. Criar Funcionário
- **Método**: `POST`
- **Endpoint**: `/api/funcionarios`
- **Descrição**: Cadastra um novo funcionário no sistema.
- **Corpo (JSON)**:
  ```json
  {
    "nome": "Nome do Funcionário",
    "dataNascimento": "2000-10-18",
    "salario": 2009.44,
    "funcao": "Operador"
  }
  ```
  
### 2. Listar Todos os Funcionários
- **Método**: `GET`
- **Endpoint**: `/api/funcionarios`
- **Descrição**: Retorna a lista de todos os funcionários cadastrados.

### 3. Excluir Funcionário por ID
- **Método**: `DELETE`
- **Endpoint**: `/api/funcionarios/delete/{id}`
- **Descrição**: Remove um funcionário do banco de dados com base em seu ID.

### 4. Conceder Aumento de Salário (10%)
- **Método**: `PUT`
- **Endpoint**: `/api/funcionarios/aumento`
- **Descrição**: Aplica um aumento de 10% para todos os funcionários cadastrados.

### 5. Agrupar Funcionários por Função
- **Método**: `GET`
- **Endpoint**: `/api/funcionarios/por-funcao`
- **Descrição**: Retorna um mapa em que a chave é a função e o valor é a lista de funcionários que possuem aquela função.

### 6. Listar Funcionários por Mês de Aniversário
- **Método**: `GET`
- **Endpoint**: `/api/funcionarios/aniversariantes`
- **Parâmetros**: `meses` (lista de meses, ex.: `?meses=10,12`)
- **Descrição**: Retorna todos os funcionários que fazem aniversário nos meses informados.

### 7. Funcionário Mais Velho
- **Método**: `GET`
- **Endpoint**: `/api/funcionarios/mais-velho`
- **Descrição**: Retorna o funcionário mais velho (com base na data de nascimento).

### 8. Listar Funcionários em Ordem Alfabética
- **Método**: `GET`
- **Endpoint**: `/api/funcionarios/ordenados-alfabeticamente`
- **Descrição**: Retorna todos os funcionários ordenados alfabeticamente pelo nome.

### 9. Total dos Salários
- **Método**: `GET`
- **Endpoint**: `/api/funcionarios/total-salarios`
- **Descrição**: Retorna a soma de todos os salários dos funcionários.

### 10. Quantos Salários Mínimos Cada Funcionário Recebe
- **Método**: `GET`
- **Endpoint**: `/api/funcionarios/salarios-minimos`
- **Descrição**: Retorna um mapa em que a chave é o nome do funcionário e o valor é a quantidade de salários mínimos (considerando R\$ 1.212,00) que ele recebe.

---
## Documentação
* [Evidência dos testes unitários](https://github.com/DavigSo/gestor-funcionario-spring/blob/master/testesUnitarios/Casos%20de%20teste%20-%20Iniflex%20Gestor%20de%20funcionarios%20.pdf)
---

## Como Executar o Projeto

1. **Pré-requisitos**:
   - Java 17 ou superior instalado
   - Maven instalado

2. **Clonar o repositório**:
   ```bash
   git clone <URL_DO_SEU_REPOSITORIO>
   ```
3. **Acessar a pasta do projeto**:
   ```bash
   cd gestaoFuncionarios
   ```
4. **Compilar e executar**:
   ```bash
   mvn spring-boot:run
   ```
   A aplicação irá iniciar em `http://localhost:8080`.

5. **Testar os endpoints**:
   - Utilize ferramentas como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) para fazer requisições HTTP.
   - Você também pode usar o próprio navegador para endpoints `GET`.

---

## Banco de Dados H2

Por padrão, a aplicação está configurada para usar o banco de dados em memória **H2**. Para acessar a console do H2 (caso esteja habilitada no `application.properties` ou `application.yml`):

- URL: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Usuário**: `sa`
- **Senha**: (em branco, se não estiver definida)

---

## Observações

- A inserção dos funcionários da tabela ocorre automaticamente na inicialização da aplicação, através do método `run` em `GestaoFuncionariosApplication`.
- O código segue o padrão de camadas **Controller**, **Service**, **Repository** e **Entity**.
- O Lombok é utilizado para reduzir o código boilerplate (getters, setters, construtores etc.).
- O projeto foi construído sobre o **Spring Boot 3.4.2**.

---

## Contato

[![Linkedin Badge](https://img.shields.io/badge/Linkedin-323330?style=for-the-badge&logo=linkedin&logoColor=blue)]([https://www.linkedin.com/in/deborahmouras/](https://www.linkedin.com/in/davi-sousa-/)) &nbsp;
[![Gmail Usakimodoki Badge](https://img.shields.io/badge/-Gmail-323330?style=for-the-badge&logo=linkedin&logoColor=blue&link=mailto:contato@deborahmoura.com.br)](mailto:davig4611@gmail.com) &nbsp;

---
