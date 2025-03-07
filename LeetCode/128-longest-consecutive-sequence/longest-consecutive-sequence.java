class Solution {

    Map<Integer, Integer> hm;

    public int longestConsecutive(int[] nums) {
        hm = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            hm.put(nums[i], 1);
        }

        for(int i=0;i<n;i++){
            ans = Math.max(ans, fetchCount(nums[i]));
        }
        
        return ans;
    }
 
    public int fetchCount(int x){
        if(hm.containsKey(x)){
            if(hm.get(x) < 0){
                return (-1) * hm.get(x);
            }
            int y = fetchCount(x-1) + 1;
            hm.put(x, (-1) * y);
            return y;
        }
        else return 0;
    }
}