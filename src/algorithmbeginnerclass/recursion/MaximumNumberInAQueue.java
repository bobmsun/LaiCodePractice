package algorithmbeginnerclass.recursion;
import java.util.Queue;

public class MaximumNumberInAQueue {

    public int maxInQueue(Queue<Integer> queue) {
        int max = queue.poll();
        while (!queue.isEmpty()) {
            max = Math.max(max, queue.poll());
        }
        return max;
    }
}
