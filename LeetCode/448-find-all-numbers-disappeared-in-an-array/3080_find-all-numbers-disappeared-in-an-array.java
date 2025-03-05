class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int len = nums.length;
        while(i < len){
            while(nums[i] != nums[nums[i] - 1]){
                int li = i;
                int ri = nums[i] - 1;
                
                int k = nums[li];
                int kk = nums[ri];

                nums[ri] = k; nums[li] = kk;
            }
            i++;
        }

        List<Integer> missingNums = new ArrayList<>();
        for(int ii=0;ii<len;ii++){
            if(nums[ii]-1 != ii){
                missingNums.add(ii+1);
            }
        }

        return missingNums;
    }
}