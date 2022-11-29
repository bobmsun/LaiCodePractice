package algorithmclass.binarytreeandbinarysearchtree;

import utility.*;

public class HeightOfBinaryTree {

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
}
