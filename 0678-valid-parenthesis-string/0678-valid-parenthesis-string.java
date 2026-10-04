class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // c == '*'
                low--;
                high++;
            }

            // More ')' than available '(' and '*' combined
            if (high < 0) {
                return false;
            }

            // low cannot be negative because '*' can be treated as empty
            if (low < 0) {
                low = 0;
            }
        }

        return low == 0;
    }
}