package challenge.api.moedas;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record taxasDeConversao(@SerializedName("conversion_rates") Map<String, Double> conversionRates) {
}