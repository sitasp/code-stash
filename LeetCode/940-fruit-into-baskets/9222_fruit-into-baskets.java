class Solution {

    public int totalFruit(int[] fruits) {
        
        int l = 0, r = 0;
        
        Map<Integer, Integer> lastPositions = new HashMap<>();
        int ans = 0;

        for(;r<fruits.length;r++){
            int curFruit = fruits[r];
            lastPositions.put(fruits[r], r);
            if(lastPositions.size() > 2){
                int earliestFruit = lastPositions.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();

                l = lastPositions.get(earliestFruit) + 1;
                lastPositions.remove(earliestFruit);
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}