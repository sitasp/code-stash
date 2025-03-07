class Solution {
    Map<Integer, Integer> hm;

    public int firstMissingPositive(int[] nums) {
        hm = new HashMap<>();
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            if(nums[i] <= 0 || nums[i] > n){
                continue;
            }
            hm.put(nums[i], 1);
        }

        for(int i=1;i<=n;i++){
            if(!hm.containsKey(i)){
                return i;
            }
        }
        return n+1;
    }
}