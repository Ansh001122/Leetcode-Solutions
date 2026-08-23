class Solution {
    public boolean sumGame(String num) {
       int n = num.length();
        int balance = 0; // Tracks 2 * sum + 9 * '?'

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            int val = (c == '?') ? 9 : 2 * (c - '0');
            
            // First half adds, second half subtracts
            balance += (i < n / 2) ? val : -val;
        }

        return balance != 0;
    }
}