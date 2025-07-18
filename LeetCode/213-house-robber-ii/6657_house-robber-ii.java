class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        return Math.max(calcLeft(nums), calcRight(nums));
    }

    int calcLeft(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(n>1)
            dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-2];
    }


    int calcRight(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        if(n>1)
            dp[n-2] = Math.max(nums[n-1], nums[n-2]);
        for(int i=n-3;i>=0;i--){
            dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }
        return dp[1];
    }
}