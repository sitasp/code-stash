class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> hm;
    Random rand = new Random();

    public RandomizedSet() {
        list = new ArrayList<>();
        hm = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean doesExist = hm.containsKey(val);
        if(!doesExist){
            list.add(val);
            int index = list.size()-1;
            hm.put(val, index);
        }
        return !doesExist;
    }
    
    public boolean remove(int val) {
        boolean doesExist = hm.containsKey(val);
        if(doesExist){
            int curIndex = hm.get(val);
            int sz = list.size();
            swap(curIndex, sz-1);
            removeLast();
        }
        return doesExist;
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

    public void swap(int i, int j){
        int i1 = list.get(i);
        int j1 = list.get(j);
        
        list.set(i, j1);
        list.set(j, i1);

        hm.put(i1, j);
        hm.put(j1, i);
    }

    public void removeLast(){
        int sz = list.size();
        int val = list.get(sz-1);
        hm.remove(val);
        list.remove(sz-1);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */