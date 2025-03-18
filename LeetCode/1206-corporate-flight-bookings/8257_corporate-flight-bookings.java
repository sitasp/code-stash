class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] cnt = new int[n+1];
        int q = bookings.length;
        for(int i=0;i<q;i++){
            int l = bookings[i][0];
            int r = bookings[i][1];
            int val = bookings[i][2];
            cnt[l-1] += val;
            cnt[r] -= val;
        }
        for(int i=1;i<=n;i++){
            cnt[i] += cnt[i-1];
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = cnt[i];
        }
        return ans;
    }
}