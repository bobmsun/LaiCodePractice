import java.util.*;
import utility.*;

public class Playground {

    private Deque<Integer> first;
    private Deque<Integer> last;
    private Deque<Integer> buffer;

    public Playground() {
        // Write your solution here.
        first = new ArrayDeque<>();
        last = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst(int element) {
        first.offerFirst(element);
    }

    public void offerLast(int element) {
        last.offerFirst(element);
    }

    public Integer pollFirst() {
        shuffleIfNeeded(last, first);     // move numbers from last to first if needed
        return first.pollFirst();
    }

    public Integer pollLast() {
        shuffleIfNeeded(first, last);
        return last.pollFirst();
    }

    public Integer peekFirst() {
        Integer result = pollFirst();
        if (result == null) {
            return null;
        }
        first.offerFirst(result);
        return result;
    }

    public Integer peekLast() {
        Integer result = pollLast();
        if (result == null) {
            return null;
        }
        last.offerFirst(result);
        return result;
    }

    public int size() {
        return first.size() + last.size();
    }

    public boolean isEmpty() {
        return first.isEmpty() && last.isEmpty();
    }

    private void shuffleIfNeeded(Deque<Integer> from, Deque<Integer> to) {
        int size = from.size();
        for (int i = 0; i < size / 2; i++) {
            buffer.offerFirst(from.pollFirst());
        }
        while (!from.isEmpty()) {
            to.offerFirst(from.pollFirst());
        }
        while (!buffer.isEmpty()) {
            from.offerFirst(buffer.pollFirst());
        }
    }

    public static void main(String[] args) {
        Playground sol = new Playground();

    }
}
