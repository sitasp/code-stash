class Solution {
    
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length;
        
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(nums[i] <= first){
                first = nums[i];
            }    
            else if(nums[i] <= second){
                second = nums[i];
            }
            else {
                third = nums[i];
                return true;
            }
        }
        return false;
    }
}