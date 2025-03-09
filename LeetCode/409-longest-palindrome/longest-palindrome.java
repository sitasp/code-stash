class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char c: s.toCharArray()){
            mp.put(c, mp.get(c)==null?1:mp.get(c)+1);
        }
        int cnt2 = 0;
        boolean odd = false;
        for(Map.Entry<Character, Integer> en: mp.entrySet()){
            cnt2 += en.getValue()/2;
            odd = odd || (en.getValue()%2 == 1);
        }
        int ans = cnt2 * 2;
        if(odd) ans++;
        return ans;
    }
}