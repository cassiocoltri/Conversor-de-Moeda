package service;

import exceptions.MoedaNaoEncontradaException;
import model.Moeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoExchangeRateAPI {

    final String apiKey = "2142276e6e85e4b9de64d30f";
    String conexao = "https://v6.exchangerate-api.com/v6/";

    Moeda moeda;

    public String getConexao() {
        return conexao;
    }

    public String getApiKey() {
        return apiKey;
    }

    public ConexaoExchangeRateAPI(){
    }

    public void pegarCotacao(Moeda moeda) {
        String cotacaoSimples = getConexao() + getApiKey() + "/latest/" + moeda.getNome();
        new ConexaoExchangeRateAPI(cotacaoSimples);

    }

    public ConexaoExchangeRateAPI(String conexao) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(conexao))
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            if (json.contains("error-type")) {
                throw new MoedaNaoEncontradaException();
            } else {
                System.out.println(json);
            }

        } catch (MoedaNaoEncontradaException | IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
