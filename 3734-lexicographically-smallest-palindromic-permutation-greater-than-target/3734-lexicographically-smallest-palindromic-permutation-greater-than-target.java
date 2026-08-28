class Solution {
    public String lexPalindromicPermutation(String s, String target) {
       int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Validate single odd character constraint for palindromes
        int odd = 0;
        int middle = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
                middle = i;
            }
        }

        if (odd > (n % 2)) {
            return "";
        }

        int halfLen = n / 2;
        int[] half = new int[26];
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        // Case 1: Check if exact first half of target yields a palindrome > target
        int[] tempHalf = half.clone();
        boolean canMatchExact = true;
        for (int i = 0; i < halfLen; i++) {
            int c = target.charAt(i) - 'a';
            if (tempHalf[c] > 0) {
                tempHalf[c]--;
            } else {
                canMatchExact = false;
                break;
            }
        }

        if (canMatchExact) {
            String candidate = makePalindrome(target.substring(0, halfLen), middle);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // Case 2: Match as long a prefix with target as possible in O(n)
        int matchLen = 0;
        while (matchLen < halfLen && half[target.charAt(matchLen) - 'a'] > 0) {
            half[target.charAt(matchLen) - 'a']--;
            matchLen++;
        }

        // Backtrack from matchLen down to 0 to find the rightmost split point
        for (int i = matchLen; i >= 0; i--) {
            if (i < halfLen) {
                int targetChar = target.charAt(i) - 'a';

                for (int c = targetChar + 1; c < 26; c++) {
                    if (half[c] > 0) {
                        StringBuilder firstHalf = new StringBuilder();
                        firstHalf.append(target, 0, i);
                        firstHalf.append((char) ('a' + c));
                        half[c]--;

                        // Fill remaining first half greedily with smallest available characters
                        for (int k = 0; k < 26; k++) {
                            while (half[k] > 0) {
                                firstHalf.append((char) ('a' + k));
                                half[k]--;
                            }
                        }

                        return makePalindrome(firstHalf.toString(), middle);
                    }
                }
            }

            // Restore character for previous position
            if (i > 0) {
                half[target.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }

    private String makePalindrome(String firstHalf, int middle) {
        StringBuilder ans = new StringBuilder(firstHalf);
        if (middle != -1) {
            ans.append((char) ('a' + middle));
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            ans.append(firstHalf.charAt(i));
        }
        return ans.toString();
    }
}