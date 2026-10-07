/*class Solution {
    private int rows, cols;
    private char[][] board;
    private char[] target;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.target = word.toCharArray();
        rows = board.length;
        cols = board[0].length;

        // Pruning 1: word longer than the board
        if (target.length > rows * cols) return false;

        // Count letters on the board once
        int[] count = new int[128];
        for (char[] row : board)
            for (char ch : row) count[ch]++;

        // Pruning 2: board must contain enough of each letter
        int[] need = new int[128];
        for (char ch : target) {
            if (++need[ch] > count[ch]) return false;
        }

        // Pruning 3: start from the rarer end of the word
        if (count[target[0]] > count[target[target.length - 1]]) {
            reverse(target);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != target[i]) {
            return false;
        }
        if (i == target.length - 1) return true;

        char temp = board[r][c];
        board[r][c] = '#'; // mark visited

        boolean found = dfs(r + 1, c, i + 1)
                     || dfs(r - 1, c, i + 1)
                     || dfs(r, c + 1, i + 1)
                     || dfs(r, c - 1, i + 1);

        board[r][c] = temp; // backtrack
        return found;
    }

    private void reverse(char[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}*/

class Solution {
    int l, m, n;
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean find(char[][] board, int i, int j, String word, int idx) {
        if (idx == l) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';
        for (int[] dir : DIRECTIONS) {
            int i_ = i + dir[0]; // rows
            int j_ = j + dir[1]; // columns

            if (find(board, i_, j_, word, idx + 1)) {
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        l = word.length();
        
        if (m * n < 1) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}