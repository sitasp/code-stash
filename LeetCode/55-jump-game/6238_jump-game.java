class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;
        for(int i=0;i<=Math.min(n-1, maxReach);i++){
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= (n-1);
    }
}