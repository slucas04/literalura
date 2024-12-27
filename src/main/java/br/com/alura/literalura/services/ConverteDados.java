package br.com.alura.literalura.services;

import br.com.alura.literalura.modelos.DadosLivros;
import br.com.alura.literalura.modelos.RespostaLivros;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverteDados implements IConverteDados {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            // Deserializa o JSON para o objeto RespostaLivros
            RespostaLivros resposta = mapper.readValue(json, RespostaLivros.class);

            // Verifica se há resultados e retorna o primeiro livro, caso exista
            List<DadosLivros> livros = resposta.resultados();
            return livros.isEmpty() ? null : (T) livros.get(0);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
