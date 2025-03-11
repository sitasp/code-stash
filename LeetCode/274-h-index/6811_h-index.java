class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Integer[] cBoxed = new Integer[n];
        for(int i=0;i<n;i++){
            cBoxed[i] = citations[i];
        }
        Arrays.sort(cBoxed, Collections.reverseOrder());

        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, Math.min(cBoxed[i], i+1));
        }

        return ans;
    }
}