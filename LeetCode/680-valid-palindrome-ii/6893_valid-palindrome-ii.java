class Solution {
    public boolean validPalindrome(String s) {

        if(s.length() <= 2)
            return true;

        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        if(rev.toString().equals(s)){
            return true;
        }

        boolean isPossible;
        int n = s.length();
        int left = 0;
        int right = n-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return isPossible(s, left+1, right) || isPossible(s, left, right-1);
            }
            left++;
            right--;
        }

        return true;
    }

    boolean isPossible(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}