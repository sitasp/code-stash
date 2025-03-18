class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<q;i++){
            // System.out.println(queries[i][0] + " " + queries[i][1]);
            queue.add(queries[i]);
        }

        int sum = 0;
        int k = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        int[] diff = new int[n+1];
        int queriesUsed = 0;

        for(int i=0;i<n;i++){

            while(!queue.isEmpty() && queue.peek()[0] == i){
                int[] query = queue.poll();
                heap.add(-query[1]);
            }

            while(sum + diff[i] < nums[i]){
                if(heap.isEmpty()){
                    return -1;
                }

                int r = -heap.poll();

                if(i <= r){
                    diff[r+1]--;
                    sum++;
                    queriesUsed++;
                }
            }
            sum += diff[i];
        }

        return q-queriesUsed;
    }
}