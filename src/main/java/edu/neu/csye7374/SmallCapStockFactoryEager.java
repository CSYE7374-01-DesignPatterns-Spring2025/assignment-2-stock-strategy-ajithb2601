package edu.neu.csye7374;

public class SmallCapStockFactoryEager implements AbstractStockFactory {

    private static final SmallCapStockFactoryEager instance = new SmallCapStockFactoryEager();

    private SmallCapStockFactoryEager() {
    }

    public static AbstractStockFactory getInstance() {
        return instance;
    }


    @Override
    public StockAPI getObject(String name, double price, String description) {
        return new SmallCapStock(name,price,description);
    }
}
