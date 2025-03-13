class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(numRows <= 1 || numRows >= n)
            return s;
        int step = 1;
        var rows = new ArrayList<StringBuilder>();
        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        for(int i=0;i<n;i++){
            rows.get(curRow).append(s.charAt(i));
            curRow += step;
            if(curRow == 0 || curRow == numRows-1){
                step = -step;
            }
        }

        String ans = "";
        for(int i=0;i<numRows;i++){
            ans += rows.get(i);
        }

        return ans;
    }
}