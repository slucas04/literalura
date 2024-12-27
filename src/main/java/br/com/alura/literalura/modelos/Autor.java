package br.com.alura.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("name")
    private String nome;
    @JsonProperty("birth_year")
    private Number anoNascimento;
    @JsonProperty("death_year")
    private Number anoMorte;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Livro> livros = new ArrayList<>();

    public Autor() {}

    public Autor(DadosAutores dadosAutores) {
        this.nome = dadosAutores.nome();
        this.anoNascimento = dadosAutores.anoNascimento();
        this.anoMorte = dadosAutores.anoMorte();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Number getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Number anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Number getAnoMorte() {
        return anoMorte;
    }

    public void setAnoMorte(Number anoMorte) {
        this.anoMorte = anoMorte;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoMorte=" + anoMorte +
                '}';
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }
}
