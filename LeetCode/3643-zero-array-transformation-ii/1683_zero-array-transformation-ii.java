class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] diff = new int[n+1];

        int sum = 0; int k = 0;
        for(int i=0;i<n;i++){
            while(sum + diff[i] < nums[i]){
                if(k+1 > queries.length){
                    return -1;
                }
                int l = queries[k][0];
                int r = queries[k][1];
                int val = queries[k][2];
                if(i <= r){
                    diff[Math.max(l, i)] += val;
                    diff[r+1] -= val;
                }
                k++;
            }
            sum += diff[i];
        }

        return k;
    }
}