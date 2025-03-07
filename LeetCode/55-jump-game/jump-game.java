class Solution {
    public boolean canJump(int[] nums) {
        int dist = 1;
        int n = nums.length;
        for(int i=0;i<Math.min(dist, n);i++){
            dist = Math.max(dist, i + nums[i] + 1);
        }
        // System.out.println(dist);
        return dist>=n;
    }
}