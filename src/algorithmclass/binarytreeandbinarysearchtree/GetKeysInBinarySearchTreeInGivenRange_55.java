package algorithmclass.binarytreeandbinarysearchtree;

import java.util.*;
import utility.*;

public class GetKeysInBinarySearchTreeInGivenRange_55 {

    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> list = new ArrayList<Integer>();
        getRange(root, min, max, list);
        return list;
    }

    private void getRange(TreeNode root, int min, int max, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 1. determine if left subtree should be traversed, only when root.key >
        // min, we should traverse the left subtree.
        if (root.key > min) {
            getRange(root.left, min, max, list);
        }
        // 2. determine if root should be traversed.
        if (root.key >= min && root.key <= max) {
            list.add(root.key);
        }
        // 3. determine if right subtree should be traversed, only when
        //    root.key < max, we should traversed the right subtree.
        if (root.key < max) {
            getRange(root.right, min, max, list);
        }
    }
}
