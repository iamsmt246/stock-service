package com.realtimeStockPortfolio.stockService.service;

import com.realtimeStockPortfolio.stockService.model.FinnhubStock;
import com.realtimeStockPortfolio.stockService.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class StockService {
    @Autowired
    RestTemplate restTemplate;
    private static final String FINNHUB_STOCK_QUOTE_API_URL = "https://finnhub.io/api/v1/quote";
    private static final String FINNHUB_STOCK_PROFILE_API_URL = "https://finnhub.io/api/v1/stock/profile2";
    private static final String API_KEY = "your_api_key_here"; // Replace with your actual API key

    public Stock getStock(String symbol) throws IOException {
        Stock stock = new Stock();

        try {
            // calling Finnhub stock quote api for quote related information
            String quoteUrl = String.format("%s?symbol=%s&token=%s", FINNHUB_STOCK_QUOTE_API_URL, symbol, API_KEY);
            FinnhubStock quoteFinnhubStock = restTemplate.getForObject(quoteUrl, FinnhubStock.class);

            if (quoteFinnhubStock != null) {
                stock.setCurrentPrice(quoteFinnhubStock.getCurrentPrice());
                stock.setOpenPrice(quoteFinnhubStock.getOpenPrice());
                stock.setHighPrice(quoteFinnhubStock.getHighPrice());
                stock.setLowPrice(quoteFinnhubStock.getLowPrice());
            }

            // calling Finnhub stock profile api for profile related information
            String profileUrl = String.format("%s?symbol=%s&token=%s", FINNHUB_STOCK_PROFILE_API_URL, symbol, API_KEY);
            FinnhubStock profileFinnhubStock = restTemplate.getForObject(profileUrl, FinnhubStock.class);

            if (profileFinnhubStock != null) {
                stock.setCompanyName(profileFinnhubStock.getCompanyName());
                stock.setExchangeName(profileFinnhubStock.getExchangeName());
                stock.setMarketCap(profileFinnhubStock.getMarketCap());
                stock.setTicker(profileFinnhubStock.getTicker());
            }

            return stock;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch stock data", e);
        }
    }

}
