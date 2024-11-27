package com.realtimeStockPortfolio.stockService.controller;

import com.realtimeStockPortfolio.stockService.model.Stock;
import com.realtimeStockPortfolio.stockService.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/{symbol}")
    public Stock getStock(@PathVariable String symbol) throws IOException {
        return stockService.getStock(symbol);
    }
}
