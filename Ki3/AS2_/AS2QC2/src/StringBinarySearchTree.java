public class StringBinarySearchTree {
    StringNode root;

    public StringBinarySearchTree() {
        root = null;
    }

    // Chèn một chuỗi vào cây
    public void insert(String key) {
        root = insertRec(root, key);
    }

    private StringNode insertRec(StringNode root, String key) {
        if (root == null) {
            root = new StringNode(key);
            return root;
        }
        if (key.compareTo(root.value) < 0) {
            root.left = insertRec(root.left, key);
        } else if (key.compareTo(root.value) > 0) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Duyệt cây theo thứ tự giữa
    public void inorder(StringNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        StringBinarySearchTree tree = new StringBinarySearchTree();
        tree.insert("cat");
        tree.insert("dog");
        tree.insert("apple");
        tree.insert("zebra");
        tree.insert("bat");

        System.out.println("Inorder traversal of the tree: ");
        tree.inorder(tree.root);
    }
}