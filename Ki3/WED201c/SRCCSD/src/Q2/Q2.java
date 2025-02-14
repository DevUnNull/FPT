/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

import java.io.RandomAccessFile;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class Q2 {
    --Insert
    void insert(Ball x) {
        Node q = new Node(x);
        if (root == null) {
            root = q;
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info.type == x.type) {
                return;
            }
            if (x.type < p.info.type) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (x.type < f.info.type) {
            f.left = q;
        } else {
            f.right = q;
        }
    }

    void insert(String xMaker, int xType, int xRadius) {
        if (xMaker.charAt(0) == 'B') {
            return;
        }
        Ball x = new Ball(xMaker, xType, xRadius);
        insert(x);
    }

    // -----------------------------------

  void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        //edit here
        if (p.info.radius < 5) {
            fvisit(p, f);
        }
//---------

----------------------

    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
       
        inOrder2(p.left, f);
        if(p.info.price < 7 )
        fvisit(p, f);
        inOrder2(p.right, f);
    }--------------------

    // xoa thang dau tien co 2 con , duyet theo in-order
    // type la so int
  int count = 0;

    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        if (p.left != null && p.right != null && count == 0) {
            count++;
            deleByCopy(p.info.type);

        }
        inOrder2(p.right, f);
    }

    void deleByCopy(int xPrice) {
        if (root == null) {
            System.out.println(" The tree is empty, no deletion");
            return;
        }
        Node f, p; // f will be the father of p
        p = root;
        f = null;
        while (p != null) {
            if (p.info.type == xPrice) {
                break;// Found key x
            }
            if (xPrice < p.info.type) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + xPrice + " does not exist, no deletion");
            return;
        }
        if (p.left == null && p.right == null) // p is a leaf node
        {
            if (f == null) // The tree is one node
            {
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }

        if (p.left != null && p.right == null) // p has only left child
        {
            if (f == null) // p is a root
            {
                root = p.left;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }

        if (p.left == null && p.right != null) // p has only right child
        {
            if (f == null) // p is a root
            {
                root = p.right;
            } else {
                if (f.left == p) // p is aleft child
                {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }

        if (p.left != null && p.right != null) // p has both left and right children
        {
            Node q, fr, rp; // p's key will be replaced by rp's one
            fr = null;
            q = p.left;
            rp = q;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right; // Find the right most node on the left sub-tree
            }
            p.info = rp.info;
            if (fr == null) // rp is just a left son of p
            {
                p.left = rp.left;
            } else {
                fr.right = rp.left;
            }
        }

    }

    // ------------------
    // Duyet in-order , p co 2 con , xoay trai p

    int count1 = 0;

    void inOrder3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder3(p.left, f);
        if (p.left != null && p.right != null && count1 == 0) {
            count1++;
            rotateLeft(p);

        }
        inOrder3(p.right, f);
    }

    Node parent(Node ch) {
        if (ch == root || ch == null) {
            return null;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.type == ch.info.type) {
                break;
            }
            parent = p;
            if (p.info.type > ch.info.type) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return parent;
    }

    void rotateLeft(Node par) {
        if (par == null || par.right == null) {
            return;
        }
        Node ch = par.right;
        par.right = ch.left;
        ch.left = par;
        if (parent(par) == null) {
            root = ch;
            return;
        }
        if (parent(par).left == par) {
            parent(par).left = ch;
        } else {
            parent(par).right = ch;
        }
    }

    // 1 cách làm khác
    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null)
            return;

        inOrder2(p.left, f);

        // Check if the price is within the range and visit the node
        if (p.info.price > 3 && p.info.price < 8) {
            fvisit(p, f);
        }

        inOrder2(p.right, f);
    }

    // -------------------------
    // xoa thang lon thu (count)

    int MaxAgeN(int n) {
        Node p = root;
        int max = -1;
        Queue q = new Queue();
        q.enqueue(root);

        if (n == 1) {
            while (!q.isEmpty()) {
                p = (Node) q.dequeue();
                if (p.info.color > max) {
                    max = p.info.color;
                }
                if (p.left != null) {
                    q.enqueue(p.left);
                }
                if (p.right != null) {
                    q.enqueue(p.right);
                }
            }
        } else {
            p = root;
            int maxN = MaxAgeN(n - 1);
            max = 0;
            while (!q.isEmpty()) {
                p = (Node) q.dequeue();
                if (p.info.color > max && p.info.color < maxN) {
                    max = p.info.color;
                }
                if (p.left != null) {
                    q.enqueue(p.left);
                }
                if (p.right != null) {
                    q.enqueue(p.right);
                }
            }
        }
        return max;
    }

    void deleByCopy(int xPrice) {
        if (root == null) {
            System.out.println(" The tree is empty, no deletion");
            return;
        }
        Node f, p; // f will be the father of p
        p = root;
        f = null;
        while (p != null) {
            if (p.info.color == xPrice) {
                break;// Found key x
            }
            if (xPrice < p.info.color) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + xPrice + " does not exist, no deletion");
            return;
        }
        if (p.left == null && p.right == null) // p is a leaf node
        {
            if (f == null) // The tree is one node
            {
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }

        if (p.left != null && p.right == null) // p has only left child
        {
            if (f == null) // p is a root
            {
                root = p.left;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }

        if (p.left == null && p.right != null) // p has only right child
        {
            if (f == null) // p is a root
            {
                root = p.right;
            } else {
                if (f.left == p) // p is aleft child
                {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }

        if (p.left != null && p.right != null) // p has both left and right children
        {
            Node q, fr, rp; // p's key will be replaced by rp's one
            fr = null;
            q = p.left;
            rp = q;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right; // Find the right most node on the left sub-tree
            }
            p.info = rp.info;
            if (fr == null) // rp is just a left son of p
            {
                p.left = rp.left;
            } else {
                fr.right = rp.left;
            }
        }

    }

    // ----------------------------
    // xoay trai thang parent cua thang lon nhat
    void max2() {
        if (isEmpty()) {
            return;
        }
        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        rotateL(parent(p));
    }

    public Node rotateL(Node par) {
        if (par == null) {
            return null;
        }
        if (par.left == null) {
            return null;
        }
        Node p = root;
        Node gr = null;
        while (p != null) {
            if (p == par) {
                break;
            }
            gr = p;
            if (p.info.color > par.info.color) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        Node ch = par.right;
        par.right = ch.left;
        ch.left = par;
        if (gr == null) {
            root = ch;
        } else if (gr.left == p) {
            gr.left = ch;
        } else if (gr.right == p) {
            gr.right = ch;
        }
        return ch;
    }

    Node parent(Node x) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.color == x.info.color) {
                break;
            }
            parent = p;
            if (p.info.color > x.info.color) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return parent;
    }

    // --------------------
    // xoay phai

    public void rotateRight(Node par) {
        Node p = root;
        Node gr = null;
        while (p != null) {
            if (p == par) {
                break;
            }
            gr = p;
            if (p.info.getName().compareToIgnoreCase(par.info.getName()) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (par.left == null) {
            return;
        }
        Node ch = par.left;
        par.left = ch.right;
        ch.right = par;
        if (gr == null) {
            root = ch;
        } else if (gr.left == p) {
            gr.left = ch;
        } else if (gr.right == p) {
            gr.right = ch;
        }
    }

    // 1 cách khác

    void breadth3(Node p, RandomAccessFile f) throws Exception {
        if (p == null)
            return;
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null && count == 0 && r.info.price < 7) {
                count++;
                rotateRight(r);
            }

            if (r.left != null)
                q.enqueue(r.left);
            if (r.right != null)
                q.enqueue(r.right);
        }
    }

    public void rotateRight(Node par) {
        Node p = root;
        Node gr = null;
        while (p != null) {
            if (p == par) {
                break;
            }
            gr = p;
            if (p.info.price > par.info.price) { // compare theo ten
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (par.left == null) {
            return;
        }
        Node ch = par.left;
        par.left = ch.right;
        ch.right = par;
        if (gr == null) {
            root = ch;
        } else if (gr.left == p) {
            gr.left = ch;
        } else if (gr.right == p) {
            gr.right = ch;
        }
    }

    // ----------------
    // xoa node thu may

    int count2 = 0;

    void preOrder4(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        count2++;
        if (count2 == 4) {
            deleByCopy(p.info.sound);
            return;
        }

        preOrder4(p.left, f);
        preOrder4(p.right, f);
    }

    void preOrder2(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
     if(p.info.price>3&&p.info.price<8)
      fvisit(p,f);
      preOrder2(p.left,f);
      preOrder2(p.right,f);
     }

    ---------------------------

    // xoay trai void
    public void rotateL(Node par) {

        Node p = root;
        Node gr = null;
        while (p != null) {
            if (p == par) {
                break;
            }
            gr = p;
            if (p.info.sound > par.info.sound) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        Node ch = par.right;
        par.right = ch.left;
        ch.left = par;
        if (gr == null) {
            root = ch;
        } else if (gr.left == p) {
            gr.left = ch;
        } else if (gr.right == p) {
            gr.right = ch;
        }

    }
    // Tim thang node thu 2 theo breadth va lay no lam goc , xoa thang lon nhat
    // trong cay subtree do

    void breadth2(Node p, RandomAccessFile f) throws Exception {
        int count = 0;
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null) {
                count++;
                if (count == 2) {
                    if (r.left == null && r.right == null) {
                        dele(r.info.depth);
                    } else {
                        dele(MaxN(r, 1)); // r la root cua sub-tree , n la lon thu bao nhieu
                    }
                }
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    int MaxN(Node p, int n) {
        int max = -1;
        Queue q = new Queue();
        q.enqueue(p);
        if (n == 1) {
            while (!q.isEmpty()) {
                p = (Node) q.dequeue();
                if (p.info.depth > max) {
                    max = p.info.depth;
                }
                if (p.left != null) {
                    q.enqueue(p.left);
                }
                if (p.right != null) {
                    q.enqueue(p.right);
                }
            }
        } else {
            int maxN = MaxN(p, n - 1);
            max = 0;
            while (!q.isEmpty()) {
                p = (Node) q.dequeue();
                if (p.info.depth > max && p.info.depth < maxN) {
                    max = p.info.depth;
                }
                if (p.left != null) {
                    q.enqueue(p.left);
                }
                if (p.right != null) {
                    q.enqueue(p.right);
                }
            }
        }
        return max;
    }

    void dele(int xDepth) {
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.depth == xDepth) {
                break;
            }
            parent = p;
            if (p.info.depth > xDepth) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            if (parent == null) {
                root = null;
                return;
            }
            if (parent.left == p) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        if ((p.left != null && p.right == null) || (p.left == null && p.right != null)) {
            if (p == root) {
                if (p.left != null) {
                    root = p.left;
                } else {
                    root = p.right;
                }
                return;
            }
            if (parent.left == p) {
                if (p.left != null) {
                    parent.left = p.left;
                } else {
                    parent.left = p.right;
                }
            } else {
                if (p.left != null) {
                    parent.right = p.left;
                } else {
                    parent.right = p.right;
                }
            }
        }
        if (p.left != null && p.right != null) {
            Node rm = p.left;
            Node parentRM = null;
            while (rm.right != null) {
                parentRM = rm;
                rm = rm.right;
            }
            p.info = rm.info;
            if (parentRM == null) {
                p.left = rm.left;
            } else {
                parentRM.right = rm.left;
            }
        }
    }

    -------------------------------

    // tim thang thu 2 con co trai duyet theo breath
 void breadth3(Node p, RandomAccessFile f) throws Exception {
        int count3 = 0;
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if(r.left != null ){
                
                count3++;
                if(count3 == 2){
                    rotateRight(r);//
                }
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    ----------------------

 public int getHeight(Node p) {
        if (p == null) {
            return 0;
        }
        return Math.max(getHeight(p.left), getHeight(p.right)) + 1;
    }

    -------------------// xoa thang cha cua thang node thu 4 duyet theo post-order
    // xoa thang thu chi chinh

    int count2 = 0;

    Node parent(Node x) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.wing == x.info.wing) {
                break;
            }
            parent = p;
            if (p.info.wing > x.info.wing) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return parent;
    }

    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null)
            return;
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        count2++;
        if (count2 == 4) { // xóa vị trí thứ 5
            dele(parent(p).info.wing);
        }
    }

    void dele(int xDepth) {
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.wing == xDepth) {
                break;
            }
            parent = p;
            if (p.info.wing > xDepth) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            if (parent == null) {
                root = null;
                return;
            }
            if (parent.left == p) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        if ((p.left != null && p.right == null) || (p.left == null && p.right != null)) {
            if (p == root) {
                if (p.left != null) {
                    root = p.left;
                } else {
                    root = p.right;
                }
                return;
            }
            if (parent.left == p) {
                if (p.left != null) {
                    parent.left = p.left;
                } else {
                    parent.left = p.right;
                }
            } else {
                if (p.left != null) {
                    parent.right = p.left;
                } else {
                    parent.right = p.right;
                }
            }
        }
        if (p.left != null && p.right != null) {
            Node rm = p.left;
            Node parentRM = null;
            while (rm.right != null) {
                parentRM = rm;
                rm = rm.right;
            }
            p.info = rm.info;
            if (parentRM == null) {
                p.left = rm.left;
            } else {
                parentRM.right = rm.left;
            }
        }
    }===================================================================

    Tim node thu 5
    khi duyet post-
    order.Dem so
    node cua seb-tree=
    k.
Gan gia
    tri k cho 1
    thuoc tinh

    /-----------------------------------------
    int count = 0;
    Node node3 = null;

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        // logic
        if (count == 4 && node3 == null) {
            node3 = p;
        }
        count++;
    }

    int countNode(Node pNode) {
        if (pNode == null) {
            return 0;
        }
        int k, h, rNode;
        k = countNode(pNode.left);
        h = countNode(pNode.right);
        rNode = k + h + 1;
        return rNode;
    }/-----------------------------------------
    // tìm gốc thứ 3 có nhanh bên phải
    /*
     * pre-order gốc trái phải
     * in-order trái gốc phải
     * post-order trái phải gốc
     */

    int rightChildCount =0;
    Node targetNode = null;

    public void findThirdNodeWithRightChildPreOrder(Node node) {
            if (node == null || targetNode != null) return;

            // duyện giữa
            if (node.right != null) { // nếu muốn có 2 con thì chỉ cần thêm node.right != null
                rightChildCount++;
                if (rightChildCount == 3) { // 3 la vi tri node cuar cay 
                    targetNode = node;
                    return;
                }
            }
            // duyệt trái 
            findThirdNodeWithRightChildPreOrder(node.left);
            // duyệt phải
            findThirdNodeWithRightChildPreOrder(node.right);
            if (targetNode != null) {
                int k = countSubtreeNodes(targetNode); // Đếm số lượng nút trong cây con
                if (k > 0) {
                    targetNode.info.volume = 100 + k; // Cập nhật volume
                }
            }
        }

    // Đếm số nút trong cây con có gốc là targetNode
    public int countSubtreeNodes(Node node) {
            if (node == null) return 0;
            return 1 + countSubtreeNodes(node.left) + countSubtreeNodes(node.right);
        }

    // --------------------------------------------------------------------------------------
    // duyệt theo breadthFist having 2 són and price < 7
public void breadthFirstHavingBoth2SonAndPrice(){
      
    Queue q = new Queue();
    q.enqueue(root);
    boolean deleted = false;
    while (!q.isEmpty() && !deleted) {
    Node r = q.dequeue();
    // Check if node has two children and price < 7
    if (r.left != null && r.right != null && r.info.price < 7) {
        deleByCopy(r.info.price);  // Delete by copying
        deleted = true;
    }
    // Enqueue children for breadth-first traversal
    if (r.left != null) q.enqueue(r.left);
    if (r.right != null) q.enqueue(r.right);
}
}

public void rotateRight(Node par) {
    Node p = root;
    Node gr = null;
    while (p != null) {
        if (p == par) {
            break;
        }
        gr = p;
        if (p.info.price > par.info.price) { // compare theo ten
            p = p.left;
        } else {
            p = p.right;
        }
    }
    if (par.left == null) {
        return;
    }
    Node ch = par.left;
    par.left = ch.right;
    ch.right = par;
    if (gr == null) {
        root = ch;
    } else if (gr.left == p) {
        gr.left = ch;
    } else if (gr.right == p) {
        gr.right = ch;
    }
}

    void breadth3(Node p, RandomAccessFile f) throws Exception {
        int count = 0;
        if (p == null)
            return;
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null && count == 0 && r.info.price < 7) {
                count++;
                rotateRight(r);
            }

            if (r.left != null)
                q.enqueue(r.left);
            if (r.right != null)
                q.enqueue(r.right);
        }
    }

    void deleByCopy(int xPrice) {
        if (root == null) {
            System.out.println(" The tree is empty, no deletion");
            return;
        }
        Node f, p; // f will be the father of p
        p = root;
        f = null;
        while (p != null) {
            if (p.info.price == xPrice) {
                break;// Found key x
            }
            if (xPrice < p.info.price) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + xPrice + " does not exist, no deletion");
            return;
        }
        if (p.left == null && p.right == null) // p is a leaf node
        {
            if (f == null) // The tree is one node
            {
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }

        if (p.left != null && p.right == null) // p has only left child
        {
            if (f == null) // p is a root
            {
                root = p.left;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }

        if (p.left == null && p.right != null) // p has only right child
        {
            if (f == null) // p is a root
            {
                root = p.right;
            } else {
                if (f.left == p) // p is aleft child
                {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }

        if (p.left != null && p.right != null) // p has both left and right children
        {
            Node q, fr, rp; // p's key will be replaced by rp's one
            fr = null;
            q = p.left;
            rp = q;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right; // Find the right most node on the left sub-tree
            }
            p.info = rp.info;
            if (fr == null) // rp is just a left son of p
            {
                p.left = rp.left;
            } else {
                fr.right = rp.left;
            }
        }

    }

    // -------------------------------------------------------------------------------------
    // find the first node p having left son and price < 7 . rotate p to right about
    // is left son
public void breadthFirstHavingLeftSon(){
    Queue q = new Queue();
    q.enqueue(root);
    boolean rotated = false;

    while (!q.isEmpty() && !rotated) {
        Node p = q.dequeue();

        // Check if the node has a left child and price < 7
        if (p.left != null && p.info.price < 7) {
            rotateRight(p);  // Perform right rotation on p about its left child
            rotated = true;
        }

        // Enqueue children for breadth-first traversal
        if (p.left != null) q.enqueue(p.left);
        if (p.right != null) q.enqueue(p.right);
    }

}