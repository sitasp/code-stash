class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i+1];
            if(i+2 <= n){
                int num = getNum(s.charAt(i), s.charAt(i+1));
                if(num>=10 && num<=26){
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }

    // public int numDecodingsHelper(char[] arr, int index) {
    //     int len = arr.length;
    //     if(cache.containsKey(index))
    //         return cache.get(index);
    //     if(index == len){
    //         cache.put(index, 1);
    //         return 1;
    //     }
    //     if(arr[index] == '0'){
    //         cache.put(index, 0);
    //         return 0;
    //     }
    //     int total = numDecodingsHelper(arr, index + 1);
    //     if(index + 1 >= len){
    //         cache.put(index, total);
    //         return total;
    //     }
    //     int num = getNum(arr[index], arr[index+1]);
    //     if(num >= 10 && num <= 26){
    //         total += numDecodingsHelper(arr, index + 2);
    //     }
    //     cache.put(index, total);
    //     return total;
    // }

    int getNum(char a, char b) {
        return (a-'0')*10 + (b-'0');
    }
}