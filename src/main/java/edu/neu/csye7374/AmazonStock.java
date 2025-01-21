package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class AmazonStock extends Stock{
    private List<Double> bids = new ArrayList<>();
    private double averageBid = 4000;

    public AmazonStock() {
        this.setName("AMAZON");
        this.setDescription("E-commerce");
        this.setPrice(4000);
    }

    @Override
    public int getMetric() {
        if (bids.isEmpty()) {
            return 0;
        }
        double currentMetric = ((averageBid - this.getPrice()) / this.getPrice()) * 100;
        
        if (currentMetric < -10) {
        	return -1;
        } else if (currentMetric >= -10 && currentMetric < 10 ) {
        	return 0;
        } else {
        	return 1;
        }
    }

    @Override
    public void setBid(String bid) {
        if (bid == null || bid.isEmpty()) {
            System.out.println("Invalid bid, no update made.");
            return;
        }

        try {
        	double currentBid = Double.parseDouble(bid);
            bids.add(currentBid);
            averageBid = bids.stream().mapToInt(Double::intValue).average().orElse(4000);

            double currentPrice = this.getPrice();
            double newPrice = currentPrice + (averageBid - currentPrice) * 0.05;
            this.setPrice(newPrice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format, please provide a numeric value.");
        }
    }
}