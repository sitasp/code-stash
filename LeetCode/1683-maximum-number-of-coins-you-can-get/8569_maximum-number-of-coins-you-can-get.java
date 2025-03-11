class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;

        Integer[] pilesBoxed = new Integer[n];

        for(int i=0;i<n;i++){
            pilesBoxed[i] = piles[i];
        }

        Arrays.sort(pilesBoxed, (a, b) -> b-a);

        int j = 1;
        int cnt = 0;
        int ans = 0;
        while(cnt < n/3){
            ans += pilesBoxed[j];
            j += 2;
            cnt++;
        }

        return ans;
    }
}