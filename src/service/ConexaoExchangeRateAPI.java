package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.MoedaDTO;
import exceptions.MoedaNaoEncontradaException;
import models.Moeda;

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
        String requisicao = getConexao() + getApiKey() + "/latest/" + moeda.getNome();
        new ConexaoExchangeRateAPI(requisicao);

    }


    public void conversaoDeMoedas(Moeda m1, Moeda m2, Double quantidade) {
        String requisicao = getConexao() + getApiKey() + "/pair/"
                + m1.getNome() + "/"
                + m2.getNome() + "/"
                + quantidade;
        new ConexaoExchangeRateAPI(requisicao);
    }

    public void conversaoDeMoedas(Moeda m1, Moeda m2) {
        String requisicao = getConexao() + getApiKey() + "/pair/"
                + m1.getNome() + "/"
                + m2.getNome();
        new ConexaoExchangeRateAPI(requisicao);
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
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            MoedaDTO moedaDTO =gson.fromJson(json, MoedaDTO.class);

            if (json.contains("error-type")) {
                throw new MoedaNaoEncontradaException();
            } else {
                if (moedaDTO.equals("null")){ // Cuidar desse tratamente...
                    System.out.println(moedaDTO.opcaoTres());
                } else {
                    System.out.println(moedaDTO.opcaoDois());
                }
            }

        } catch (MoedaNaoEncontradaException | IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
