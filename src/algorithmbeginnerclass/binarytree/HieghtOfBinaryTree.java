package algorithmbeginnerclass.binarytree;

import utility.TreeNode;

public class HieghtOfBinaryTree {

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
}
