package aws.onlineassesment;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class MaxProfitStock_LC121 {

    public static void main(String[] args) {
    }

    //O(n) time - ideal solution
    public int maxProfit_(int[] prices) {
        // Go through the entire array.
        // If the current price of a stock is less than our previous purchase, we buy the stock
        // Otherwise, we sell the stock at the current price
        // We take note if there was a larger profit.

        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minVal) {
                minVal = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minVal);
            }
        }
        return maxProfit;
    }

    //Brute force, quadratics
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int temp;

        if(prices.length == 0) {
            return maxProfit;
        }

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                temp = prices[j] - prices[i];
                if (temp > maxProfit) {
                    maxProfit = temp;
                }
            }
        }
        return maxProfit;
    }
}
