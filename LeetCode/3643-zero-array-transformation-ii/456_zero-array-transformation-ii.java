class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] diff = new int[n+2];

        int l = 0;
        int r = q;

        if(!canFormZeroArray(nums, queries, r)){
            return -1;
        }

        while(l <= r){
            int middle = l + (r - l) / 2;
            if(canFormZeroArray(nums, queries, middle)){
                r = middle-1;
            }
            else l = middle+1;
        }

        return (l > q) ? -1 : l;
    }

    boolean canFormZeroArray(int[] nums, int[][] queries, int k){
        int n = nums.length;
        int[] diff = new int[n+1];

        for(int i=0;i<k;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            diff[l] += val;
            diff[r+1] -= val;
        }

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += diff[i];
            if(sum < nums[i]){
                return false;
            }
        }
        return true;
    }
}