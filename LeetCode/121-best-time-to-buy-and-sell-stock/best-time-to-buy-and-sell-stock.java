class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minp = (int)1e5;
        int maxp = 0;
        int ans = 0;

        for(int i=0;i<n;i++){
            if(prices[i] < minp){
                minp = prices[i];
                maxp = minp;
            }
            else maxp = Math.max(maxp, prices[i]);
            ans = Math.max(ans, maxp - minp);
        }

        return ans;
    }
}