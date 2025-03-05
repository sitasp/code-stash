class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;
        
        int hare = nums[0];
        int tortoise = nums[0];

        while(true){
            hare = nums[nums[hare]];
            tortoise = nums[tortoise];
            if(hare == tortoise)
                break;
        }

        hare = nums[0];
        while(hare != tortoise){
            hare = nums[hare];
            tortoise = nums[tortoise];
        }

        return hare;
    }
}