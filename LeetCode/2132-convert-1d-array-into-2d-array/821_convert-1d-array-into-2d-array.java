class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] arr = new int[m][n];

        if(original.length != m*n)
            return new int[0][0];

        int len = original.length;
        for(int i=0;i<len;i++){
            arr[i/n][i%n] = original[i];
        }

        return arr;
    }
}