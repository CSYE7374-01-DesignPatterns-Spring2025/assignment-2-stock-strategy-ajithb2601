package edu.neu.csye7374;

public abstract class StockAPI implements Tradable {
    private String name;
    private double price;
    private String description;
    protected StockPriceStrategy stockPriceStrategy;

    public StockAPI(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStockPriceStrategy(StockPriceStrategy priceStrategy) {
        this.stockPriceStrategy = priceStrategy;
    }

    public  void setBid(double bid){
        if (stockPriceStrategy == null) {
            throw new IllegalStateException("Market strategy is NOT set!");
        }
        price = stockPriceStrategy.computeNewStockPrice(price, bid);
    }

    public abstract void setBid(String bid);

    @Override
    public abstract String getMetric();

    @Override
    public String toString() {
        return String.format("Stock[name=%s, price=%.2f, description=%s]",
                name, price, description);
    }
}
