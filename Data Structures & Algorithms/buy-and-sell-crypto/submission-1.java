class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            mn = Math.min(mn, prices[i]);
            int v = prices[i] - mn;
            result = Math.max(result, v);
        }
        return result;
    }
}
