// ======= DO NOT EDIT THIS FILE ============

class Node {

    Person info;
    Node next;

    Node(Person x, Node p) {
        info = x;
        next = p;
    }

    Node(Person x) {
        this(x, null);
    }
}