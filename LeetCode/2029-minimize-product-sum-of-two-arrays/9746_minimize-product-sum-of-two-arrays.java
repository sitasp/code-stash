class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       
       Integer[] nums2Boxed = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            nums2Boxed[i] = nums2[i];
        }
        Arrays.sort(nums2Boxed, Collections.reverseOrder());

       int ans = 0;
       for(int i=0;i<nums1.length;i++){
        ans += nums1[i] * nums2Boxed[i];
       }

       return ans; 
    }
}