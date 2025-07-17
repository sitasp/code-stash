class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // dp[i] -> max money i can rob within ith house
        // can we make it only two vars without dp array
        // i.e. space optimization
        int prev2 = nums[0];
        int prev1 = nums[0];
        if(n>1)
            prev1 = Math.max(prev1, nums[1]);
        for(int i=2;i<n;i++){
            int curr = prev1;
            curr = Math.max(curr, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.max(prev2, prev1);
    }
}