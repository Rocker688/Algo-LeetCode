import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

//        if (root != null) {
//            Stack<TreeNode> stack = new Stack<>();
//            TreeNode pre = null;
//            TreeNode curr;
//            stack.push(root);
//            while (!stack.isEmpty()) {
//                curr = stack.peek();
//                if ((curr.left == null && curr.right == null) || (pre != null && (curr.left == pre || curr.right == pre))) {
//                    curr = stack.pop();
//                    list.add(curr.val);
//                    pre = curr;
//                } else {
//                    if (curr.right != null)
//                        stack.push(curr.right);
//                    if (curr.left != null)
//                        stack.push(curr.left);
//                }
//            }
//        }

        if (root != null) {
            postorderTraversal(root, list);
        }
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }
}
