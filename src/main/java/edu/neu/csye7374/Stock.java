package edu.neu.csye7374;

public abstract class Stock implements Tradable {
    private String name;
    private double price;
    private String description;
    
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

    @Override
    public String toString() {
        return "\n" + name + " Stock\n" +
                "Current price: $" + price + "\n" +
                "Description: " + description + "\n" +
                "Metric: " + getMetric() + "\n\n";
    }
}
