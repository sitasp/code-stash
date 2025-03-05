class Solution {
    
    public int[] productExceptSelf(int[] nums) {    
        int len = nums.length;
        
        int[] suffixM = new int[len+1];
        int[] prefixM = new int[len+1];

        prefixM[0] = 1;
        for(int i=0;i<len;i++){
            prefixM[i+1] = prefixM[i] * nums[i];
        }

        suffixM[len] = 1;
        for(int i=len-1;i>=0;i--){
            suffixM[i] = nums[i] * suffixM[i+1];
        }

        int[] ans = new int[len];
        for(int i=0;i<len;i++){
            ans[i] = prefixM[i] * suffixM[i+1];
        }

        return ans;
    }
}