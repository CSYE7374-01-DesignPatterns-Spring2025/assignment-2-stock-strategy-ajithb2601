package edu.neu.csye7374;

public interface AbstractStockFactory {
     StockAPI getObject(String name, double price, String description);
}
