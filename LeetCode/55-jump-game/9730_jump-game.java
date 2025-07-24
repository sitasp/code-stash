class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;
        // condition is on i<=min(maxReach, n-1) 
        // bcz we need to only track reachable indices, not all indices
        for(int i=0;i<=Math.min(n-1, maxReach);i++){
            // maxReach => actual reachable farthest index
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= (n-1);
    }
}