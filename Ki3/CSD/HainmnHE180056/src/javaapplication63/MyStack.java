
import java.util.LinkedList;

class MyStack {

    LinkedList<Integer> t;

    MyStack() {
        t = new LinkedList<>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void push(Integer x) {
        t.addFirst(x);
    }

    Integer pop() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    Integer top() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
