package algorithmclass.binarytreeandbinarysearchtree;

import java.util.*;
import utility.*;

public class InOrderTraversalOfBinaryTreeRecursive {

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.key);
        helper(root.right, res);
    }
}
