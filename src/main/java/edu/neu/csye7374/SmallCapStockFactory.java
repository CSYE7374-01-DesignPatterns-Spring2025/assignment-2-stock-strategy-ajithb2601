package edu.neu.csye7374;

public class SmallCapStockFactory implements  AbstractStockFactory {

    @Override
    public StockAPI getObject(String name, double price, String description) {
        return new SmallCapStock(name,price,description);
    }
}
