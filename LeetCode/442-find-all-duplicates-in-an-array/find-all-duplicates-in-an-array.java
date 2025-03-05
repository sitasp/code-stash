class Solution {

    public List<Integer> findDuplicates(int[] nums) {
    
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int i = 0;
    
        while(i < n){
            while(nums[i] != nums[nums[i]-1]){
                int ii = nums[i];
                int jj = nums[nums[i]-1];
                
                nums[nums[i]-1] = ii;
                nums[i] = jj;
            }
            i++;        
        }

        i = 0;
        for(;i<n;i++){
            if(nums[i]!=i+1){
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}