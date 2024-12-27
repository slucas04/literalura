package br.com.alura.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespostaLivros(@JsonProperty("results") List<DadosLivros> resultados) {}
