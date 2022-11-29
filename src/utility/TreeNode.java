package utility;

import java.util.*;

public class TreeNode {

    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }

    public TreeNode(int key, TreeNode left, TreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    // Print a tree (level order)
    public void print() {
        System.out.print("Tree: ");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                System.out.print(cur.key + " ");
                if (cur.left == null && cur.right == null) {
                    continue;
                }
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                System.out.print("# ");
            }
        }
        System.out.println();
    }

    // Build a tree from level-order traversal array, return root of the tree
    public static TreeNode fromLevelOrderSpecial(String[] array) {
       if (array == null || array.length == 0) {
           return null;
       }
       TreeNode root = new TreeNode(Integer.parseInt(array[0]));
       Queue<TreeNode> queue = new ArrayDeque<>();
       queue.offer(root);

       int i = 1;
       while (i < array.length) {
           TreeNode curParent = queue.poll();
           if (!array[i].equals("#")) {
               TreeNode curLeft = new TreeNode(Integer.parseInt(array[i]));
               curParent.left = curLeft;
               queue.offer(curLeft);
           }
           i++;
           if (!array[i].equals("#")) {
               TreeNode curRight = new TreeNode(Integer.parseInt(array[i]));
               curParent.right = curRight;
               queue.offer(curRight);
           }
           i++;
       }
       return root;
    }

    // Build a tree from level order, return root of the tree
    public static TreeNode fromLevelOrderSpecialOldVersion(String[] input) {
        if (input == null) {
            return null;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        q.offer(root);
        int i = 1;

        while (i < input.length) {
            TreeNode cur = q.peek();

            if (!input[i].equals("#")) {
                TreeNode curChild = new TreeNode(Integer.parseInt(input[i]));
                // i % 2 == 1 -> left child
                // i % 2 == 0 -> right child
                if (i % 2 == 1) {
                    cur.left = curChild;
                } else {
                    cur.right = curChild;
                }
                q.offer(curChild);
            }

            // i % 2 == 0 -> right child, poll
            if (i % 2 == 0) {
                q.poll();
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromLevelOrderSpecialOldVersion(new String[] {"1"});
        TreeNode root1 = TreeNode.fromLevelOrderSpecialOldVersion(new String[] {"1", "2", "3"});
        TreeNode root2 = TreeNode.fromLevelOrderSpecialOldVersion(new String[] {"1", "2", "3", "#", "4", "#", "5"});
        TreeNode root3 = TreeNode.fromLevelOrderSpecialOldVersion(new String[] {"1", "2", "#", "#", "4"});

        root.print();
        root1.print();
        root2.print();
        root3.print();
    }
}
