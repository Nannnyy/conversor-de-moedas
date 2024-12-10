package record;

import com.google.gson.annotations.SerializedName;

public record TaxaDeConversao(
        @SerializedName("conversion_result") double conversionResult,
        @SerializedName("conversion_rate") double conversionRate) {

}
