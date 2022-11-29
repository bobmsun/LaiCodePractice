package algorithmclass.queueandstack;

import java.util.*;

public class SortWith2Stacks {

    public void sort(LinkedList<Integer> s1) {
        if (s1 == null || s1.size() == 0) {
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        sort(s1, s2);
    }

    private void sort(Deque<Integer> input, Deque<Integer> buffer) {
        // Method 1
        // input: unsorted elements
        // buffer: (top part), (bottom part) sorted elements
        // Step 1: sort in ascending order and store result in buffer
        while (!input.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while (!input.isEmpty()) {
                int cur = input.pollFirst();
                if (cur < curMin) {
                    curMin = cur;
                    count = 1;
                } else if (cur == curMin) {
                    count++;
                }
                buffer.offerFirst(cur);
            }
            while (!buffer.isEmpty() && buffer.peekFirst() >= curMin) {
                int tmp = buffer.pollFirst();
                if (tmp != curMin) {
                    input.offerFirst(tmp);
                }
            }
            while (count-- > 0) {
                buffer.offerFirst(curMin);
            }
        }
        // Step 2: move result from buffer to input, so it's in descending order
        while (!buffer.isEmpty()) {
            input.offerFirst(buffer.pollFirst());
        }
    }

    private void sort2(Deque<Integer> input, Deque<Integer> buffer) {
        // Method 2
        // sort in descending order and store result in the bottom part of the input
        int prevMax = Integer.MAX_VALUE;
        while (input.peekFirst() < prevMax) {
            int curMax = Integer.MIN_VALUE;
            int count = 0;
            while (!input.isEmpty() && input.peekFirst() < prevMax) {
                int cur = input.pollFirst();
                if (cur > curMax) {
                    curMax = cur;
                    count = 1;
                } else if (cur == curMax) {
                    count++;
                }
                buffer.offerFirst(cur);
            }
            while (count-- > 0) {
                input.offerFirst(curMax);
            }
            while (!buffer.isEmpty()) {
                int tmp = buffer.pollFirst();
                if (tmp != curMax) {
                    input.offerFirst(tmp);
                }
            }
            prevMax = curMax;
        }
    }
}
