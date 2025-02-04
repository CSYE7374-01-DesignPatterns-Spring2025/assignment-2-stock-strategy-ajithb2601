package edu.neu.csye7374;

public class LargeCapStockFactory implements AbstractStockFactory {

    @Override
    public StockAPI getObject(String name, double price, String description) {
        return new LargeCapStock(name, price, description);
    }
}
