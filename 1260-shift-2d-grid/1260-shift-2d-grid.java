class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        
        // Fix 1: Always modulo k to keep it strictly less than size
        k %= size; 
        
        List<List<Integer>> res = new ArrayList<>(m);
        
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                // Fix 2: Clean, safe reverse flat index calculation
                int flatIdx = (i * n + j - k + size) % size;
                row.add(grid[flatIdx / n][flatIdx % n]);
            }
            res.add(row);
        }
        return res;
    }
}