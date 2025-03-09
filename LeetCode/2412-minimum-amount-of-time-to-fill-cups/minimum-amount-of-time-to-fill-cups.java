class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

        for(int i=0;i<amount.length;i++) {
            if(amount[i] > 0)
                maxHeap.add(amount[i]);
        }

        int cnt = 0;
        
        while(maxHeap.size()>1){
            int am0 = maxHeap.poll();
            int am1 = maxHeap.poll();
            am0--;am1--;
            if(am0>0) maxHeap.add(am0);
            if(am1>0) maxHeap.add(am1);
            cnt++;
        }

        if(maxHeap.size()==1){
            cnt += maxHeap.poll();
        }

        return cnt;
    }
}