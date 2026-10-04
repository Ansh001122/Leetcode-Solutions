class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", n); 
        return result;
    }

    private void helper(List<String> result, String current, int n) {
        if (current.length() == 2 * n) {
            if (isvalid(current)) {
                result.add(current);
            }   
            return;
        }
        helper(result, current + "(", n);
        helper(result, current + ")", n);
    }

    boolean isvalid(String s) {
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    } 
}