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

O projeto **Literalura** é uma aplicação Java desenvolvida com o framework Spring Boot, com o objetivo de consumir dados de uma API externa para gerenciar informações sobre livros e autores. A aplicação utiliza uma estrutura modular que inclui comunicação com APIs, conversão de dados JSON para objetos e persistência no banco de dados relacional PostgreSQL.

## ✨ Funcionalidades

- Comunicação com a API [Gutendex](https://gutendex.com) para obter informações sobre livros e autores.

  <div align="center">
    <a href="https://gutendex.com" target="_blank">
      <img width="320" alt="gutendex" src="https://github.com/user-attachments/assets/0ea02d8e-7bee-4b98-85c3-75817bf963ce" />
    </a>
  </div>

- Conversão de dados JSON para objetos Java (deserialização).

  <div align="center">
    <img width="250" alt="livro" src="https://github.com/user-attachments/assets/ff3ee7fe-3e98-4051-87f0-1083d92e2cf5" />
    <img width="265" alt="autor" src="https://github.com/user-attachments/assets/f070a85f-d724-49ce-8e57-e7d506082fb8" />
  </div>

- Armazenamento de informações de autores e livros no banco de dados.

  <div align="center">
    <img width="555" alt="db" src="https://github.com/user-attachments/assets/a283e660-70f7-4773-969f-09490fe004ae" />

  </div>

- Execução via terminal para interagir com o sistema.

  <div align="center">
    <img width="455" alt="menuliteralura" src="https://github.com/user-attachments/assets/07efc3ca-0478-492e-b1fa-d5d3dc3beeee" />

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
