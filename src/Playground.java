import java.util.*;
import utility.*;

public class Playground {

    public boolean match(String input, String pattern) {
        // Write your solution here
        if (pattern.isEmpty()) {
            if (input.isEmpty()) {
                return true;
            }
            return false;
        }
        char[] inputArr = input.toCharArray();
        char[] patternArr = pattern.toCharArray();
        int inputIndex = 0;
        int patternIndex = 0;
        while (inputIndex < inputArr.length && patternIndex < patternArr.length) {
            if (patternArr[patternIndex] >= 'a' && patternArr[patternIndex] <= 'z') {
                if (inputArr[inputIndex] == patternArr[patternIndex]) {
                    inputIndex++;
                    patternIndex++;
                } else {
                    return false;
                }
            } else {
                int num = 0;
                while (patternIndex < patternArr.length && patternArr[patternIndex] >= '0' && patternArr[patternIndex] <= '9') {
                    num += 10 * num + (patternArr[patternIndex] - '0');
                    patternIndex++;
                }
                inputIndex += num;
                if (inputIndex > inputArr.length) {
                    return false;
                }
            }
        }
        if (patternIndex < patternArr.length || inputIndex < inputArr.length) {
            return false;
        }
        return true;
    }

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
        // TreeNode root = TreeNode.fromLevelOrderSpecialOldVersion(new String[]{"12","#","-3","-4","-14","-5","#","16"});
        //sol.postOrder(root);
        sol.match("laioffercom", "l10");
    }
}
