class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] cnt = new int[26];
        int len = tasks.length;
        int maxFreq = 0;
        
        for(int i=0;i<len;i++){
            maxFreq = Math.max(maxFreq, ++cnt[tasks[i]-'A']);
        }

        Arrays.sort(cnt);
        maxFreq = cnt[25];

        int idleSlots = (maxFreq - 1) * n;

        for(int i=24;i>=0 && cnt[i]>0;i--){
            idleSlots -= Math.min(cnt[i], maxFreq-1);
        }

        // System.out.println(idleSlots);

        return len + Math.max(idleSlots, 0);
    }
}