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
//==================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xMaker, int xVolume, int xColor) {

    if(xMaker.charAt(0)=='A' ) return;
    Bottle x = new Bottle(xMaker,xVolume, xColor);
    addLast(x);

   }
     void addLast(Bottle x) {
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
      void insert(Bottle x, int index) {
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
       void addFirst(Bottle x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }



    void addAfter(Node p, Bottle x) {
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
     Bottle x, y, z;
     x = new Bottle("X",1,2);
     y = new Bottle("Y",2,3);
     z = new Bottle("Z",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      insert(x, 1);
      insert(y, 2);
      insert(z, 4);

    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
public void ff3() {
    // Tìm node có tuổi lớn nhất
    Node maxNode = findMaxAge();
    
    // Tạo một bản sao của node có tuổi lớn nhất để chèn vào
    Node newNode = new Node(maxNode.info); // Giả sử Node có constructor nhận info làm tham số
    
    // Chèn bản sao này vào vị trí mong muốn, ví dụ: vị trí 1
    insert(newNode, 1);
    
    // Xóa node có tuổi lớn nhất ban đầu
    remove(maxNode);
}

void insert(Node node, int index) {
    if (node == null) return;  // Nếu node là null thì không chèn gì cả

    if (index <= 0) { // Trường hợp 1: Chèn vào đầu nếu index là 0 hoặc âm
        node.next = head;
        head = node;
        if (tail == null || tail.next == node) {
            tail = node;
        }
        return;
    }

    Node p = head;
    int count = 0;

    // Duyệt đến vị trí ngay trước vị trí cần chèn
    while (p != null && count < index - 1) {
        p = p.next;
        count++;
    }

    if (p == null) { // Trường hợp: Vị trí vượt quá chiều dài danh sách, thêm vào cuối
        if (tail != null) {
            tail.next = node;
            tail = node;
        } else { // Danh sách trống
            head = tail = node;
        }
    } else { // Trường hợp 2: Chèn vào giữa danh sách
        node.next = p.next;
        p.next = node;
        if (node.next == null) {
            tail = node;  // Cập nhật tail nếu chèn ở cuối
        }
    }
}

Node findMaxAge() {
    Node maxNode = this.head;
    Node currentNode = this.head;
    while (currentNode != null) {
        if (currentNode.info.color > maxNode.info.color) {
            maxNode = currentNode;
        }
        currentNode = currentNode.next;
    }
    return maxNode;
}

void remove(Node q) {
    if (q == null) {
        return;
    }
    if (q == head) { // Xóa node đầu tiên
        removeFirst();
        return;
    }

    // Tìm node trước node q
    Node fNode = head;
    while (fNode != null && fNode.next != q) {
        fNode = fNode.next;
    }
    if (fNode == null) { // Nếu q không có trong danh sách
        return;
    }

    // Xóa q khỏi danh sách
    fNode.next = q.next;
    if (fNode.next == null) {
        tail = fNode;
    }
}

void removeFirst() {
    if (isEmpty()) {
        return;
    }
    head = head.next;
    if (head == null) {
        tail = null;
    }
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
     ff3();
 
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }   

//==================================================================
  public void sortBeforePosition(int viTri) {
    if (head == null || viTri <= 0) {
        System.out.println("Danh sách trống hoặc vị trí không hợp lệ.");
        return; // Không có gì để sắp xếp
    }

    // Danh sách tạm để lưu các node trước viTri
    List<Node> nodeList = new ArrayList<>();
    Node current = head;
    int index = 0;

    // Lấy các node trước viTri
    while (current != null && index < viTri) {
        nodeList.add(current);
        current = current.next;
        index++;
    }

    // Sắp xếp danh sách tạm theo color sử dụng Bubble Sort (hoặc bạn có thể chọn thuật toán khác)
    for (int i = 0; i < nodeList.size() - 1; i++) {
        for (int j = 0; j < nodeList.size() - 1 - i; j++) {
            if (nodeList.get(j).info.color > nodeList.get(j + 1).info.color) {
                // Hoán đổi node
                Node temp = nodeList.get(j);
                nodeList.set(j, nodeList.get(j + 1));
                nodeList.set(j + 1, temp);
            }
        }
    }

    // Gán lại các node đã sắp xếp vào danh sách
    if (!nodeList.isEmpty()) {
        head = nodeList.get(0); // Đặt head là node đầu tiên trong danh sách đã sắp xếp
        Node last = head;

        for (int i = 1; i < nodeList.size(); i++) {
            last.next = nodeList.get(i);
            last = last.next;
        }

        // Kết nối node cuối cùng với node ở viTri
        if (current != null) {
            last.next = current; // Gắn node còn lại
        }
    }
}
  public void changeColor(int viTri, int newColor) {
      sortBeforePosition(viTri);
      Node node;
      node = getNode(viTri);
    if (node != null && node.info != null) { // Kiểm tra node và thông tin không null
        node.info.color = newColor; // Thay đổi màu sắc
    } else {
        System.out.println("Node or Bottle info is null.");
    }
}
     public Node getNode(int k) {
    int c = 0;
    Node p = head;
    while (p != null && c < k) {
        p = p.next;
        c++;
    }
    // Kiểm tra nếu c bằng k thì trả về node, nếu không trả về null
    return (c == k) ? p : null; 
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
      changeColor(5, 88);


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }

