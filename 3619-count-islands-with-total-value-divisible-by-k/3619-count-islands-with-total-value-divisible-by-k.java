class Solution {
    int[][] Garea;
    int m,n;
    public int countIslands(int[][] grid, int k) {
        int maxArea = 0;
        Garea = grid;
        m = grid.length;
        n = grid[0].length;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(Garea[i][j] != 0){
                    if(count(i , j) % k == 0){
                        maxArea++;
                    }
                }
            }
        }
        return maxArea;
    }
    private long count(int i, int j){
        long area = Garea[i][j];
        Garea[i][j] = 0;

        if(i > 0 && Garea[i - 1][j] != 0){
            area += count(i - 1,j);
        }
        if(j > 0 && Garea[i][j - 1] != 0){
            area += count(i,j - 1);
        }
        if(i < m - 1 && Garea[i + 1][j] != 0){
            area += count(i + 1,j);
        }
        if(j < n - 1 && Garea[i][j + 1] != 0){
            area += count(i,j + 1);
        }
        return area;    

    }
}