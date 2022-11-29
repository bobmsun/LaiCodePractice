package algorithmclass.binarytreeandbinarysearchtree;

import utility.*;

public class CheckIfBinaryTreeIsBalanced_46 {

    // Method 1: O(nlogn) algorithm for beginners
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // Method 2: better O(n) algorithm
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // use -1 to denote the tree is not balanced.
        // >= 0 value means the tree is balanced and it is the height of the tree.
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        // if left subtree is already not balanced, we do not need to continue
        // and we can return -1 directly.
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // if not balanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
