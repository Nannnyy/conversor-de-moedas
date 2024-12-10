package modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import record.TaxaDeConversao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConsultaTaxaConversao {

    public String consultarApiRetornandoJson(String baseCode, String targetCode, double amount)
            throws IOException, InterruptedException {

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/bc54489af31be6325a7316f7/pair/" + baseCode + "/"
                + targetCode + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        return json;
    }

    public void imprimirResultadoConversao(String baseCode, String targetCode, double amount)
            throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = consultarApiRetornandoJson(baseCode, targetCode, amount);

        TaxaDeConversao taxa = gson.fromJson(json, TaxaDeConversao.class);
        double resultadoConversao = taxa.conversionResult();

        System.out.println("Taxa de conversão: " + taxa.conversionRate());
        System.out.println(
                amount + "[" + baseCode + "]" + " ----> " +
                        resultadoConversao + "[" + targetCode + "]");
    }
}
