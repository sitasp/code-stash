class Solution {
    public int singleNumber(int[] nums) {
        int xorSum = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            xorSum = xorSum ^ nums[i];
        }
        return xorSum;
    }
}