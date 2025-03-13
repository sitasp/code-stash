class Solution {
    public String convert(String s, int numRows) {
        // cycle = 2 * numRows - 2;
        // gap = {2 * [(numRows - 1) - i] - 1};
        // next element = (i + gap);
        // i=0 => 5
        // i=1 => 3
        
        int n = s.length();
        int cycle = 2 * numRows - 2;
        if(n <= 1  || cycle == 0)
            return s;
        String ans = "";
        // System.out.println(cycle);
        for(int i=0;i<numRows;i++){
            int j = i;
            int gap = 2 * (numRows-i-1);
            if(gap == 0){
                gap = 2 * (numRows - 1);
            }
            // System.out.print(i + " " + gap + " ");
            String res = "";
            while(j < n){
                res += s.charAt(j);
                j = gap + j;
                gap = cycle - (gap % cycle);
            }
            // System.out.println(res);
            ans += res;
        }

        return ans;
    }
}