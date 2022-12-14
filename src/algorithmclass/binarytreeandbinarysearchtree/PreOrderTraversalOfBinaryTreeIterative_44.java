package algorithmclass.binarytreeandbinarysearchtree;

import utility.TreeNode;

import java.util.*;

public class PreOrderTraversalOfBinaryTreeIterative_44 {

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            // the left subtree should be traversed before right subtree,
            // since stack is LIFO, we should push right into the stack first,
            // so for the next step the top element of the stack is the left
            // subtree.
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            preorder.add(cur.key);
        }
        return preorder;
    }
}
