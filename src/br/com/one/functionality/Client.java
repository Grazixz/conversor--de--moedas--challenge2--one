package br.com.one.functionality;

import br.com.one.api.ExchangerateApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    private final ExchangerateApi exchangerateApi = new ExchangerateApi();
    private final HttpClient client = HttpClient.newHttpClient();
    private HttpResponse<String> response;

    public ExchangerateApi getExchangerateApi() {
        return exchangerateApi;
    }


    public HttpResponse<String> getResponse() {
        return response;
    }

    public void updateHttp() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(exchangerateApi.getAddress()))
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

    }
}
