class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char currentVal = board[r][c];

                if (currentVal == '.') {
                    continue;
                }

                String rowKey = currentVal + " in row " + r;
                String colKey = currentVal + " in col " + c;
                String boxKey = currentVal + " in box " + (r / 3) + "-" + (c / 3);

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;*/

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int num = board[row][col] - '1';
                int box = (row / 3) * 3 + (col / 3);

                if (rows[row][num] || cols[col][num] || boxes[box][num]) {
                    return false;
                }
                rows[row][num] = true;
                cols[col][num] = true;
                boxes[box][num] = true;
            }
        }
        return true;
    }
}