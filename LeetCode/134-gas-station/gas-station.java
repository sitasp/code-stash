class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int prefix = 0;
        
        for(int i=0;i<n;i++){
            sum += gas[i] - cost[i];
        }

        if(sum < 0) 
            return -1;

        if(n == 1 && sum == 0){
            return 0;
        }


        int ssum = 0;
        int index = 0;
        boolean pos = false;
        // int 
        for(int j=0;j<n;j++){
            ssum = ssum + gas[j] - cost[j];
            if(ssum <= 0){
                index = j+1;
                ssum = 0;
            }
            else pos = true;
        }
        // System.out.println(pos);
        return (pos == true)?(index%n):-1;
    }
}