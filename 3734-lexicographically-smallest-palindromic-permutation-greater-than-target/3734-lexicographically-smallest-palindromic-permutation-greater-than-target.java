class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Validate palindrome possibility and find odd middle character
        int oddCount = 0;
        Character midChar = null;
        int[] halfCount = new int[26];

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
            halfCount[i] = count[i] / 2;
        }

        if (oddCount > (n % 2)) {
            return ""; // Cannot form a palindrome
        }

        int m = n / 2;

        // Scenario 1: Check if matching target[0 ... m-1] exactly yields a valid palindrome > target
        int[] tempHalf = halfCount.clone();
        boolean canMatchExact = true;
        for (int i = 0; i < m; i++) {
            int c = target.charAt(i) - 'a';
            if (tempHalf[c] > 0) {
                tempHalf[c]--;
            } else {
                canMatchExact = false;
                break;
            }
        }

        if (canMatchExact) {
            String candidate = buildPalindrome(target.substring(0, m), midChar);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // Scenario 2: Backtrack from deepest matching prefix to find the rightmost index i to place c > target[i]
        int matchLen = 0;
        while (matchLen < m && halfCount[target.charAt(matchLen) - 'a'] > 0) {
            halfCount[target.charAt(matchLen) - 'a']--;
            matchLen++;
        }

        for (int i = matchLen; i >= 0; i--) {
            if (i < m) {
                int targetChar = target.charAt(i) - 'a';

                for (int c = targetChar + 1; c < 26; c++) {
                    if (halfCount[c] > 0) {
                        // Found smallest valid character > target[i]
                        StringBuilder half = new StringBuilder();
                        half.append(target, 0, i);
                        half.append((char) ('a' + c));
                        halfCount[c]--;

                        // Fill remaining prefix greedily with smallest available characters
                        for (int j = 0; j < 26; j++) {
                            while (halfCount[j] > 0) {
                                half.append((char) ('a' + j));
                                halfCount[j]--;
                            }
                        }

                        return buildPalindrome(half.toString(), midChar);
                    }
                }
            }

            // Backtrack: return character target.charAt(i - 1) back to halfCount pool
            if (i > 0) {
                halfCount[target.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }

    private String buildPalindrome(String firstHalf, Character midChar) {
        StringBuilder sb = new StringBuilder(firstHalf);
        if (midChar != null) {
            sb.append(midChar);
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }
}