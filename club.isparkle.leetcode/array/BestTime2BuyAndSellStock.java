package array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Created by zjm on 2019/5/14.
 */
public class BestTime2BuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(null == prices || prices.length < 2) {
            return 0;
        }
        int buyPrice = prices[0];
        int sellPrice = prices[1];
        int profit = sellPrice - buyPrice;
        for(int i = 2; i < prices.length; i++) {
            buyPrice = getMin(buyPrice, prices[i - 1]);
            profit = getMax(profit, (prices[i] - buyPrice));
        }
        //in case prices is sorted in decreasing order
        if(profit < 0) {
            return 0;
        }
        return profit;
    }

    public int getMax(int a, int b) {
        if(a > b) {
            return a;
        }
        return b;
    }

    public int getMin(int a, int b) {
        if(a > b) {
            return b;
        }
        return a;
    }
}
