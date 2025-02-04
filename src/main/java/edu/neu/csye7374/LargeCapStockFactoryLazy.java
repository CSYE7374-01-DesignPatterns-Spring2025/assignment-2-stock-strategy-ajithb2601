package edu.neu.csye7374;

public class LargeCapStockFactoryLazy implements AbstractStockFactory{
    private static LargeCapStockFactoryLazy instance;

    private LargeCapStockFactoryLazy(){

    }

    public static synchronized LargeCapStockFactoryLazy getInstance() {
        if (instance == null) {
            instance = new LargeCapStockFactoryLazy();
        }
        return instance;
    }

    @Override
    public StockAPI getObject(String name, double price, String description) {
        return new LargeCapStock(name,price,description);
    }
}
