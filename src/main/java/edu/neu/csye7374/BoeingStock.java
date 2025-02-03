package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoeingStock extends Stock{
    private List<Double> bids = new ArrayList<>();
    private double revivalOptimismIndex;
    private double recentAccidentIndex;
    private double lowestBid = 0.0;
    
    public BoeingStock() {
        this.setName("BOEING");
        this.setDescription("AEROSPACE");
        this.setPrice(1900.00);
        this.revivalOptimismIndex = 4.2;
        this.recentAccidentIndex = 1.4;
        
    }

    @Override
    public int getMetric() {
        if (bids.isEmpty()) {
            return 0;
        }
        int newMetric = (int) (revivalOptimismIndex-(recentAccidentIndex)*1.5)  * 100;
         
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
            lowestBid = Math.max(lowestBid, currentBid);
            
            Collections.sort(bids);

            double medianBid;
            int size = bids.size();

            if (size % 2 == 1) {
            	medianBid = bids.get(size / 2);
            } else {
          
                double lower = bids.get(size / 2 - 1);
                double upper = bids.get(size / 2);
                medianBid = (lower + upper) / 2.0;
            }            
            double currentPrice = this.getPrice();
            revivalOptimismIndex = ((medianBid - currentPrice)/lowestBid)*100;
            double newPrice = currentPrice + (medianBid - currentPrice) * recentAccidentIndex;
            this.setPrice(newPrice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format, please provide a numeric value.");
        }
    }
}