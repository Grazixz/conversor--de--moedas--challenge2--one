package br.com.one.model;

import br.com.one.api.ConversionApi;
import br.com.one.functionality.Client;
import br.com.one.api.GsonJson;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Conversion {
    Client client = new Client();
    private final GsonJson gsonJson = new GsonJson();
    private String timeLastUpdate;
    private String timeNextUpdate;
    private Currency convert;
    private Currency convertTo;
    private double conversionRate;
    private double conversionResult;
    private String registerConvert;
    private final List<Conversion> conversions = new ArrayList<>();

    public Conversion() {
    }

    public Conversion(ConversionApi conversionApi) {
        translateDate(conversionApi);
        this.convert = conversionApi.base_code();
        this.convertTo = conversionApi.target_code();
        this.conversionRate = conversionApi.conversion_rate();
        this.conversionResult = conversionApi.conversion_result();
    }

    @Override
    public String toString() {
        return "\n| Registro da conversão: " + registerConvert +
               "\n| Última atualização da moeda: " + timeLastUpdate +
               "\n| Próxima atualização da moeda: " + timeNextUpdate +
               "\n| Converter: " + convert.getDisplayName() +
               "\n| Converter para: " + convertTo.getDisplayName() +
               "\n| Valor da moeda: " + convert.getSymbol() + conversionRate +
               "\n| Resultado da Conversão: " + convertTo.getSymbol() + conversionResult +
               "\n---------------------------------------------------------\n";
    }

    public void conversionPair(String convert, String convertTo) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o valor para converter:");
            double value = scanner.nextDouble();
            client.getExchangerateApi().updateAddress(Currency.getInstance(convert.toUpperCase()) + "/" + Currency.getInstance(convertTo.toUpperCase()) + "/" + value);
            client.updateHttp();

            if (client.getResponse().statusCode() == 400){
                System.out.println("Erro na consulta!");
            } else {
                if (value <= 0){
                    System.out.println("Valor Inválido!");
                } else {
                    gsonJson.serializeGson(client, conversions);
                }
            }
        } catch (IllegalArgumentException e){
            System.out.println("Tipo de moeda inválido!");
        } catch (InputMismatchException e){
            System.out.println("Valor inválido!");
        }
    }

    public void historyConversion(){
        System.out.println("Histórico de Conversões: \n" + conversions);
    }

    public void translateDate(ConversionApi conversionApi){
        DateTimeFormatter formatterRFC = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy HH:mm:ss");
        registerConvert = ZonedDateTime.now().format(formatterBR);
        ZonedDateTime date = ZonedDateTime.parse(conversionApi.time_last_update_utc(), formatterRFC);
        timeLastUpdate = date.format(formatterBR);
        date = ZonedDateTime.parse(conversionApi.time_next_update_utc(), formatterRFC);
        timeNextUpdate = date.format(formatterBR);
    }
}
