import java.util.*;
import utility.*;

public class Playground {

    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left == null && cur.right == null) {
                    result.add(cur.key);
                    stack.pollFirst();
                } else if (cur.left == null) {
                    stack.offerFirst(cur.right);
                } else {
                    stack.offerFirst(cur.left);
                }
            } else if (cur.left == pre) {
                if (cur.right == null) {
                    result.add(cur.key);
                    stack.pollFirst();
                } else {
                    stack.offerFirst(cur.right);
                }
            } else {
                result.add(cur.key);
                stack.pollFirst();
            }
            pre = cur;
        }
        return result;
    }

    public static void main(String[] args) {
        Playground sol = new Playground();
        TreeNode root = TreeNode.fromLevelOrderSpecialOldVersion(new String[]{"12","#","-3","-4","-14","-5","#","16"});
        sol.postOrder(root);
    }
}
