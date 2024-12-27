<div align="center">
  <a href="https://www.oracle.com/br/education/oracle-next-education/">
    <img src="https://img.shields.io/badge/challenge-oracle%20next%20education-blue" alt="Challenge Oracle Next Education">
  </a>
</div>
<div align="center">
    <img src="https://img.shields.io/badge/finished-december-green" alt="Finished in December">
</div>

---

# 📚 Literalura

## 📝 Descrição do projeto

O projeto **Literalura** é uma aplicação Java desenvolvida com o framework Spring Boot, com o objetivo de consumir dados de uma API externa para gerenciar informações sobre livros e autores. A aplicação utiliza uma estrutura modular que inclui comunicação com APIs, conversão de dados JSON para objetos e persistência no banco de dados PostgreSQL.

## ✨ Funcionalidades

- Comunicação com a API [Gutendex](https://gutendex.com) para obter informações sobre livros e autores.

  <div align="center">
    <a href="https://gutendex.com" target="_blank">
      <img width="320" alt="gutendex" src="https://github.com/user-attachments/assets/c70eacd3-182a-4a12-86ad-c9170c90eda9" />
    </a>
  </div>

- Conversão de dados JSON para objetos Java (deserialização).

  <div align="center">
    <img width="250" alt="livro" src="https://github.com/user-attachments/assets/5fb89a0c-bbdd-4953-8974-98bca1c23848" />
    <img width="265" alt="autor" src="https://github.com/user-attachments/assets/5251fe9a-35d9-4674-9a3f-7a13dc5f1b9f" />
  </div>

- Armazenamento de informações de autores e livros no banco de dados.

  <div align="center">
    <img width="555" alt="db" src="https://github.com/user-attachments/assets/408c9b4d-0deb-44b2-bc26-9b3d0257aa4f" />
  </div>

- Execução via terminal para interagir com o sistema.

  <div align="center">
    <img width="455" alt="menuliteralura" src="https://github.com/user-attachments/assets/290c84e0-3dca-45ff-9c88-4dd1150bec6a" />
  </div>


## 🗂️ Estrutura do projeto

### Pacotes principais:

- **`services`**: Contém as classes de serviços responsáveis por consumir APIs e processar os dados.
  - `ConsumoApi`: Realiza chamadas HTTP para APIs externas.
  - `ConverteDados`: Deserializa JSON em objetos Java.
  - `IConverteDados`: Interface para o serviço de conversão de dados.

- **`repository`**: Gerencia a persistência dos dados.
  - `AutorRepository`: Interface para manipulação de dados de autores.
  - `LivroRepository`: Interface para manipulação de dados de livros.

- **`modelos`**: Define as classes modelo usadas para estruturar os dados.
  - `DadosLivros`: Representa as informações de um livro.
  - `RespostaLivros`: Representa a resposta da API com uma lista de livros.

- **`principal`**: Contém a classe principal responsável por interagir com os repositórios e gerenciar o fluxo principal da aplicação.
  - `Principal`: Lógica principal para execução.

### Ponto de entrada:
- **`LiteraluraApplication`**: 🚀 Classe principal que inicializa o Spring Boot e executa a lógica definida na classe `Principal`.

## 🛠️ Tecnologias utilizadas

- **Java 17**: Linguagem principal utilizada.
- **Spring Boot**: Framework para simplificar a criação e execução do projeto.
- **Jackson**: Biblioteca para manipulação de JSON.
- **Spring Data JPA**: Para persistência de dados.
- **PostgreSQL**: Banco de dados relacional em memória para testes e desenvolvimento.
- **Java HTTP Client**: Para realizar requisições HTTP.

## 💻 Desenvolvimento

Projeto desenvolvido como parte da especialização back-end em Java de [Oracle Next Education](https://www.oracle.com/br/education/oracle-next-education/) em parceria com [Alura](https://www.alura.com.br/).
