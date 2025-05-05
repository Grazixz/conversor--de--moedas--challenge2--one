package br.com.one.api;

public class ExchangerateApi {
    private final KeyApi key = new KeyApi();
    private String address = "https://v6.exchangerate-api.com/v6/" + key.getKey() + "/pair/";

    public String getAddress() {
        return address;
    }

    public void updateAddress(String address) {
        this.address = "https://v6.exchangerate-api.com/v6/" + key.getKey() + "/pair/" + address;
    }
}
