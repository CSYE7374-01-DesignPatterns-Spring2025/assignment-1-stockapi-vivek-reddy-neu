package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class GamestopStock extends Stock{
    private List<Double> bids = new ArrayList<>();
    private double memeFrenzyIndex;
    private double fudIndex;
    private double highestBid = 0.0;
    
    public GamestopStock() {
        this.setName("GAMESTOP");
        this.setDescription("RETAIL");
        this.setPrice(1200.00);
        this.memeFrenzyIndex = 3.1;
        this.fudIndex = 0.92;
        
    }

    @Override
    public int getMetric() {
        if (bids.isEmpty()) {
            return 0;
        }
        int newMetric = (int) (memeFrenzyIndex-(fudIndex-2))  * 100;
         
        return newMetric;
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
            highestBid = Math.max(highestBid, currentBid);
            
            double sum = 0;
            for (double num : bids) {
                sum += num;
            }

            double averageBid = (double) sum / bids.size();
            
            double currentPrice = this.getPrice();
            memeFrenzyIndex = ((highestBid - currentPrice)/averageBid);
            double newPrice = averageBid + (averageBid - currentPrice) * memeFrenzyIndex;
            this.setPrice(newPrice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format, please provide a numeric value.");
        }
    }
}