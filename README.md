# MovieHub API

## Visão Geral

**MovieHub API** é uma API RESTful segura e escalável para gerenciamento de catálogo de filmes e avaliações. Seu objetivo é servir como backend para plataformas externas (por exemplo, um frontend no estilo IMDb), fornecendo informações detalhadas, sistema de votação e controle de usuários.

O projeto foi concebido com foco em **boas práticas de engenharia de software**, **segurança**, **escalabilidade** e **testabilidade desde o início**.

---

## Objetivo do Produto

Disponibilizar uma API própria de filmes que permita:

* Exibição de catálogo de filmes
* Avaliações por usuários autenticados
* Cálculo automático de média e total de votos
* Consumo seguro por sistemas externos

---

## Público-Alvo

* **Usuários finais**: avaliam filmes
* **Administradores de conteúdo**: cadastram e mantêm dados
* **Sistemas externos**: frontends próprios e possíveis parceiros

---

## Princípios do Produto (Product Owner Mindset)

* **Segurança em primeiro lugar** (JWT, rotas protegidas, roles)
* **Escalabilidade** (reviews, rankings e recomendações futuras)
* **Separação clara de responsabilidades**
* **Testável desde o início**
* **API REST bem definida e documentada**

---

## Escopo Funcional

### Usuários

#### Tipos de Usuário

* `ADMIN`
* `USUARIO`

#### Regras de Negócio

* Apenas **ADMIN** pode cadastrar novos usuários
* Usuário pode editar apenas seus próprios dados
* **ADMIN** pode cadastrar, editar e excluir qualquer usuário

#### Operações

* Cadastro
* Edição
* Exclusão
* Autenticação via JWT

---

### Filmes

#### Cadastro

* Apenas **ADMIN**

**Informações do Filme:**

* Nome
* Diretor
* Gênero
* Atores
* Ano
* Descrição

#### Listagem

* Acesso público (com autenticação)
* Filtros combináveis:

  * Nome
  * Diretor
  * Gênero
  * Atores

#### Votação

* Apenas usuários autenticados
* Cada usuário pode votar **uma única vez por filme**
* Nota: `0 a 4`
* A API calcula automaticamente:

  * Média de votos
  * Total de votos

---

### Segurança

* Autenticação via **JWT**
* Autorização baseada em **roles**
* Rotas restritas:

  * `/admin/**` → `ADMIN`
  * `/user/**` → `USUARIO`
* Arquitetura **stateless**, ideal para consumo externo

---

## Arquitetura Backend

### Stack Tecnológica

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT
* Maven
* Banco Relacional

  * H2 (desenvolvimento)
  * MySQL / PostgreSQL (produção futura)

### Arquitetura em Camadas

* `controller`
* `service`
* `repository`
* `domain / entity`
* `dto`
* `security`
* `exception`

---

## Modelo de Domínio (Alto Nível)

### Usuário (`User`)

* `id`
* `nome`
* `email`
* `senha`
* `role` (`ADMIN | USUARIO`)

### Filme (`Movie`)

* `id`
* `nome`
* `diretor`
* `genero`
* `atores`
* `ano`
* `descricao`

### Voto (`Vote`)

* `id`
* `nota` (0–4)
* `user_id`
* `movie_id`

 **Regra crítica:**
A combinação `(user_id, movie_id)` deve ser **única**, impedindo votos duplicados.

---

## Roadmap do Produto (Backend)

### 🔹 Fase 1 — Fundação

* Criar projeto Spring Boot
* Configurar banco de dados
* Criar entidades básicas
* Estrutura inicial de pacotes

### 🔹 Fase 2 — Segurança

* Implementar autenticação JWT
* Criar roles e regras de acesso
* Criar usuário ADMIN inicial

### 🔹 Fase 3 — Usuários

* Cadastro de usuários (ADMIN)
* Edição e exclusão
* Proteção de rotas

### 🔹 Fase 4 — Filmes

* Cadastro de filmes (ADMIN)
* Listagem com filtros
* Detalhes do filme

### 🔹 Fase 5 — Votação

* Votar em filmes
* Calcular média de votos
* Evitar voto duplicado

### 🔹 Fase 6 — Qualidade

* Tratamento global de exceções
* Testes unitários
* Documentação com Swagger/OpenAPI

---

## MVP — Produto Mínimo Viável

Funcionalidades da primeira entrega:

* Login com JWT
* ADMIN cadastra filmes
* Usuário lista filmes
* Usuário vota em filmes
* API retorna média de votos

### Com o MVP é possível:

* Consumir a API via frontend estilo IMDb
* Validar regras reais de negócio
* Evoluir o produto de forma incremental

---

## Licença

Projeto desenvolvido para fins de portfólio.
