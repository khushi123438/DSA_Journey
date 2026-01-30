import java.util.*;

class FrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    private void balance() {
        if (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        } else if (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
        left.addLast(val);
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (isEmpty()) return -1;
        int res = left.isEmpty() ? right.removeFirst() : left.removeFirst();
        balance();
        return res;
    }

    public int popMiddle() {
        if (isEmpty()) return -1;
        int res = left.removeLast();
        balance();
        return res;
    }

    public int popBack() {
        if (isEmpty()) return -1;
        int res = !right.isEmpty() ? right.removeLast() : left.removeLast();
        balance();
        return res;
    }

    private boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }
}
