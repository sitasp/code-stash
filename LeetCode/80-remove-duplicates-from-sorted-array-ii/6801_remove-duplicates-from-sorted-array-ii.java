class Solution {
    public int removeDuplicates(int[] nums) {
        int shifting = 0;
        int n = nums.length;
        Map<Integer, Integer> cur = new HashMap<>();

        // int i = 0;
        int validPosition = 0;
        for(int i=0;i<n;i++){
            int currentNum = nums[i];
            cur.put(nums[i], cur.getOrDefault(nums[i], 0) + 1);
            if(cur.get(currentNum) <= 2){
                nums[validPosition] = currentNum;
                validPosition++;
            } else {
                shifting++;
            }
        }
        // return j+1;
        return n-shifting;
    }

    void swap(int[] nums, int i, int j){
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    // [0,0,1,1,1,1,2,3,3]

    // 0,0,1,1,3,1,2,3,1 -> i=4,sm = 1
    // 0,0,1,1,3,3,2,1,1 -> i=5,sm = 2
    // 0,0,1,1,2,3,3,1,1 -> i=6,sm = 2
}