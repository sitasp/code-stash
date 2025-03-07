class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        int i = 0;
        while(i < n){
            while(!(nums[i] <= 0 || nums[i] > n || nums[i]==(i+1) || nums[i]==nums[nums[i]-1])){
                swap(nums, i, nums[i]-1);
            }
            i++;
        }

        for(i=0;i<n;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }

    void swap(int[] nums, int i, int j){
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
}