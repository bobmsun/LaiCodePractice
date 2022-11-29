package algorithmclass.queueandstack;

import java.util.*;

public class DequeByThreeStacks {

    private Deque<Integer> left;
    private Deque<Integer> right;
    private Deque<Integer> buffer;

    public DequeByThreeStacks() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst(int element) {
        left.offerFirst(element);
    }

    public void offerLast(int element) {
        right.offerFirst(element);
    }

    public Integer pollFirst() {
        move(right, left);
        return left.isEmpty() ? null : left.pollFirst();
    }

    public Integer pollLast() {
        move(left, right);
        return right.isEmpty() ? null : right.pollFirst();
    }

    public Integer peekFirst() {
        move(right, left);
        return left.isEmpty() ? null : left.peekFirst();
    }

    public Integer peekLast() {
        move(left, right);
        return right.isEmpty() ? null : right.peekFirst();
    }

    public int size() {
        return left.size() + right.size();
    }

    public boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    // when the destination stack is empty, move half of the elements fron
    // the source stack to the destination stack.
    private void move(Deque<Integer> src, Deque<Integer> dest) {
        if (!dest.isEmpty()) {
            return;
        }
        int halfSize = src.size() / 2;
        for (int i = 0; i < halfSize; i++) {
            buffer.offerFirst(src.pollFirst());
        }
        while (!src.isEmpty()) {
            dest.offerFirst(src.pollFirst());
        }
        while (!buffer.isEmpty()) {
            src.offerFirst(buffer.pollFirst());
        }
    }
}
