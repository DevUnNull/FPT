class MyList {
    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    // Display personal information (can be customized as needed)
    void displayYourInfo() {
        System.out.println("Full name: Your Name");
        System.out.println("Class: Class Name");
        System.out.println("ID Student: Student ID");
    }

    // Add a person to the end of the list
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    // Display the list
    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }

    // Add multiple persons from arrays
    void addMany(String[] names, int[] ages) {
        int n = names.length;
        for (int i = 0; i < n; i++) {
            addLast(new Person(names[i], ages[i]));
        }
    }

    // Search for a person by name
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // Add a person to the beginning of the list
    void addFirst(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        q.next = head;
        head = q;
    }

    // Insert a person after a specific node
    void insertAfter(Node q, Person x) {
        if (q == null) return;
        Node newNode = new Node(x);
        newNode.next = q.next;
        q.next = newNode;
        if (q == tail) tail = newNode;
    }

    // Insert a person before a specific node
    void insertBefore(Node q, Person x) {
        if (q == null || isEmpty()) return;
        if (q == head) {
            addFirst(x);
            return;
        }
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        if (p != null) {
            Node newNode = new Node(x);
            newNode.next = q;
            p.next = newNode;
        }
    }

    // Remove a specific node
    void remove(Node q) {
        if (isEmpty() || q == null) return;
        if (q == head) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }
        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }
        if (p != null) {
            p.next = q.next;
            if (q == tail) tail = p;
        }
    }

    // Remove a person by name
    void remove(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                remove(p);
                break;
            }
            p = p.next;
        }
    }

    // Remove a person by age
    void remove(int xAge) {
        Node p = head;
        while (p != null) {
            if (p.info.age == xAge) {
                remove(p);
                break;
            }
            p = p.next;
        }
    }

    // Remove all persons with a specific age
    void removeAll(int xAge) {
        Node p = head;
        while (p != null) {
            if (p.info.age == xAge) {
                remove(p);
            }
            p = p.next;
        }
    }

    // Get the node at position k
    Node pos(int k) {
        Node p = head;
        int count = 0;
        while (p != null && count < k) {
            p = p.next;
            count++;
        }
        return p;
    }

    // Remove the node at position k
    void removePos(int k) {
        Node p = pos(k);
        remove(p);
    }

    // Sort the list by name
    void sortByName() {
        if (isEmpty()) return;
        Node pi, pj;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.name.compareTo(pj.info.name) > 0) {
                    Person temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }

    // Sort the list by age
    void sortByAge() {
        if (isEmpty()) return;
        Node pi, pj;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.age > pj.info.age) {
                    Person temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }

    // Get the size of the list
    int size() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    // Convert the list to an array
    Person[] toArray() {
        int n = size();
        Person[] arr = new Person[n];
        Node p = head;
        int i = 0;
        while (p != null) {
            arr[i++] = p.info;
            p = p.next;
        }
        return arr;
    }

    // Reverse the list
    void reverse() {
        if (isEmpty()) return;
        Node prev = null, curr = head, next = null;
        tail = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find the node with maximum age
    Node findMaxAge() {
        if (isEmpty()) return null;
        Node p = head, max = head;
        while (p != null) {
            if (p.info.age > max.info.age) {
                max = p;
            }
            p = p.next;
        }
        return max;
    }

    // Find the node with minimum age
    Node findMinAge() {
        if (isEmpty()) return null;
        Node p = head, min = head;
        while (p != null) {
            if (p.info.age < min.info.age) {
                min = p;
            }
            p = p.next;
        }
        return min;
    }

    // Set data of a node
    void setData(Node p, Person x) {
        if (p != null) {
            p.info = x;
        }
    }

    // Sort by age from position k to h
    void sortByAge(int k, int h) {
        // Implementation left as an exercise
    }

    // Reverse from position k to h
    void reverse(int k, int h) {
        // Implementation left as an exercise
    }
}