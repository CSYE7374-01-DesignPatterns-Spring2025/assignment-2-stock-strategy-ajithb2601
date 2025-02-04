package edu.neu.csye7374;

public interface StockPriceStrategy {
    double computeNewStockPrice(double currentPrice, double bid);
}
