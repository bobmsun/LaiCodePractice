package algorithmclass.binarytreeandbinarysearchtree;

import utility.*;

public class SearchInBinarySearchTree_52 {

    // method 1: recursive
    public TreeNode search(TreeNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        return search(key < root.key ? root.left : root.right, key);
    }

    // method 2: iterative
    public TreeNode searchII(TreeNode root, int key) {
        TreeNode cur = root;
        while (cur != null && cur.key != key) {
            cur = key < cur.key ? cur.left : cur.right;
        }
        return cur;
    }

}
