package br.com.alura.literalura.principal;

import br.com.alura.literalura.modelos.Autor;
import br.com.alura.literalura.modelos.DadosLivros;
import br.com.alura.literalura.modelos.Livro;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.services.ConsumoApi;
import br.com.alura.literalura.services.ConverteDados;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private String opcao = "-1";
    Scanner leitura = new Scanner(System.in);
    LivroRepository livroRepository;
    AutorRepository autorRepository;
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void principal() {
        while (!(opcao.equals("0"))){
            System.out.println("******** LiterAlura ********");
            System.out.println(" ");
            System.out.println("1 - Buscar livro pelo título");
            System.out.println("2 - Listrar livros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos em um determinado ano");
            System.out.println("5 - Listar livros em um determinado idioma");
            System.out.println("6 - Listar TOP 5 livros mais baixados");
            System.out.println("0 - Sair");
            System.out.println(" ");
            System.out.println("Selecione uma das opções acima: ");
            opcao = leitura.nextLine();

            switch (opcao) {
                case "1":
                    buscarLivroPorTitulo();
                    break;
                case "2":
                    listarLivros();
                    break;
                case "3":
                    listarAutores();
                    break;
                case "4":
                    listarAutoresVivosPorAno();
                    break;
                case "5":
                    listarLivrosPorIdioma();
                    break;
                case "6":
                    top5MaisBaixados();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void buscarLivroPorTitulo() {
        DadosLivros dadosLivros = getDadosLivros();

        if (dadosLivros != null) {
            Optional<List<Livro>> livroExistente = livroRepository.achaPorTitulo(dadosLivros.titulo());
            if (!(livroExistente.get().isEmpty())) {
                imprimeLivro(livroExistente.get().get(0));
            } else {
                var livro = new Livro(dadosLivros, autorRepository, livroRepository, conversor);
                livroRepository.save(livro);
                imprimeLivro(livro);
            }
        }else {
            System.out.println("O livro não está disponível para busca pela API!");
        }

    }


    private DadosLivros getDadosLivros() {
        System.out.println("Digite o nome do livro a ser buscada:");
        var nomeLivro = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "+"));
        var dados = conversor.obterDados(json, DadosLivros.class);
        return dados;
    }

    private void listarLivros() {
        livroRepository.findAll().forEach(this::imprimeLivro);
    }

    private void listarAutores() {
        autorRepository.findAll().forEach(this::imprimeAutor);
    }

    private void listarAutoresVivosPorAno() {
        System.out.println("Insira um ano:");
        Number ano = leitura.nextInt();
        leitura.nextLine();
        if (autorRepository.listarAutorPorAno(ano).isEmpty()){
            System.out.println("Não há autores cadastrados vivos no ano de " + ano + "!");
        }else {
            System.out.println("Autores vivos em " + ano + ":");
            autorRepository.listarAutorPorAno(ano).forEach(this::imprimeAutor);
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("1 - Espanhol");
        System.out.println("2 - Inglês");
        System.out.println("3 - Português");
        System.out.println("4 - Francês");
        System.out.println("Selecione uma das opções acima: ");
        int idioma = leitura.nextInt();
        leitura.nextLine();
        if (idioma == 1 && !(livroRepository.listaLivroPorIdioma("es").isEmpty())){livroRepository.listaLivroPorIdioma("es").forEach(this::imprimeLivro);}
        if(idioma == 1 && livroRepository.listaLivroPorIdioma("es").isEmpty()){System.out.println("Nenhum livro em espanhol disponível!");}

        if (idioma == 2 && !(livroRepository.listaLivroPorIdioma("en").isEmpty())){livroRepository.listaLivroPorIdioma("en").forEach(this::imprimeLivro);}
        if(idioma == 2 && livroRepository.listaLivroPorIdioma("en").isEmpty()){System.out.println("Nenhum livro em inglês disponível!");}

        if (idioma == 3 && !(livroRepository.listaLivroPorIdioma("pt").isEmpty())){livroRepository.listaLivroPorIdioma("pt").forEach(this::imprimeLivro);}
        if(idioma == 3 && livroRepository.listaLivroPorIdioma("pt").isEmpty()){System.out.println("Nenhum livro em português disponível!");}

        if (idioma == 4 && !(livroRepository.listaLivroPorIdioma("fr").isEmpty())){livroRepository.listaLivroPorIdioma("fr").forEach(this::imprimeLivro);}
        if(idioma == 4 && livroRepository.listaLivroPorIdioma("fr").isEmpty()){System.out.println("Nenhum livro em francês disponível!");}

        if(idioma != 1 && idioma != 2 && idioma != 3 && idioma != 4){System.out.println("Opção inválida!");}
    }

    private void top5MaisBaixados() {
        for (int i = 1; i <= livroRepository.top5Livros().size() ; i++) {
            System.out.println("Número " + i + " em downloads:");
            imprimeLivro(livroRepository.top5Livros().get(i-1));
        }
    }

    public void imprimeLivro(Livro l) {
        System.out.println("----- LIVRO -----");
        System.out.println("Título: " + l.getTitulo());
        System.out.println("Autor: " + l.getAutor().getNome());
        System.out.println("Idioma: " + l.getIdioma());
        System.out.println("Número de downloads: " + l.getNumeroDownloads());
        System.out.println("-----------------");
        System.out.println(" ");
    }

    public void imprimeAutor(Autor a){
        System.out.println("----- AUTOR -----");
        System.out.println("Nome: " + a.getNome());
        System.out.println("Em vida entre: " + a.getAnoNascimento() + " - " + a.getAnoMorte());
        System.out.println("Livros: " + a.getLivros());
        System.out.println("-----------------");
        System.out.println(" ");
    }
}
