package algorithmclass.binarytreeandbinarysearchtree;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InOrderTraversalOfBinaryTreeIterative_43 {

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
       TreeNode cur = root;
       while (cur != null || !stack.isEmpty()) {
           // always try go to the left side to see if there is any node
           // should be traversed before the cur node, cur node is stored
           // on stack since it has not been traversed yet.
           if (cur != null) {
               stack.offerFirst(cur);
               cur = cur.left;
           } else {
               // if can not go left, meaning all the nodes on the left side of
               // the top node on stack have been traversed, the next traversing
               // node should be the top node on stack.
               cur = stack.pollFirst();
               inorder.add(cur.key);
               // the next subtree we want to traverse is cur.right.
               cur = cur.right;
           }
       }
       return inorder;
    }

}
