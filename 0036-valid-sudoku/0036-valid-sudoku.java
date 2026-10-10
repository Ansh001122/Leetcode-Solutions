class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char currentVal = board[r][c];

                // Skip empty cells
                if (currentVal == '.') {
                    continue;
                }

                // Construct unique identifiers for row, column, and 3x3 sub-box
                String rowKey = currentVal + " in row " + r;
                String colKey = currentVal + " in col " + c;
                String boxKey = currentVal + " in box " + (r / 3) + "-" + (c / 3);

                // If any of these already exist in our set, the Sudoku is invalid
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}