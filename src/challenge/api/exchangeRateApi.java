package challenge.api;

import com.google.gson.Gson;
import challenge.api.moedas.taxasDeConversao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class exchangeRateApi {
    private taxasDeConversao taxasDeConversao;

    public taxasDeConversao getConversionRates() throws IOException, InterruptedException {
        conectaAPI();
        return taxasDeConversao;
    }

    private void conectaAPI() throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/7c7b46fda98d9d5771e7272b/latest/USD";

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String body = httpResponse.body().toLowerCase();

        Gson gson = new Gson();
        taxasDeConversao = gson.fromJson(body, taxasDeConversao.class);
    }
}