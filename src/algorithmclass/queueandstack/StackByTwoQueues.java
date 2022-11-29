package algorithmclass.queueandstack;

import java.util.*;

public class StackByTwoQueues {

    private Queue<Integer> q;

    /** Initialize your data structure here. */
    public StackByTwoQueues() {
        q = new ArrayDeque<>();
    }

    /** Pushe element x onto stack. */
    public void push(int x) {
        q.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if (q.isEmpty()) {
            return null;
        }
        int size = q.size();
        while (--size != 0) {
            q.offer(q.poll());
        }
        return q.poll();
    }

    /** Get the top element. */
    public Integer top() {
        if (q.isEmpty()) {
            return null;
        }
        int ret = pop();
        q.offer(ret);
        return ret;
    }

    /** Returns whether the stack if empty. */
    public boolean isEmpty() {
        return q.isEmpty();
    }

}


// Follow up with additional assumptions:
// queue has only offer() and poll() operations;
// we cannot call  isEmpty(), peek(), size(), etc.
class StackByTwoQueues2 {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public StackByTwoQueues2() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        Integer prev = q1.poll();
        Integer cur = q1.poll();
        while (cur != null) {
            q2.offer(prev);
            prev = cur;
            cur = q1.poll();
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return prev;
    }

    /** Get the top element. */
    public Integer top() {
        Integer ret = pop();
        if (ret != null) {
            q1.offer(ret);
        }
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return top() == null;
    }
}