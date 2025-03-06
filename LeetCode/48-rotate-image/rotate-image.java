class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose 
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int knum = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = knum;
            }
        }

        // mirror
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int knum = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = knum;
            }
        }
    }
}