/*class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Save the starting index where the new substring context begins
                stack.push(sb.length());
            } else if (c == ')') {
                // Pop the matching opening index and reverse the segment in-place
                int start = stack.pop();
                reverse(sb, start, sb.length() - 1);
            } else {
                // Append regular characters
                sb.append(c);
            }
        }

        return sb.toString();
    }
    // Helper method to reverse a portion of a StringBuilder
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}*/


class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(curr);
                curr = new StringBuilder();
            } else if (ch == ')') {
                curr.reverse();
                StringBuilder temp = stack.pop();
                temp.append(curr);
                curr = temp;
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}