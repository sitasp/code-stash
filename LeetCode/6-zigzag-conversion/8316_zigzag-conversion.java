class Solution {
    public String convert(String s, int numRows) {

        int n = s.length();
        int cycle = 2 * numRows - 2;
        if(n <= 1  || cycle == 0)
            return s;
        String ans = "";
        for(int i=0;i<numRows;i++){
            int j = i;
            String res = "";
            while(j < n){
                res += s.charAt(j);
                if(i % numRows != 0 && i % numRows != (numRows-1)){
                    int next = j + 2 * (numRows-1-i);
                    if(next < n) 
                        res += s.charAt(next);
                }
                j =  j + cycle;    
            }
            // System.out.println(res);
            ans += res;
        }

        return ans;
    }
}