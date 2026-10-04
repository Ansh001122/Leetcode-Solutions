/*class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();//this will work for smaller inputs 
        helper(result, "", n); //keep it same as it has to recall itself form helper function
        return result;
    }

    private void helper(List<String> result, String current, int n) {
        if (current.length() == 2 * n) {
            if (isvalid(current)) {
                result.add(current);
            }   
            return;
        }
        helper(result, current + "(", n);//make it sure that they are same 
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
}*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            backtrack(result, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1); 
        }
        if (close < open) {
            sb.append(')');
            backtrack(result, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1); 
        }
    }
}