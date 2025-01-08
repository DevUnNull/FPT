package Dijkstra;

import java.util.*;

class MyQueue {

    LinkedList<Integer> t;

    MyQueue() {
        t = new LinkedList<Integer>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(Integer x) {
        t.addLast(x);
    }

    Integer dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    Integer front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}