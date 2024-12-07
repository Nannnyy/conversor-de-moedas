import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConsultaTaxaConversao {
    
    public static void main(String[] args) throws IOException, InterruptedException {

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/bc54489af31be6325a7316f7/pair/EUR/GBP");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
    
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        
        String json = response.body();

        TaxaDeConversao taxa = gson.fromJson(json, TaxaDeConversao.class);
        System.out.println(taxa);

    }

}
