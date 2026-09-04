class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k) {
            return "0";
        }

        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < n) {
            while (!st.isEmpty() && k > 0 && (num.charAt(i) - 'a') < (st.peek() - 'a')) {
                k--;
                st.pop();
            }

            st.push(num.charAt(i));
            i++;
        }
        
        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder result = new StringBuilder("");
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        result.reverse();
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}