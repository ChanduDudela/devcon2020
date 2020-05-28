public class MaxProfitStock_LC121 {

    public static void main(String[] args) {
    }

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
