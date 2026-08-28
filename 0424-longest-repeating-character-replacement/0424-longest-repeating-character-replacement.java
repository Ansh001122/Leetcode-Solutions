class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand window by adding character at 'right'
            char rightChar = s.charAt(right);
            freq[rightChar - 'A']++;
            maxFreq = Math.max(maxFreq, freq[rightChar - 'A']);
            // If characters to replace exceed k, shrink the window from the left
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            // Update maximum valid window size
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}