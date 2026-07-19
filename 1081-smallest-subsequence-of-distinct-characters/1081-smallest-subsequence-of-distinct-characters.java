class Solution {
    public String smallestSubsequence(String s) {
        char[] chars = s.toCharArray();
        
        // Find the last index where each character appears
        int[] lastIndex = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        
        // Use a standard Java double-ended queue (Deque) as our stack
        // It provides clean array-backed push/pop semantics
        java.util.ArrayDeque<Character> stack = new java.util.ArrayDeque<>();
        boolean[] seen = new boolean[26];
        
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            
            // Skip if the character is already part of the unique subsequence
            if (seen[curr - 'a']) {
                continue;
            }
            
            // Maintain the monotonic increasing order if the larger element appears later
            while (!stack.isEmpty() && stack.peek() > curr && lastIndex[stack.peek() - 'a'] > i) {
                char removed = stack.pop();
                seen[removed - 'a'] = false;
            }
            
            stack.push(curr);
            seen[curr - 'a'] = true;
        }
        
        // Build the final result string cleanly
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        // Since we popped from a LIFO stack, the string is reversed
        return result.reverse().toString();
    }
}