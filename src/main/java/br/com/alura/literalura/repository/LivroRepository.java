package br.com.alura.literalura.repository;

import br.com.alura.literalura.modelos.Autor;
import br.com.alura.literalura.modelos.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l WHERE l.idioma ILIKE %:idioma%")
    List<Livro> listaLivroPorIdioma(String idioma);

    @Query("SELECT l FROM Livro l ORDER BY l.numeroDownloads DESC LIMIT 5")
    List<Livro> top5Livros();

    @Query("SELECT l FROM Livro l WHERE l.titulo ILIKE %:titulo%")
    Optional<List<Livro>> achaPorTitulo(String titulo);
}
