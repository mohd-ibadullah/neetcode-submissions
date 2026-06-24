class Solution {
    public int maxProfit(int[] prices) {
        int result = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            mn = Math.min(mn, prices[i]);
            int v = prices[i] - mn;
            result = Math.max(result, v);
        }
        if (result <= 0) {
            return 0;
        } else {
            return result;
        }
    }
}
