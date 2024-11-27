package com.realtimeStockPortfolio.stockService.service;

import com.realtimeStockPortfolio.stockService.model.FinnhubStockResponse;
import com.realtimeStockPortfolio.stockService.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class StockService {
    @Autowired
    RestTemplate restTemplate;
    private static final String FINNHUB_API_URL = "https://finnhub.io/api/v1/quote";
    private static final String API_KEY = "your_api_key_here"; // Replace with your actual API key

    public Stock getStock(String symbol) throws IOException {
        String url = String.format("%s?symbol=%s&token=%s", FINNHUB_API_URL, symbol, API_KEY);

        try {
            FinnhubStockResponse finnhubStockResponse = restTemplate.getForObject(url, FinnhubStockResponse.class);
            Stock stock = new Stock(finnhubStockResponse.getClose());

            return stock;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch stock data", e);
        }
    }

}
