class Solution {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] diff = new int[n+2];

        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            diff[l] += 1;
            diff[r+1] -= 1;
        }

        for(int i=1;i<=n;i++){
            diff[i] = diff[i] + diff[i-1];
        }

        int nn = nums.length;
        for(int i=0;i<nn;i++){
            if(nums[i] - diff[i] > 0){
                return false;
            }
        }

        return true;
    }
    
    // public boolean isAllZero(int[] nums){
    //     int nn = nums.length;
    //     for(int i=0;i<nn;i++){
    //         if(nums[i]>0)
    //             return false;
    //     }
    //     return true;
    // }
}