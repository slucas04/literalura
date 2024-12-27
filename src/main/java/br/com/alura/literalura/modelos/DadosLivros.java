package br.com.alura.literalura.modelos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivros(@JsonProperty("title") String titulo,
                          @JsonProperty("languages") String[] idiomas,
                          @JsonProperty("authors") Autor[] autores,
                          @JsonProperty("download_count") Number numeroDownloads) {
}
