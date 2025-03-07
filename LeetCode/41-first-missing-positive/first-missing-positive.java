class Solution {
    Map<Integer, Integer> hm;

    public int firstMissingPositive(int[] nums) {
        hm = new HashMap<>();
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            hm.put(nums[i], 1);
        }

        return incre(1) + 1;
    }

    int incre(int x){
        if(hm.containsKey(x)){
            if(hm.get(x) < 0){
                return (-1) * hm.get(x);
            }
            int y = incre(x + 1);
            hm.put(x, (-1) * (y + 1));
            return (-1) * hm.get(x);
        }
        return 0;
    }
}