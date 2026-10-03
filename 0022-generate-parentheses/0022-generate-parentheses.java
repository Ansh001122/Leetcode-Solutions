class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "",0,0,n);
        return result;
    }

    private void helper(List<String> result,String s, int start, int close, int n){
        if(s.length() == 2 * n){
            result.add(s);
            return;
        }
        if(start < n){
            helper(result, s + "(", start + 1, close, n);
        }
        if(close < start){
            helper(result, s + ")", start, close + 1, n);
        }
    } 
}