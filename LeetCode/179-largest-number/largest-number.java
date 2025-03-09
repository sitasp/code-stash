class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>((s1, s2) -> {
            String s3 = s1 + s2;
            String s4 = s2 + s1;
            return s4.compareTo(s3);
        });

        int n = nums.length;
        for(int i=0;i<n;i++){
            maxHeap.add(String.valueOf(nums[i]));
        }

        String ans = "";
        while(!maxHeap.isEmpty()){
            ans += maxHeap.poll();
        }

        if(ans.length() > 1 && ans.charAt(0)=='0')
            return "0";

        return ans;
    }
}