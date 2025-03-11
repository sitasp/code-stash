class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int[] rowMax = new int[r];
        int[] colMax = new int[c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
            }
        }

        for(int j=0;j<c;j++){
            for(int i=0;i<r;i++){
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int ans = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans += Math.abs(grid[i][j] - Math.min(rowMax[i], colMax[j]));
            }
        }

        return ans;
    }
}