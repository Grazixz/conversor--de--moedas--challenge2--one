package br.com.one.api;

import java.util.Currency;

public record ConversionApi(String time_last_update_utc, String time_next_update_utc, Currency base_code,
                            Currency target_code, double conversion_rate, double conversion_result) {

}
