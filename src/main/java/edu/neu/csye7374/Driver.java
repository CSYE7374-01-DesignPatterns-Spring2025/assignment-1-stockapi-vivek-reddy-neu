package edu.neu.csye7374;

/**
 * 
 * @author Yesha
 * 
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("============Main Execution Start===================\n\n");

         //Add your code in between these two print statements
		
		String[] bids1 = {"5750.00", "3345.50", "4402.00", "1228.00", "1005.00", "7542.00"};
        System.out.println("\\n============Amazon Stock===================\n\n");
        Stock amazon = new AmazonStock();

        for (String bid : bids1) {
        	amazon.setBid(bid);
        	System.out.println("New Price: " + String.format("%.2f", amazon.getPrice())  + ", New Metric: " + amazon.getMetric() + "\n");
        }
        System.out.println("============End of Amazon Stock===================\n");

        String[] bids2 = {"1710.70", "1975.50", "2234.00", "2012.30", "1732.00", "1984.42"};
        System.out.println("\\n============Google Stock===================\n\n");
        Stock google = new GoogleStock();

        for (String bid : bids2) {
        	google.setBid(bid);
        	System.out.println("New Price: " + String.format("%.2f", google.getPrice()) + ", New Metric: " + google.getMetric() + "\n");
        }
        System.out.println("============End of Google Stock===================\n");

        
		System.out.println("\n\n============Main Execution End===================");
	}

}
