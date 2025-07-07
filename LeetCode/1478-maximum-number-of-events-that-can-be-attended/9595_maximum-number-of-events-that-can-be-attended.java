class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (row1, row2) -> Integer.compare(row1[0], row2[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = events.length;
        int minDay = (int)1e5;
        int maxDay = 0;
        for(int i=0;i<n;i++){
            minDay = Math.min(minDay, events[i][0]);
            maxDay = Math.max(maxDay, events[i][1]);
        }

        int curIdx = 0;
        int attended = 0;
        for(int curDay=minDay; curDay<=maxDay; curDay++){
            while(curIdx < n && events[curIdx][0] == curDay){
                minHeap.offer(events[curIdx][1]);
                curIdx++;
            }
            while(!minHeap.isEmpty() && minHeap.peek() < curDay){
                minHeap.poll();
            }
            if(!minHeap.isEmpty()){
                attended++;
                minHeap.poll();
            }
        }

        return attended;
    }
}