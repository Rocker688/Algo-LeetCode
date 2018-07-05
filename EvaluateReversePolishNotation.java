import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int lsOfStr = tokens[i].charAt(tokens[i].length() - 1) - '0';
            boolean isNum = lsOfStr >= 0 && lsOfStr <= 9;
            if (isNum)
                stack.push(Integer.parseInt(tokens[i]));
            else {
                int op1 = stack.pop();
                int op2 = stack.pop();
                switch (tokens[i].charAt(0)) {
                    case '+':
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op2 - op1);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op2 / op1);
                        break;
                    default:
                        return 0;
                }
            }
        }
        return stack.pop();
    }
}
