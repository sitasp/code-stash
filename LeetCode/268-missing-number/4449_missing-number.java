class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            sum += nums[i];
        }
        int totalSum = len * (len + 1)/2;
        return totalSum - sum;
    }
}