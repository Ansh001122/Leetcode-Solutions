class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];//Save Bottom-Left to temp
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];//Move Bottom-Right to Bottom-Left.
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];//Move Top-Right to Bottom-Right.
                matrix[j][n - 1 - i] = matrix[i][j];//Move Top-Left to Top-Right
                matrix[i][j] = temp;//Put the saved Bottom-Left (temp) into Top-Left
            }
        }
    }
}    
/*
Top-Left: matrix[i][j]
Top-Right: matrix[j][n - 1 - i]
Bottom-Right: matrix[n - 1 - i][n - 1 - j]
Bottom-Legt: matrix[n - 1 - j][i]
*/