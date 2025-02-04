package edu.neu.csye7374;

public class SmallCapStock extends StockAPI {

    private double lastBid;

    public SmallCapStock(String name, double price, String description) {
        super(name, price, description);
        this.lastBid = price;
    }

    @Override
    public void setBid(String bid)
    {
        double bidValue = Double.parseDouble(bid);
        this.lastBid = bidValue;

        double difference = bidValue - getPrice();
        double adjustmentFactor = 0.5;
        double newPrice = getPrice() + (adjustmentFactor * difference);
        setPrice(newPrice);
    }

    @Override
    public String getMetric()
    {
        double priceChange = getPrice() - lastBid;
        double percentageChange = (priceChange / lastBid) * 100;
        return String.format("%.2f%%", percentageChange);
    }

}
