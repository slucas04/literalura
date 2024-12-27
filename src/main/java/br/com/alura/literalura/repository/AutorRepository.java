package br.com.alura.literalura.repository;

import br.com.alura.literalura.modelos.Autor;
import br.com.alura.literalura.modelos.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.nome ILIKE %:nome%")
    Optional<List<Autor>> achaPorNome(String nome);

    @Query("SELECT a FROM Autor a WHERE a.anoNascimento < :ano AND a.anoMorte > :ano")
    List<Autor> listarAutorPorAno(Number ano);
}
