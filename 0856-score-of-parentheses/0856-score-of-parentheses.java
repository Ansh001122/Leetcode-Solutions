class Solution {
    public int scoreOfParentheses(String s) {
       Deque<Integer> st = new ArrayDeque<>();
        int score = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(score);
                score = 0;
            } else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }
}