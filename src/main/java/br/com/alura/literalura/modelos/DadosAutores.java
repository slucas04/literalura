package br.com.alura.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutores(@JsonProperty("name") String nome,
                           @JsonProperty("birth_year") Number anoNascimento,
                           @JsonProperty("death_year") Number anoMorte) {
}
