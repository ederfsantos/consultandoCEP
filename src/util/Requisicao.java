package util;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requisicao {

    public String getRequisicao(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println("Dados da resposta da requisição\n" + json);
            return json;

        } catch (Exception e) {
            System.out.println("Erro ao tentar consultar o cep: " + e.getMessage());
            return null;
        }

    }
}