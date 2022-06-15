package practice.array.buysellstock;

public class BuySellStockOnce {
    public static int maxProfit(int[] prices) {
        int profit=0;
        int buy=prices[0];

        for(int i=1;i<prices.length;i++){
            buy=Math.min(buy,prices[i]);
            profit=Math.max(prices[i]-buy,profit);

        }

        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
