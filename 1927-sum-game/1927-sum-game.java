class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumDiff = 0;
        int qDiff = 0;

        for (int i = 0; i < n; i++) {
            int sign = (i < n / 2) ? 1 : -1;
            char ch = num.charAt(i);

            if (ch == '?') {
                qDiff += sign;
            } else {
                sumDiff += sign * (ch - '0');
            }
        }

        // If net question mark difference is odd, Alice makes the last move and wins
        if ((qDiff & 1) != 0) {
            return true;
        }

        // Bob can only win if the sum difference perfectly offsets Bob's 9-sum pairing strategy
        // Alice wins if 2 * sumDiff + qDiff * 9 != 0
        return (2 * sumDiff + qDiff * 9) != 0;
    }
}