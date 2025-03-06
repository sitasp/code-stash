class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        List<Integer> al = new ArrayList<>();

        while(top <= bottom && left <= right){
            for(int j=left;j<=right;j++){
                al.add(matrix[top][j]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                al.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int j=right;j>=left;j--){
                    al.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i=bottom;i>=top;i--){
                    al.add(matrix[i][left]);
                }
                left++;
            }
        }

        return al;
    }
}