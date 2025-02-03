package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockMarket {
    private List<Tradable> stocks;
    private static StockMarket instance = null;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }


    public void addStock(Stock stock) {
        System.out.println("Stock " + stock.getName() + " has been added to the stock market.");
        this.stocks.add(stock);
    }


    public void removeStock(String stockName) {
        Iterator<Tradable> iterator = stocks.iterator();
        while (iterator.hasNext()) {
            Stock stock = (Stock) iterator.next();
            if (stock.getName().equalsIgnoreCase(stockName)) {
                iterator.remove();
                System.out.println("Stock " + stockName + " has been removed from the stock market.");
            }
        }
    }



    
    public void showStock(String name) {
        for (Tradable tradable : stocks) {
            Stock stock = (Stock) tradable;
            if (stock.getName().equalsIgnoreCase(name)) {
                System.out.println(stock);
            }
        }
    }

    
    public void tradeStock(String stockName, String bid) {
        System.out.println("Trading " + stockName + " stock for a bid of $" + bid + ".");
        for (Tradable tradable : stocks) {
            Stock stock = (Stock) tradable;
            if (stock.getName().equalsIgnoreCase(stockName)) {
                stock.setBid(bid);
            }
        }
    }
    

    public static void demo() {
        StockMarket stockMarket = StockMarket.getInstance();
    	
    	Stock gmeStock = new GamestopStock();
    	Stock boeingStock = new BoeingStock();
    	
    	stockMarket.addStock(gmeStock);
    	stockMarket.addStock(boeingStock);
    	
    	String[] bids1 = {"5750.00", "3345.50", "4402.00", "1228.00", "1005.00", "7542.00"};
        System.out.println("============Gamestop Stock===================\n");
        for (String bid : bids1) {
        	stockMarket.tradeStock("GAMESTOP", bid);
        	stockMarket.showStock("GAMESTOP");
        }
        System.out.println("============Gamestop Stock===================\n");
        
    	
       String[] bids2 = {"1710.70", "1975.50", "2234.00", "2012.30", "1732.00", "1984.42"};
      System.out.println("============Boeing Stock===================\n\n");

      for (String bid : bids2) {
    	  stockMarket.tradeStock("BOEING", bid);
  		  stockMarket.showStock("BOEING");
      }
      System.out.println("============Boeing Stock===================\n");

    }
}
