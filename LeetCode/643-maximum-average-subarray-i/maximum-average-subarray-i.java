class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double sumK = 0;
        double maxAvg = 0;
        for(int i=0;i<k;i++){
            sumK += nums[i];
        }
        maxAvg = sumK/k;
        for(int i=k;i<len;i++){
            sumK += nums[i];
            sumK -= nums[i-k];
            maxAvg = Math.max(sumK/k, maxAvg);
        }
        return maxAvg;
    }
}