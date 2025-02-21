class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int len = nums.length;
        int minL = Integer.MAX_VALUE;

        for(;r<len;r++){
            sum += nums[r];
            while(sum >= target){
                minL = Math.min(r-l+1, minL);
                sum -= nums[l];
                l++;
            }
        }

        return (minL == Integer.MAX_VALUE ? 0 : minL);
    }
}