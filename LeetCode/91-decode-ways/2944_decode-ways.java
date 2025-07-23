class Solution {

    Map<Integer, Integer> cache = new HashMap<>();

    public int numDecodings(String s) {
        return numDecodingsHelper(s.toCharArray(), 0);
    }

    public int numDecodingsHelper(char[] arr, int index) {
        int len = arr.length;
        if(cache.containsKey(index))
            return cache.get(index);
        if(index == len){
            cache.put(index, 1);
            return 1;
        }
        if(arr[index] == '0'){
            cache.put(index, 0);
            return 0;
        }
        int total = numDecodingsHelper(arr, index + 1);
        if(index + 1 >= len){
            cache.put(index, total);
            return total;
        }
        int num = getNum(arr[index], arr[index+1]);
        if(num >= 10 && num <= 26){
            total += numDecodingsHelper(arr, index + 2);
        }
        cache.put(index, total);
        return total;
    }

    int getNum(char a, char b) {
        return (a-'0')*10 + (b-'0');
    }
}