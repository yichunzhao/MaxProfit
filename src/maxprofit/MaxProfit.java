/*
 * Finding out the max profit trade. 
 * 
 * 
 */
package maxprofit;

import java.util.TreeSet;
import java.util.SortedSet;

/**
 *
 * @author YNZ
 */
public class MaxProfit {

    private static double[] prices = {1, 10, 3, 6, 4, 0.5, 8};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trade trade = mostProfitableTrade(prices);
        System.out.println(trade.toString());

    }

    public static Trade mostProfitableTrade(double[] prices) {

        SortedSet<Trade> bestTrades = new TreeSet<>();

        //buying may in following prices excluding the last price; 
        //for it cannot be sold in a price. 
        for (int b = 0; b < prices.length-1; b++) {
            double maxProfit = 0;

            //best trade for current buy
            Trade trade = new Trade();

            //selling it in a bigger prices after the buying index. 
            for (int s = b + 1; s < prices.length; s++) {
                if (prices[b] > prices[s]) {
                    continue;
                }

                Double profit = prices[s] - prices[b];

                if (profit > maxProfit) {
                    maxProfit = profit;
                    trade.setBuyIndex(b);
                    trade.setSellIndex(s);
                    trade.setProfit(maxProfit);
                }
            }

            if (trade.getProfit() != null) {
                bestTrades.add(trade);
            }
        }
        
        return bestTrades.last();
    }
}

class Trade implements Comparable<Trade> {

    public Trade() {
    }

    @Override
    public String toString() {
        return "(sIx: " + this.sellIndex + " bIx: " + this.buyIndex + ") P = " + profit;
    }

    @Override
    public int compareTo(Trade o) {
        return this.profit.compareTo(o.getProfit());
    }

    public void setBuyIndex(int buyIndex) {
        this.buyIndex = buyIndex;
    }

    public void setSellIndex(int sellIndex) {
        this.sellIndex = sellIndex;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public int getBuyIndex() {
        return buyIndex;
    }

    public int getSellIndex() {
        return sellIndex;
    }

    public Double getProfit() {
        return profit;
    }

    private int buyIndex;
    private int sellIndex;
    private Double profit;

}
