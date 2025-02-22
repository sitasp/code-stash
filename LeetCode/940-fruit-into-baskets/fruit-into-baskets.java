class Solution {

    class Pair <R, S> {
        R first;
        S second;

        Pair(R first, S second){
            this.first = first;
            this.second = second;
        }
    }


    class LRUCache <K, V> extends LinkedHashMap<K, V> {

        final int capacity;
        Stack<Pair<Map.Entry<K, V>, Boolean>> stack;

        LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
            this.stack = new Stack<>();
        }

        // called after put method
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            boolean shouldEvict = size() > capacity;
            if(shouldEvict){
                stack.add(new Pair<>(eldest, false));
            }
            return shouldEvict;
        }

        public Map.Entry<K, V> getEvictedValue(){
            while(!stack.empty() && stack.peek().second){
                stack.pop();
            }
            if(stack.isEmpty()){
                return null;
            }
            Pair<Map.Entry<K, V>, Boolean> topElem = stack.peek();
            topElem.second = true;
            return topElem.first;
        }
    }

    public int totalFruit(int[] fruits) {
        
        int l = 0, r = 0;
        
        LRUCache<Integer, Integer> lru = new LRUCache<>(2);

        int cnt = 0;
        int ans = 0;

        for(;r<fruits.length;r++){
            lru.put(fruits[r], r);
            Map.Entry<Integer, Integer> evictedElem = lru.getEvictedValue();
            if(Objects.nonNull(evictedElem)){
                int pos = evictedElem.getValue();
                l = pos + 1;
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