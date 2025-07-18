class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        return Math.max(calcLeft(nums, 0, n-2), calcRight(nums, 1, n-1));
    }

    int calcLeft(int[] nums, int si, int ei) {
        int n = nums.length;
        int prev1, prev2;
        prev1 = nums[si];
        prev2 = nums[si];
        if(si+1<=ei) {
            prev1 = Math.max(prev1, nums[si+1]);
        }
        for(int i=si+2;i<=ei;i++){
            int curr = prev2 + nums[i];
            curr = Math.max(curr, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.max(prev1, prev2);
    }

    int calcRight(int[] nums, int si, int ei) {
        int n = nums.length;
        int prev1, prev2;
        prev1 = nums[ei];
        prev2 = nums[ei];
        if(ei-1>= si) {
            prev1 = Math.max(prev1, nums[ei-1]);
        }
        for(int i=ei-2;i>=si;i--){
            int curr = prev2 + nums[i];
            curr = Math.max(curr, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.max(prev1, prev2);
    }
}