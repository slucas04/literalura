package br.com.alura.literalura.services;

public interface IConverteDados {
    <T> T obterDados(String Json, Class<T> classe);
}
