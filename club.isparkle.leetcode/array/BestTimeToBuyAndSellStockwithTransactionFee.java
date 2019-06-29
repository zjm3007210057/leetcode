package array;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * <p>
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i;
 * and a non-negative integer fee representing a transaction fee.
 * <p>
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 * <p>
 * Return the maximum profit you can make.
 * <p>
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Note:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000
 * <p>
 * Created by zjm on 2019/6/29 09:56
 */
public class BestTimeToBuyAndSellStockwithTransactionFee {

    //use dps, definition two arrays hold[n] and sold[n], hold[i] is the maximum profit you can make when you keep i-th prices and
    //sold[i] is the maximum profit you can make when you sell i-th prices, respectively
    //the transfer formulas are :
    // hold[i] = Math.max(hold[i-1], sold[i-1] - prices[i]);
    // sold[i] = Math.max(sold[i-1], hold[i-1] + prices[i] - fee);
    public int maxProfit(int[] prices, int fee) {
        int[] hold = new int[prices.length];
        int[] sold = new int[prices.length];
        hold[0] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i-1], sold[i-1] - prices[i]);
            sold[i] = Math.max(sold[i-1], hold[i-1] + prices[i] - fee);
        }
        return Math.max(hold[prices.length-1], sold[prices.length-1]);
    }

    //use dps. use two variables hold and sold replace two arrays hold[n] and sold[n] since sold[i] is only related with sold[i-1],
    //also hold[i] is only related with hold[i-1] too.
    public int maxProfitBetter(int[] prices, int fee) {
        int hold = -prices[0], sold = 0, tmp;
        for(int i = 1; i < prices.length; i++) {
            tmp = hold;
            hold = Math.max(hold, sold - prices[i]);
            sold = Math.max(sold, tmp + prices[i] - fee);
        }
        return Math.max(sold, hold);
    }

    public int maxProfit2(int[] prices, int fee) {
        int profit = 0;
        int curProfit = 0;
        int minP = prices[0];
        int maxP = prices[0];
        for(int i = 1; i < prices.length; i++) {
            minP = Math.min(minP, prices[i]);
            maxP = Math.max(maxP, prices[i]);
            curProfit = Math.max(curProfit, prices[i] - minP - fee);
            if((maxP - prices[i]) >= fee) {//can just sell the stock at maxP day.
                profit += curProfit;
                curProfit = 0;
                minP = prices[i];
                maxP = prices[i];
            }
        }
        return profit + curProfit;//the last trade have to be made if there is some profit
    }

}
