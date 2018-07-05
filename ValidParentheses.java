import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        String left = "({[";
        String right = ")}]";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (left.indexOf(s.charAt(i)) != -1)
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty() || stack.peek() != left.charAt(right.indexOf(s.charAt(i))))
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
