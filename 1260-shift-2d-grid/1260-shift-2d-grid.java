class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int totalElements = m * n;
        
        // Optimize k: shifting by totalElements results in the same grid
        k = k % totalElements;
        
        // Initialize the result grid with placeholders
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }
        
        // Place each element at its new shifted position
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int oldIndex = r * n + c;
                int newIndex = (oldIndex + k) % totalElements;
                
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                
                result.get(newRow).set(newCol, grid[r][c]);
            }
        }
        
        return result;
    }
}