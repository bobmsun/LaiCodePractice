package algorithmclass.heapandgraphsearch1bfs;

import utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Get_Keys_In_Binary_Tree_Layer_By_Layer_57 {

    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // the list storing all the nodes on the current level.
            List<Integer> curLayer = new ArrayList<Integer>();
            // the size of current level.
            int size = queue.size();
            // traverse all the nodes on the current level and
            // prepare for the next level.
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(curLayer);
        }
        return list;
    }
}
