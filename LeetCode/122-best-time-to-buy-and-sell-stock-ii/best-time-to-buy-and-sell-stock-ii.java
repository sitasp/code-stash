class Solution {
    public int maxProfit(int[] prices) {
        int maxi = 0;
        int mini = 0;

        int len = prices.length;
        int ans = 0;

        for(int i=1;i<len;i++){
            if(prices[i] > prices[maxi]){
                maxi = i;
            }
            if(prices[i] < prices[mini]){
                mini = i;
                maxi = i;
            }
            if(maxi > mini && prices[maxi] > prices[mini]){
                ans += prices[maxi] - prices[mini];
                maxi = i;
                mini = i;
            }
        }

        return ans;
    }
}