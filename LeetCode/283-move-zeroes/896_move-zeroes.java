class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 1;
        int len = nums.length;
    
        while(l < r && r < len){
            while(l < r && r < len && nums[l] != 0){
                l++;
                r++;
            }
            while(l < r && r < len && nums[r] == 0){
                r++;
            }
            if(l < r && r < len)
                swap(nums, l, r);
        }
    }

    public void swap(int[] nums, int l, int r){
        int k = nums[l];
        nums[l] = nums[r];
        nums[r] = k;
    }
}