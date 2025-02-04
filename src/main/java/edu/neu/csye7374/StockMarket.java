package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;
    private List<Tradable> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Tradable stock) {
        stocks.add(stock);
    }

    public void removeStock(Tradable stock) {
        stocks.remove(stock);
    }

    public void showAllStocks() {
        for (Tradable stock : stocks) {
            System.out.println(stock);
        }
    }


    public static void demo() {
        System.out.println("============ Stock Market Demo ============");

        StockMarket market = StockMarket.getInstance();

        AbstractStockFactory regularLargeScaleFactory = new LargeCapStockFactory();
        AbstractStockFactory regularSmallScaleFactory = new SmallCapStockFactory();

        AbstractStockFactory singletonLargeCapFactory = LargeCapStockFactoryLazy.getInstance();
        AbstractStockFactory singletonSmallScaleFactory = SmallCapStockFactoryEager.getInstance();

        StockAPI largeCapStock = singletonLargeCapFactory.getObject("LCS", 175.50, "Large Scale Corporation Stock");
        largeCapStock.setStockPriceStrategy(new BullMarketStrategy());
        StockAPI smallCapStock = singletonSmallScaleFactory.getObject( "SCS", 425.75, "Small Scale Corporation Stock");
        smallCapStock.setStockPriceStrategy(new BearMarketStrategy());

        market.addStock(largeCapStock);
        market.addStock(smallCapStock);

        System.out.println("\nInitial Stock Market State:");
        market.showAllStocks();

        System.out.println("\nTrading Demonstration:");

        System.out.println("\n========== Large Scale Stock ==========");
        System.out.println("Implementing Bull Market Strategy");

        String[] largeScaleBids = {"192.25", "245.80", "312.45", "287.90", "156.75", "298.50"};

        for (String bid : largeScaleBids) {
            System.out.println("\nPlacing bid: " + bid);
            largeCapStock.setBid(Double.parseDouble(bid));
            System.out.println("Updated Large Scale Stock:");
            System.out.println(largeCapStock);
            System.out.println("--------------------------------");
        }

        System.out.println("\n========== Small Scale Stock ==========");
        System.out.println("Implementing Bear Market Strategy");

        String[] smallScaleBids = {"398.75", "256.80", "312.90", "445.25", "289.60", "367.40"};

        for (String bid : smallScaleBids) {
            System.out.println("\nPlacing bid: " + bid);
            smallCapStock.setBid(Double.parseDouble(bid));
            System.out.println("Updated Small Scale Stock:");
            System.out.println(smallCapStock);
            System.out.println("--------------------------------");
        }

        System.out.println("\nFinal Stock Market State:");
        market.showAllStocks();

        System.out.println("\n========== Demo Complete ==========");
    }


}
