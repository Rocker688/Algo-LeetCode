import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max_len = 0, last = -1;
        Stack<Integer> lefts = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                if (lefts.isEmpty()) {
                    last = i;
                } else {
                    lefts.pop();
                    if (lefts.isEmpty()) {
                        max_len = Integer.max(max_len, i - last);
                    } else
                        max_len = Integer.max(max_len, i - lefts.peek());
                }
            }
        }
        return max_len;
    }
}
