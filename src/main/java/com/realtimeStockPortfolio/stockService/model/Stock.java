package com.realtimeStockPortfolio.stockService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {
    @JsonProperty("price")
    double price;

    public Stock(double price) {
        this.price = price;
    }
}
