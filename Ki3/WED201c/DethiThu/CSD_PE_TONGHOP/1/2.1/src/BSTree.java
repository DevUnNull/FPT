/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree
  {Node root;
   BSTree() {root=null;}
   boolean isEmpty()
      {return(root==null);
      }
   void clear()
      {root=null;
      }
   void fvisit(Node p, RandomAccessFile f) throws Exception
     {if(p != null) f.writeBytes(p.info + " ");
     }
   void preOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }
  void breadth(Node p, RandomAccessFile f) throws Exception
    {if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(Car x) {
        Node q = new Node(x);
        if (root == null) {
            root = q;
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info.price == x.price) {
                return;
            }
            if (x.price < p.info.price) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (x.price < f.info.price) {
            f.left = q;
        } else {
            f.right = q;
        }
    }
   
   void insert(String xOwner, int xPrice)
     {//You should insert here statements to complete this function
         if (xOwner.charAt(0) == 'B'||xPrice > 100) {
            return;
        }
        Car x = new Car(xOwner, xPrice);
        insert(x);
     }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
     inOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
  
//=============================================================
   void preOrder2(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
     if(p.info.price>=3&&p.info.price<=5)
      fvisit(p,f);
      preOrder2(p.left,f);
      preOrder2(p.right,f);
     }
  void f2() throws Exception
    {clear();
     loadData(4);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrder2(root, f);
  

    //------------------------------------------------------------------------------------
     f.writeBytes("\r\n");
     f.close();
    }  

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
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
          int count =0;
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
 
  void f3() throws Exception {
    clear();
     loadData(7);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      breadthFirstHavingBoth2SonAndPrice();
    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
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
 
  void f4() throws Exception
    {clear();
     loadData(10);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        breadthFirstHavingLeftSon();
    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

 }
