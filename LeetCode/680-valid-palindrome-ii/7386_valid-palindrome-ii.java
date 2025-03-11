class Solution {
    public boolean validPalindrome(String s) {

        if(s.length() <= 2)
            return true;

        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        if(rev.toString() == s){
            return true;
        }

        boolean isPossible;
        int n = s.length();
        isPossible = ifPossible(s, 0, n-1, 0);

        return isPossible;
    }

    boolean ifPossible(String s, int i, int j, int cm){
        if(i > j){
            return true;
        }
        if(s.charAt(i) != s.charAt(j)){
            cm++;
            if(cm >= 2) return false;
            return ifPossible(s, i+1, j, cm) || ifPossible(s, i, j-1, cm);
        }
        return ifPossible(s, i+1, j-1, cm);
    }


}