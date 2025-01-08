/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xPlace, int xPrice, int xType) {
    //You should write here appropriate statements to complete this function.
        if(xPlace.charAt(0)=='A' ) return;
    Brick x = new Brick(xPlace,xPrice,xType);
    addLast(x);
   }

     void addLast(Brick x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }
  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
      void insert(Brick x, int index) {
        int count = 0;
        Node p = head;
        while (p.next != null) {
            if (index == 0) {
                this.addFirst(x);
                break;
            }
            if (count == index - 1) {
                this.addAfter(p, x);
                break;
            }
            count++;
            p = p.next;
        }
    }
      void addFirst(Brick x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }



    void addAfter(Node p, Brick x) {
        Node p1 = new Node(x);
        if (isEmpty()) {
            return;
        }
        p1.next = p.next;
        p.next = p1;
        if (p == tail) {
            tail = p1;
        }
    }
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Brick x, y, z;
     x = new Brick("X",1,2);
     y = new Brick("Y",2,3);
     z = new Brick("Z",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      insert(x, 1);
      insert(y, 2);
      insert(z, 5);

    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
      public void findAndSwapNodes(String place1, String place2) {

    Node prev1 = null, curr1 = head;
    while (curr1 != null && !curr1.info.place.equals(place1)) {
        prev1 = curr1;
        curr1 = curr1.next;
    }
    Node prev2 = null, curr2 = head;
    while (curr2 != null && !curr2.info.place.equals(place2)) {
        prev2 = curr2;
        curr2 = curr2.next;
    }


    if (curr1 == null || curr2 == null) {
        System.out.println("Không tìm thấy một trong hai vị trí cần đổi.");
        return;
    }
    swapNodes(place1, place2);
}
      public void swapNodes(String place1, String place2) {
        if (place1.equals(place2)) {
            System.out.println("Hai vị trí trùng nhau, không cần đổi.");
            return;
        }

        // Tìm node chứa place1
        Node prev1 = null, curr1 = head;
        while (curr1 != null && !curr1.info.place.equals(place1)) {
            prev1 = curr1;
            curr1 = curr1.next;
        }

        // Tìm node chứa place2
        Node prev2 = null, curr2 = head;
        while (curr2 != null && !curr2.info.place.equals(place2)) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        // Nếu một trong hai node không tồn tại, dừng lại
        if (curr1 == null || curr2 == null) {
            System.out.println("Không tìm thấy một trong hai vị trí cần đổi.");
            return;
        }

        // Nếu curr1 hoặc curr2 là head, điều chỉnh lại head
        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            head = curr2;
        }

        if (prev2 != null) {
            prev2.next = curr1;
        } else {
            head = curr1;
        }

        // Đổi chỗ hai node
        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;
    }
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      findAndSwapNodes("E", "G");
 
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }   

//==================================================================
    void sortByAge(String name) {
    Node endNode = head;
    while (endNode != null && !endNode.info.place.equals(name)) {
        endNode = endNode.next;
    }
        Node piNode, pjNode;
        Brick temp;
        piNode = head;

while (piNode != null && piNode != endNode) {
        pjNode = piNode.next;
        while (pjNode != null && pjNode != endNode) {

            if (piNode.info.price > pjNode.info.price) {

                temp = piNode.info;
                piNode.info = pjNode.info;
                pjNode.info = temp;
            }
            pjNode = pjNode.next;
        }
        piNode = piNode.next;
    }
    }
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     sortByAge("I");


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }

