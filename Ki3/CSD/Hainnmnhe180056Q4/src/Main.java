import java.util.EmptyStackException;

//Question1 FIFO (XỬ LÝ Ở TOP)
//class CharStack {
//    private Node top; // Top of the stack
//    
//    // Node class to represent each element
//    class Node {
//        char data;
//        Node next;
//        
//        public Node(char data) {
//            this.data = data;
//        }
//    }
//    
//    // 1. Check if stack is empty
//    public boolean isEmpty() {
//        return top == null;
//    }
//    
//    // 2. Clear the stack
//    public void clear() {
//        top = null;
//    }
//    
//    // 3. Push an element onto the stack
//    public void push(char x) {
//        Node newNode = new Node(x);
//        newNode.next = top;
//        top = newNode;
//    }
//    
//    // 4. Pop the top element from the stack
//    public char pop() {
//        if (isEmpty()) {
//            throw new EmptyStackException();
//        }
//        char data = top.data;
//        top = top.next;
//        return data;
//    }
//    
//    // 5. Get the top element without removing it
//    public char top() {
//        if (isEmpty()) {
//            throw new EmptyStackException();
//        }
//        return top.data;
//    }
//    
//    // 6. Traverse and display the stack
//    public void traverse() {
//        Node temp = top;
//        while (temp != null) {
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//    }
//
//    // 7. Convert decimal to binary using stack
//    public static String convertToBinary(int decimal) {
//        CharStack stack = new CharStack();
//        
//        if (decimal == 0) {
//            return "0";
//        }
//
//        // Convert decimal to binary
//        while (decimal > 0) {
//            stack.push((char) (decimal % 2 + '0')); // Tương tự khi dùng đệ quy 
//            decimal /= 2;
//        }
//
//        // Pop stack and form the binary string
//        StringBuilder binary = new StringBuilder();
//        while (!stack.isEmpty()) {
//            binary.append(stack.pop()); // vì đã return data (thoải mái)
//        }
//
//        return binary.toString();  // Overiding
//    }
//    
//    // Main method to test stack ok sure
//    public static void main(String[] args) {
//        CharStack stack = new CharStack();
//        
//        stack.push('a');
//        stack.push('b');
//        stack.push('c');
//        
//        stack.traverse(); // Output: c b a
//        
//        System.out.println("Top of the stack: " + stack.top()); // Output: c
//        System.out.println("Popped: " + stack.pop()); // Output: c
//        System.out.println("After pop:");
//        stack.traverse(); // Output: b a
//        
//        stack.clear();
//        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
//
//        // Test decimal to binary conversion
//        int decimalNumber = 25;
//        String binary = convertToBinary(decimalNumber);
//        System.out.println("Decimal: " + decimalNumber + " -> Binary: " + binary); // Output: 11001
//    }
//}

//Question2 FIFO (xử lý ở front)
class CharQueue {
    private Node front, rear; // Front and rear of the queue
    
    // Node class to represent each element
    class Node {
        char data;
        Node next;
        
        public Node(char data) {
            this.data = data;
        }
    }
    
    // 1. Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    
    // 2. Clear the queue
    public void clear() {
        front = rear = null;
    }
    
    // 3. Enqueue a new element
    public void enqueue(char x) {
        Node newNode = new Node(x);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    
    // 4. Dequeue an element
    public char dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        char data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }
    
    // 5. Get the first element without removing it
    public char first() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }
    
    // 6. Traverse and display the queue
    public void traverse() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    // Main method to test queue
    public static void main(String[] args) {
        CharQueue queue = new CharQueue();
        
        queue.enqueue('x');
        queue.enqueue('y');
        queue.enqueue('z');
        
        queue.traverse(); // Output: x y z
        
        System.out.println("First in queue: " + queue.first()); // Output: x
        System.out.println("Dequeued: " + queue.dequeue()); // Output: x
        System.out.println("After dequeue:");
        queue.traverse(); // Output: y z
        
        queue.clear();
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
    }
}
