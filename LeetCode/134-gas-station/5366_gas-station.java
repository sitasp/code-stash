class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int curGas = 0;
        int startPos = 0;

        for(int i=0;i<n;i++){
            int surplus = gas[i] - cost[i];
            totalGas += surplus;
            curGas += surplus;
            if(curGas <= 0){
                startPos = i+1;
                curGas = 0;
            }
        }

        return (totalGas>=0)?startPos%n:-1;
    }
}