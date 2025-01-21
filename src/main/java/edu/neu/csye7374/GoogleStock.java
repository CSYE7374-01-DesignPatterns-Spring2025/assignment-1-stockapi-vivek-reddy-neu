package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class GoogleStock extends Stock {
    private List<Double> bids = new ArrayList<>();
    private double bidInfluenceFactor;

    public GoogleStock() {
        this.setName("GOOGLE");
        this.setDescription("Google LLC Common Stock");
        this.setPrice(2000.00);
        this.bidInfluenceFactor = 0.13;
    }

    @Override
    public void setBid(String bid) {
        if (bid == null || bid.isEmpty()) {
            System.out.println("Invalid bid, no update made.");
            return;
        }

        double currentBid = Double.parseDouble(bid);
        bids.add(currentBid);

        double currentPrice = this.getPrice();
        double newPrice = currentPrice + (currentBid - currentPrice) * bidInfluenceFactor;
        this.setPrice(newPrice);

    }

    @Override
    public int getMetric() {
        if (bids.isEmpty()) {
            return 0;
        }
        double price = getPrice();
        double currentMetric = ((bids.get(bids.size() - 1) - price) / price) * 100;
        
        if (currentMetric < -10) {
        	return -1;
        } else if (currentMetric >= -10 && currentMetric < 10 ) {
        	return 0;
        } else {
        	return 1;
        }
        		
    }
}
