class Solution {
    public boolean stoneGameIX(int[] stones) {
      int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }

        // If c0 is even, c0 does not change the parity of the game
        if (count[0] % 2 == 0) {
            return count[1] >= 1 && count[2] >= 1;
        }

        // If c0 is odd, Bob can use 0-stones to force Alice into a corner
        // Alice only wins if the difference between c1 and c2 is greater than 2
        return Math.abs(count[1] - count[2]) > 2;  
    }
}