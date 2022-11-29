package algorithmclass.binarytreeandbinarysearchtree;

import utility.*;

public class InsertInBinarySearchTree_51 {

    // method 1: recursive
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    // method 2: iterative
    public TreeNode insertII(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        TreeNode cur = root;
        while (cur.key != key) {
            if (key < cur.key) {
                if (cur.left == null) {
                    cur.left = new TreeNode(key);
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(key);
                }
                cur = cur.right;
            }
        }
        return root;
    }
}
