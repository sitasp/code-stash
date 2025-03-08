class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        
        int[] fq = new int[26];
        for(int i=0;i<s.length();i++){
            fq[s.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++)
            if(fq[i]>0)pq.add(new int[]{fq[i], i+'a'});

        String ans = "";
        while(pq.size() >= 2){
            int[] first = pq.poll();
            int[] second = pq.poll();

            ans = ans + (char)first[1];
            ans = ans + (char)second[1];

            if(first[0]>1)
                pq.add(new int[]{first[0]-1, first[1]});
            if(second[0]>1)
                pq.add(new int[]{second[0]-1, second[1]});
        }

        if(pq.size()==1){
            int[] p = pq.poll();
            if(p[0] > 1){
                return ""; 
            }
            ans = ans + (char)p[1];
        }

        return (pq.isEmpty())?ans:"";
    }
}