package com.realtimeStockPortfolio.stockService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinnhubStock {

    @JsonProperty("c")
    double currentPrice;

    @JsonProperty("o")
    double openPrice;

    @JsonProperty("h")
    double highPrice;

    @JsonProperty("l")
    double lowPrice;

    // Fields from the /stock/profile2 endpoint
    @JsonProperty("name")
    private String companyName;

    @JsonProperty("marketCapitalization")
    private double marketCap;

    @JsonProperty("exchange")
    private String exchangeName;

    @JsonProperty("ticker")
    private String ticker;

}
