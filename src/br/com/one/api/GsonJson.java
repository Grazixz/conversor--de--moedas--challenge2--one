package br.com.one.api;

import br.com.one.functionality.Client;
import br.com.one.model.Conversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.List;

public class GsonJson {
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void serializeGson(Client client, List<Conversion> listConversions){
        ConversionApi conversionApi = gson.fromJson(client.getResponse().body(), ConversionApi.class);
        Conversion conversion = new Conversion(conversionApi);
        listConversions.add(conversion);
        System.out.println(conversion);
    }
}
