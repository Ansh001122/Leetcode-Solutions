class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

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
        return true;
    }
}