class Solution {
    // bucket sort
    public int hIndex(int[] citations) {
        int n = citations.length;
    
        int[] bucket = new int[n+1];
        for(int i=0;i<n;i++){
            bucket[Math.min(citations[i], n)]++;
        }

        int paperCount=0;
        for(int i=n;i>=0;i--){
            paperCount+=bucket[i];
            if(paperCount >= i){
                return i;
            }
        }

        return 0;
    }
}