package com.realtimeStockPortfolio.stockService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinnhubStockResponse {

    @JsonProperty("c")
    double close;

    @JsonProperty("o")
    double open;

    @JsonProperty("h")
    double high;
    
    @JsonProperty("l")
    double low;
}
