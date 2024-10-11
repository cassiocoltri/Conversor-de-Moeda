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

    public String getConexao() {
        return conexao;
    }

    public String getApiKey() {
        return apiKey;
    }

    public ConexaoExchangeRateAPI(){
    }

    public void pegarCotacao(Moeda moeda) { // Dando erro aqui <---- Null
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

    public void dolarParaPesoArgentino(Double quantidade) {
        String requisicao = getConexao() + getApiKey()
                + "/pair/usd/ars/"
                + quantidade;
        new ConexaoExchangeRateAPI(requisicao);
    }

    public void pesoArgentinoParaDolar(Double quantidade) {
        String requisicao = getConexao() + getApiKey()
                + "/pair/ars/usd/"
                + quantidade;
        new ConexaoExchangeRateAPI(requisicao);
    }

    public void dolarParaRealBrasileiro(Double quantidade) {
        String requisicao = getConexao() + getApiKey()
                + "/pair/usd/brl/"
                + quantidade;
        new ConexaoExchangeRateAPI(requisicao);
    }

    public void drealBrasileiroParaDolar(Double quantidade) {
        String requisicao = getConexao() + getApiKey()
                + "/pair/brl/usd/"
                + quantidade;
        new ConexaoExchangeRateAPI(requisicao);
    }

    public void dolarParaPesoColombiano(Double quantidade) {
        String requisicao = getConexao() + getApiKey()
                + "/pair/usd/cop/"
                + quantidade;
        new ConexaoExchangeRateAPI(requisicao);
    }

    public void pesoColombianoParaDolar(Double quantidade) {
        String requisicao = getConexao() + getApiKey()
                + "/pair/cop/usd/"
                + quantidade;
        new ConexaoExchangeRateAPI(requisicao);
    }

    public void testaMoeda(String moeda) {
        String requisicao = getConexao() + getApiKey()
                + "/latest/" + moeda;
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
            if (json.contains("{\"result\":\"error\"")) {
                throw new MoedaNaoEncontradaException();

            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            MoedaDTO moedaDTO = gson.fromJson(json, MoedaDTO.class);
            System.out.println(moedaDTO);


                if (moedaDTO.conversion_result() == null) {
                    System.out.println("caiu na opcaoComparaDuasMoedas...");
                    System.out.println(moedaDTO.opcaoComparacaoDuasMoedas());

                } else {
                    System.out.println("Caiu na opcao padrão...");
                    System.out.println(moedaDTO.opcaoPadrao());
                }

        } catch (MoedaNaoEncontradaException | IOException | InterruptedException e) {
            System.out.println(e.getMessage());

        }
    }

}
