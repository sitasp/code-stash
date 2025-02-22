class Solution {

    public int totalFruit(int[] fruits) {
        
        int l = 0, r = 0;
        
        Map<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        int ans = 0;

        for(;r<fruits.length;r++){
            if(map.containsKey(fruits[r])){
                map.put(fruits[r], map.get(fruits[r]) + 1);
            }
            else map.put(fruits[r], 1);
            while(map.size() > 2 && l < r){
                int leftFruitTypeCount = map.get(fruits[l]);
                leftFruitTypeCount--;
                if(leftFruitTypeCount == 0){
                    map.remove(fruits[l]);
                }
                else map.put(fruits[l], leftFruitTypeCount);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    // [1, 0, 1, 4, 1, 4]
    // l=0,r=0=> [1], recentIdx:[{1,0}]
    // ans = 1

    // l=0, r=1 => [1,0], recentIdx:[{1,0},{0,1}]
    // ans = 2

    // l=0, r=2 => [1, 0], recentIdx: []
}