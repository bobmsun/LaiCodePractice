package algorithmclass.binarytreeandbinarysearchtree;

import utility.TreeNode;

import java.util.*;

public class PostOrderTraversalOfBinaryTreeIterative_45 {

    // Method 1: post-order is the reverse order of pre-order with traversing
    // right subtree before traversing left subtree.
    public List<Integer> postOrderI(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> preOrder = new LinkedList<>();
        preOrder.offerFirst(root);
        while (!preOrder.isEmpty()) {
            TreeNode current = preOrder.pollFirst();
            // conduct the result for the special pre-order traversal.
            result.add(current.key);
            // in pre-order the right subtree will be traversed before the
            // left subtree so pushing left child first.
            if (current.left != null) {
                preOrder.offerFirst(current.left);
            }
            if (current.right != null) {
                preOrder.offerFirst(current.right);
            }
        }
        // reverse the pre-order traversal sequence to get the post-order result.
        Collections.reverse(result);
        return result;
    }

    // Method 2: check the relation between the current node and the previous node
    // to determine which direction should go next.
    public List<Integer> postOrderII(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        // to record the previous node on the way of DFS so that
        // we can determine the direction.
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            // if we are going down, either left/right direction.
            if (prev == null || cur == prev.left || cur == prev.right) {
                // if we cna still go down, try go left first.
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    // if we can not go either way, meaning cur is a leaf node.
                    stack.pollFirst();
                    result.add(cur.key);
                }
            } else if (prev == cur.right || prev == cur.left && cur.right == null) {
                // if we are going up from the right side or going up from the left side
                // but we can not go right afterwards.
                stack.pollFirst();
                result.add(cur.key);
            } else {
                // otherwise, we are going up from the left side and we can go down
                // right side.
                stack.offerFirst(cur.right);
            }
            prev = cur;
        }
        return result;
    }
}
