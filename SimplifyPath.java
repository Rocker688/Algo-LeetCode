import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        while (path.length() > 0 && path.charAt(path.length() - 1) == '/')
            path = path.substring(0, path.length() - 1);

        int start = 0;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                stack.push(path.substring(start, i));
                start = i;
            } else if (i == path.length() - 1) {
                stack.push(path.substring(start));
            }
        }

        LinkedList<String> strLst = new LinkedList<>();
        int back = 0;
        while (!stack.isEmpty()) {
            String str = stack.pop();
            if (str.equals("/") || str.equals("/."))
                ;
            else if (str.equals("/.."))
                back++;
            else {
                if (back > 0)
                    back--;
                else
                    strLst.push(str);
            }
        }

        if (strLst.isEmpty())
            return "/";
        StringBuilder result = new StringBuilder(128);

        while (!strLst.isEmpty())
            result.append(strLst.pop());

        return result.toString();
    }
}
