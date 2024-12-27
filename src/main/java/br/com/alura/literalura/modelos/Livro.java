package br.com.alura.literalura.modelos;


import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.services.ConverteDados;
import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    @ManyToOne
    private Autor autor;
    private Number numeroDownloads;


    public Livro() {}

    public Livro(DadosLivros dadosLivros, AutorRepository autorRepository, LivroRepository livroRepository, ConverteDados conversor) {
        this.titulo = dadosLivros.titulo();

        this.idioma = dadosLivros.idiomas()[0];
        var autor = dadosLivros.autores()[0];

        Optional<List<Autor>> autorExistente = autorRepository.achaPorNome(autor.getNome());
        if (!(autorExistente.get().isEmpty())) {
            this.autor = autorExistente.get().get(0);
        } else {
            this.autor = autorRepository.save(autor);
        }
        this.autor.addLivro(this);
        this.numeroDownloads = dadosLivros.numeroDownloads();

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Number getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Number numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
