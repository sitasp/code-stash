class Solution {
    public String smallestNumber(String pattern) {
        pattern = pattern + "I";
        int n = pattern.length();
        StringBuilder avail = new StringBuilder();
        for(int i=1;i<=n;i++){
            avail.append(String.valueOf(i));
        }
        int prev = 0;
        boolean desc = false;
        for(int i=0;i<n;i++){
            if(pattern.charAt(i) == 'D'){
                if(desc == false){
                    desc = true;
                    prev = i;
                }
            }
            else {
                if(desc == true){
                    StringBuilder sub = new StringBuilder(avail.substring(prev, i+1));
                    // sub.reverse
                    sub.reverse();
                    avail.replace(prev, i+1, sub.toString());
                }
                desc = false;
            }
        }
        return avail.toString();
    }
}