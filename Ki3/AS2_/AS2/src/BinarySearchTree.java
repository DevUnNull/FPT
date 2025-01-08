
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // 1. isEmpty - Kiểm tra xem cây có rỗng hay không
    public boolean isEmpty() {
        return root == null;
    }

    // 2. clear - Xóa toàn bộ cây
    public void clear() {
        root = null;
    }

    // 3. search - Tìm kiếm một nút có giá trị x
    public Node search(int x) {
        return searchRec(root, x);
    }

    private Node searchRec(Node root, int x) {
        if (root == null || root.value == x) {
            return root;
        }
        if (root.value > x) {
            return searchRec(root.left, x);
        }
        return searchRec(root.right, x);
    }

    // 4. insert - Chèn một nút với giá trị x vào cây
    public void insert(int x) {
        root = insertRec(root, x);
    }

    private Node insertRec(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return root;
        }
        if (x < root.value) {
            root.left = insertRec(root.left, x);
        } else if (x > root.value) {
            root.right = insertRec(root.right, x);
        }
        return root;
    }

    // 5. breadth - Duyệt cây theo chiều rộng
    public void breadth() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    // 6. preorder - Duyệt cây theo thứ tự trước
    public void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // 7. inorder - Duyệt cây theo thứ tự giữa
    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    // 8. postorder - Duyệt cây theo thứ tự sau
    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    // 9. count - Đếm số nút trong cây
    public int count() {
        return countRec(root);
    }

    private int countRec(Node node) {
        if (node == null) return 0;
        return 1 + countRec(node.left) + countRec(node.right);
    }

    // 10. delete - Xóa nút có giá trị x
    public void delete(int x) {
        root = deleteRec(root, x);
    }

    private Node deleteRec(Node root, int x) {
        if (root == null) return root;
        if (x < root.value) {
            root.left = deleteRec(root.left, x);
        } else if (x > root.value) {
            root.right = deleteRec(root.right, x);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    // 11. min - Tìm và trả về giá trị nhỏ nhất trong cây
    public Node min() {
        return minRec(root);
    }

    private Node minRec(Node node) {
        if (node.left == null) return node;
        return minRec(node.left);
    }

    // 12. max - Tìm và trả về giá trị lớn nhất trong cây
    public Node max() {
        return maxRec(root);
    }

    private Node maxRec(Node node) {
        if (node.right == null) return node;
        return maxRec(node.right);
    }

    // 13. sum - Tính tổng các giá trị trong cây
    public int sum() {
        return sumRec(root);
    }

    private int sumRec(Node node) {
        if (node == null) return 0;
        return node.value + sumRec(node.left) + sumRec(node.right);
    }

    // 14. avg - Tính trung bình các giá trị trong cây
    public double avg() {
        int totalSum = sum();
        int totalNodes = count();
        if (totalNodes == 0) return 0;
        return (double) totalSum / totalNodes;
    }

    // 15. height - Tính chiều cao của cây
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    private int minValue(Node root) {
    int minv = root.value;
    while (root.left != null) {
        minv = root.left.value;
        root = root.left;
    }
    return minv;
}
    
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal: ");
        tree.inorder(tree.root);
    }
}