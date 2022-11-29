package algorithmbeginnerclass.binarytree;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal_Recursive {

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.key);
        helper(root.left, res);
        helper(root.right, res);
    }
}
