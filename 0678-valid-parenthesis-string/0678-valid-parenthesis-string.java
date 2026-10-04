class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen = Math.max(0, minOpen - 1);
                maxOpen--;
            } else { // Character is '*'
                minOpen = Math.max(0, minOpen - 1); // '*' acts as ')'
                maxOpen++;                           // '*' acts as '('
            }

            // If maxOpen is negative, we have more ')' than '(' and '*' combined
            if (maxOpen < 0) {
                return false;
            }
        }

        // At the end, minOpen must be 0 for all open parentheses to be closed
        return minOpen == 0;
    }
}