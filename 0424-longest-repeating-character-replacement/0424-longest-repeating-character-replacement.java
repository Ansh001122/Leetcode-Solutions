class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right); // Expand window by adding character at 'right'
            freq[rightChar - 'A']++;
            maxFreq = Math.max(maxFreq, freq[rightChar - 'A']);
            while ((right - left + 1) - maxFreq > k) {   // If characters to replace exceed k, shrink the window from the left
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);    // Update maximum valid window size
        }
        return maxLength;
    }
}