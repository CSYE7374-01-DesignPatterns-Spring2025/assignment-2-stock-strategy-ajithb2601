package edu.neu.csye7374;

public class BearMarketStrategy implements StockPriceStrategy {
    @Override
    public double computeNewStockPrice(double currentPrice, double bid) {
        return currentPrice + (bid - currentPrice) * 0.25;
    }
}
