import java.util.EmptyStackException;
import java.util.Stack;

//Question1 vào sau ra đầu (LIFO)
//class StringStack {
//    private Node top; // Top of the stack
//    
//    // Node class to represent each element
//    class Node {
//        String data;
//        Node next;
//        
//        public Node(String data) {
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
//    public void push(String x) {
//        Node newNode = new Node(x);
//        newNode.next = top;
//        top = newNode;
//    }
//    
//    // 4. Pop the top element from the stack
//    public String pop() {
//        if (isEmpty()) {
//            throw new EmptyStackException();
//        }
//        String data = top.data;
//        top = top.next;
//        return data;
//    }
//    
//    // 5. Get the top element without removing it
//    public String top() {
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
//    //7 Method to convert a decimal number to binary using a stack
//    public static String convertToBinary(int decimal) {
//        Stack<Integer> stack = new Stack<>();
//        
//        // Edge case: if the number is 0, return "0"
//        if (decimal == 0) {
//            return "0";
//        }
//
//        // Convert the number to binary
//        while (decimal > 0) {
//            stack.push(decimal % 2); // Tương tự khi dùng đệ quy 
//            decimal /= 2; //
//        }
//
//        // Pop the stack and form the binary number
//        StringBuilder binary = new StringBuilder();
//        while (!stack.isEmpty()) {
//            binary.append(stack.pop()); // Append the bits in reverse order
//        }
//
//        return binary.toString();
//    }
//    
//    // Main method to test stack
//    public static void main(String[] args) {
//        StringStack stack = new StringStack();
//        
//        stack.push("apple");
//        stack.push("banana");
//        stack.push("cherry");
//        stack.traverse();
//        
//        System.out.println("Top of the stack: " + stack.top());
//        System.out.println("Popped: " + stack.pop());
//        System.out.println("Top of the stack: " + stack.top());
//        System.out.println("Popped: " + stack.pop());
//        System.out.println("After pop:");
//        stack.traverse();
//        
//        stack.clear();
//        System.out.println("Is stack empty? " + stack.isEmpty());
//    }
//}

//Question2 -> vào đầu ra đầu (FIFO)
class StringQueue {
    private Node front, rear; // Front and rear of the queue
    
    // Node class to represent each element
    class Node {
        String data;
        Node next;
        
        public Node(String data) {
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
    public void enqueue(String x) {
        Node newNode = new Node(x);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    
    // 4. Dequeue an element
    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        String data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }
    
    // 5. Get the first element without removing it
    public String first() {
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
        StringQueue queue = new StringQueue();
        
        queue.enqueue("apple");
        queue.enqueue("banana");
        queue.enqueue("cherry");
        
        queue.traverse();
        
        System.out.println("First in queue: " + queue.first());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("After dequeue:");
        queue.traverse();
        
        queue.clear();
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
