package service;

import exceptions.MoedaNaoEncontradaException;
import model.Moeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoExchangeRateAPI {

    private final String currency = "brl";
    final String apiKey = "2142276e6e85e4b9de64d30f";

    public ConexaoExchangeRateAPI(Moeda moeda) {

        String addres = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/"+moeda.getNome().toLowerCase();

        try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(addres))
                .build();

        HttpResponse<String> response = null;

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            if (json.contains("{Bad Request}")) {
                throw new MoedaNaoEncontradaException();
            } else {
                System.out.println(json);
            }

        } catch (MoedaNaoEncontradaException | IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}
