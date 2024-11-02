/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Q1 {
    // replace thang lon thu n
    int MaxAgeN(int n) {
        Node p = head;
        int max = -1;
        if (n == 1) {
            max = p.info.type;
            while (p.next != null) {
                if (p.next.info.type > max) {
                    max = p.next.info.type;
                }
                p = p.next;
            }
        } else {
            p = head;
            int maxN = MaxAgeN(n - 1);
            while (p != null) {
                if (p.info.type < maxN) {
                    max = p.info.type;
                }
                p = p.next;
            }
            p = head;
            while (p.next != null) {
                if (p.next.info.type > max && p.next.info.type < maxN) {
                    max = p.next.info.type;
                }
                p = p.next;
            }
        }
        return max;
    }

    void max1(){
        int max = MaxAgeN(2);//edit here
        Node p = head;
        while(p!= null){
            if(max == p.info.type){
                p.info.place ="YY"; //edit here
                break;
            }
            p = p.next;
        }
    }

    ---------------------------------

    void addLast(Castor x) {// You should write here appropriate statements to complete this function.
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    void addLast(String xOwner, int xPrice) {// You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'B' || xPrice > 100)
            return;
        Car x = new Car(xOwner, xPrice);
        addLast(x);
    }
    // có các kiểu charAt như sau
    // 0 , .Owner.lengh()-1 , .statsWith("B") , ....

    void addFirst(Castor x) {
        head = new Node(x, head);
        if (tail == null)
            tail = head;
    }

    void addFirst(Castor x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

    void addAfter(Node p, Castor x) {
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

    void insert(Castor x, int index) {
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

    int max() {
        Node p = head;
        int max = head.info.depth;
        while (p != null) {
            if (max < p.info.depth)
                max = p.info.depth;
            p = p.next;
        }
        return max;
    }

    // sort

    void sort(int startIndex, int endIndex) {
        int count = 0, m = 0;
        Castor tmp;
        Node p = head, i;
        while (p.next != null) {
            if (count == startIndex) {
                for (; p != null; p = p.next) {
                    int n = 0;
                    for (i = p.next; i != null; i = i.next) {
                        if (p.info.type > i.info.type) {
                            tmp = p.info;
                            p.info = i.info;
                            i.info = tmp;
                        }
                        n++;
                        if (m + n == endIndex - startIndex) {
                            break;
                        }
                    }
                    if (m + 1 == endIndex - startIndex) {
                        break;
                    }
                    m++;
                }
                break;
            }
            count++;
            p = p.next;
        }
    }

    void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;// q is not found
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

    void dele(int xPrice) {
        int j = 0;
        Node p = head;
        while (p != null) {
            if (p.info.price < xPrice) {
                break;
            }
            p = p.next;
        }
        if (p != null) {
            dele(p);
        }
    }

    void dele(int xColor) { // xoa vi tri thu n muon xoa
    int count = 0;  // Đếm số node có color < xColor
    Node p = head;

    while (p != null) {
        if (p.info.color < xColor) {
            count++;
            if (count == 2) { // Nếu đây là node thứ hai
                dele(p); // Gọi hàm dele(Node q) để xóa node p
                break; // Dừng sau khi xóa
            }
        }
        p = p.next; // Duyệt tiếp node tiếp theo
    }
}---------------------

    void sortByPrice() {
        Node pi, pj;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.price > pj.info.price) {
                    Car temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // xoa tu duoi len theo gia tri va so luong xoa

    int size() { // đoạn code này có vẻ sai
        int size = 0;
        Node p = head;
        while (p.next != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    // sửa lại như sau
    int size() {
        int size = 0;
        Node p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;
        }
        return p;
    }

    void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;// q is not found
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

    // xóa node có 2 phần tử giống nhau
    public void removeTwoLastNodeCondition() {
        int c = 0;
        int sz = size();
        for (int i = sz - 1; i >= 0; i--) {
            Node p = getNode(i);
            if (p.info.price == 5) {
                c++;
                dele(p);
                if (c >= 1) {
                    break;
                }
            }
        }
    }

    // 1 code tương tự
    public void deleteFirstCondition(){
		Node p = head;
		while(p != null){
			if(p.info.price==5) {
                            dele(p);break;
                        }
			p=p.next;
		}
    }-----------------------------// repalce

 void Replace() {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.info.wing < 6) {
                count++;
                if (count == 2) {
                    p.info.rate = 99;
                }
            }
            p = p.next;
        }
    }--------------------// get tail (index last)

 int indexLast() {
        int index1 = 0;
        Node p = head;
        while (p.next != null) {
            index1++;
            p = p.next;
        }
        return index1;
    }----------------------------

 int MaxAgeN() {
        Node p = head;

        int index = 0;

        int max = p.info.wing;
        while (p.next != null) {
            if (p.next.info.wing > max) {
                max = p.next.info.wing;
            }
            p = p.next;
        }
        Node p1 = head;
        while (p1.next != null) {
            index++;
            if (p1.info.wing == max) {
                break;
            }
            p1 = p1.next;
        }

        return index;
    }

}

------------------------------------

public class MyList {

    Node head, tail;

    // (1)
    MyList() {
        head = tail = null;

    }

    // (2)
    boolean isEmpty() {
        return (head == null);
    }

    // (3)
    void clear() {
        head = tail = null;

    }

    // (4)
    void addLast(Person x) {
        Node qNode = new Node(x);
        if (isEmpty()) {
            head = tail = qNode;
            return;
        }
        tail.next = qNode;
        tail = qNode;

    }

    public Node findSecondNodeWithValue(int value) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (current.info.age == value) {
                count++;

                if (count == 2) {
                    return current;
                }
            }

            current = current.next;
        }

        return null;
    }

    // (5) display information of Node
    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    // (6) duyet tu dau den cuoi list
    void traverse() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.info);
            currentNode = currentNode.next;
        }

    }

    // (7) optional
    void addMany(String[] array, int[] b) {
        int n, i;
        n = array.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(array[i], b[i]));
        }
    }

    // (8)
    Node searchByName(String xName) {
        Node pNode = head;
        while (pNode != null) {
            if (pNode.info.name.equals(xName)) {
                return pNode;
            }
            pNode = pNode.next;
        }

        return null;
    }

    void removeSecondMaxAge() {
        // Tìm node có tuổi lớn nhất
        Node maxAgeNode = findMaxAge();
        if (maxAgeNode == null) {
            return; // Không tìm thấy node nào
        }
        int maxAge = maxAgeNode.info.age;
        Node current = head;
        int count = 0;
        Node secondMaxAgeNode = null;

        // Duyệt danh sách và đếm số node có tuổi lớn nhất
        while (current != null) {
            if (current.info.age == maxAge) {
                count++;
                if (count == 2) {
                    secondMaxAgeNode = current;
                    break;
                }
            }
            current = current.next;
        }

        // Nếu có ít nhất 2 node có tuổi lớn nhất, xóa node thứ hai
        if (count >= 2 && secondMaxAgeNode != null) {
            remove(secondMaxAgeNode);
        }
    }

    // (9)
    void addFirst(Person x) {
        Node currentNode = new Node(x);
        head = new Node(x, head);
        if (tail == null) {
            tail = currentNode;
        }
    }

    // (10)
    void insertAfter(Node q, Person x) {
        if (q == null) {
            return;

        }
        Node qNext = q.next;
        Node pNode = new Node(x, qNext);
        q.next = pNode;
        if (tail == q) { // insert sau Node tail
            // cap nhat lai tail
            tail = pNode;
        }

    }

    // (11)
    void insertBefore(Node q, Person x) {
        if (q == null) {
            return;
        }
        if (q == head) { // chen tuoc node Head
            // cap nhat lai head
            addFirst(x);
            return;
        }
        // tim node F truoc node q
        Node fNode = head;
        while (fNode != null && fNode.next != q) {
            fNode = fNode.next;
        }
        if (fNode == null) { // q khong co trong list
            return;

        }

        // insert after f
        insertAfter(fNode, x);

    }

    // (12)
    void remove(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) { // xoa not dau tien
            removeFirst();
            return;

        }
        // tim node F truoc node q
        Node fNode = head;
        while (fNode != null && fNode.next != q) {
            fNode = fNode.next;
        }
        if (fNode == null) { // q khong co trong list
            return;

        }
        // xoa q khoi list
        fNode.next = q.next;
        if (fNode.next == null) {
            tail = null;
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

    // (13)
    void remove(String xName) {
        Node pNode = searchByName(xName);
        remove(pNode);
    }

    // (14)
    void remove(int xAge) {
        Node pNode = searchByAge(xAge);
        remove(pNode);
    }

    // tìm số đầu tiên
    Node searchByAge(int xAge) {
        Node pNode = head;
        while (pNode != null) {
            if (pNode.info.age == xAge) {
                return pNode;
            }
            pNode = pNode.next;
        }

        return null;
    }

    // (15) xoa tat ca phan tu co xAge
    void removeAll(int xAge) {
        Node pNode;
        while (true) {
            pNode = searchByAge(xAge);
            if (pNode == null) {
                break;
            }
            remove(pNode);
        }
    }

    // (16) tim Node o vi tri thu k
    Node pos(int k) {
        int count = 0;
        Node pNode = head;
        while (pNode != null) {
            if (count == k) {
                return pNode;

            }
            count++;
            pNode = pNode.next;
        }

        return (null);
    }

    // (17)
    void removePos(int k) {
        Node pNode = pos(k);
        remove(pNode);
    }

    // (18)
    void sortByName() {
        Node piNode, pjNode;
        Person temp;
        piNode = head;
        while (piNode != null) {
            pjNode = piNode.next;
            while (pjNode != null) {
                if (piNode.info.name.compareTo(pjNode.info.name) > 0) {
                    temp = piNode.info;
                    piNode.info = pjNode.info;
                    pjNode.info = temp;
                }
                pjNode = pjNode.next;
            }
            piNode = piNode.next;
        }

    }

    // (19)
    void sortByAge() {
        Node piNode, pjNode;
        Person temp;
        piNode = head;
        while (piNode != null) {
            pjNode = piNode.next;
            while (pjNode != null) {
                if (piNode.info.age > pjNode.info.age) {
                    temp = piNode.info;
                    piNode.info = pjNode.info;
                    pjNode.info = temp;
                }
                pjNode = pjNode.next;
            }
            piNode = piNode.next;
        }

    }

    // (20)
    int size() {
        int count = 0;
        Node pNode = head;
        while (pNode != null) {
            count++;
            pNode = pNode.next;
        }
        return count;
    }

    // (21)
    Person[] toArray() {
        int n, i;
        n = size();
        Person[] persons = new Person[n];
        Node pNode = head;
        i = 0;
        while (pNode != null) {
            persons[i] = new Person(pNode.info.name, pNode.info.age);
            pNode = pNode.next;
            i++;
        }

        return (persons);
    }

    // (22)
    void reverse() {
        MyList tList = new MyList();
        Node pNode = head;
        while (pNode != null) {
            tList.addFirst(pNode.info);
            pNode = pNode.next;
        }
        head = tList.head;
        tail = tList.tail;
    }

    /**
     * cach lam reverse addlast xoa phan tu dau tien di lien tuc nhu vay
     */
    // (23) finding Node have max Age and return that Node
    // tìm ra node lớn nhất
    Node findMaxAge() {
        Node maxNode = this.head;
        Node currentNode = this.head;
        // loop from head to tail
        while (currentNode != null) {
            // if the age of Node have value higher than maxNode then assign maxNode = that
            // Node
            if (currentNode.info.age > maxNode.info.age) {
                maxNode = currentNode;
            }
            currentNode = currentNode.next;

        }
        return (maxNode);
    }

    // (24)
    Node findMinAge() {
        Node minNode = this.head;
        Node currentNode = this.head;
        while (currentNode != null) {
            if (minNode.info.age > currentNode.info.age) {
                minNode = currentNode;
            }
            currentNode = currentNode.next;
        }

        return (minNode);
    }

    // (24)
    void setData(Node p, Person x) {
        if (p != null) {
            p.info = x;
        }
    }

    // (26)
    void sortByAge(int k, int h) {
        if (k >= h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        int n = size();
        if (h > n - 1) {
            h = n - 1;
        }
        Node start = pos(k);
        Node end = pos(h + 1);
        Node pi, pj;
        Person temp;
        pi = start;
        while (pi != end) {
            pj = pi.next;
            while (pj != end) {
                if (pi.info.age > pj.info.age) {
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (27)
    void reverse(int k, int h) // reverse from k to h
    {
        // if (k >= h) {
        // return;
        // }
        // if (k < 0) {
        // return;
        // }
        // int n = size();
        // if (h > n - 1) {
        // return;
        // }
        // Person[] persons = toArray();
        // int i, j;
        // Person temp;
        // i = k;
        // j = h;
        // while (i < j) {
        // temp = persons[i];
        // persons[i] = persons[j];
        // persons[j] = temp;
        // i++;
        // j--;
        // }
        // clear();
        // for (i = 0; i < persons.length; i++) {
        // addLast(persons[i]);
        //
        // }
        if (k >= h) {
            return;
        }
        if (k < 0) {
            return;
        }
        int n = size();
        if (h > n - 1) {
            return;
        }
        Person[] a = toArray();
        int i, j;
        Person x;
        i = k;
        j = h;
        while (i < j) {
            x = a[i];
            a[i] = a[j];
            a[j] = x;
            i++;
            j--;
        }
        clear();
        for (i = 0; i < n; i++) {
            addLast(a[i]);
        }
    }

    // void reverse(int k, int h) // reverse from k to h
    // {
    // if (k >= h) {
    // return;
    // }
    // if (k < 0) {
    // return;
    // }
    // int n = size();
    // if (h > n - 1) {
    // return;
    // }
    // Person[] a = toArray();
    // int i, j;
    // Person x;
    // i = k;
    // j = h;
    // while (i < j) {
    // x = a[i];
    // a[i] = a[j];
    // a[j] = x;
    // i++;
    // j--;
    // }
    // clear();
    // for (i = 0; i < n; i++) {
    // addLast(a[i]);
    // }
    // }
}

    // Swap 2 node chỉ định

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

    // tìm 2 node chỉ đinh xong đổi chỗ
    public void findAndSwapNodes(String place1, String place2) {
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

        // Gọi hàm swapNodes để đổi chỗ hai node đã tìm thấy
        swapNodes(place1, place2);
    }

    // ----------------------------------------------
    // 19.1 sắp xếp trước kí tự chỉ định
    void sortByAge() {
        Node endNode = head;
        while (endNode != null && !endNode.info.place.equals("I")) {
            endNode = endNode.next;
        }
        Node piNode, pjNode;
        Brick temp;
        piNode = head;
        // nếu sắp xếp theo số
        while (piNode != null && piNode != endNode) {
            pjNode = piNode.next;
            while (pjNode != null && pjNode != endNode) {
                // So sánh price để sắp xếp (giả sử price là kiểu double)
                if (piNode.info.price > pjNode.info.price) {
                    // Hoán đổi thông tin giữa hai node
                    temp = piNode.info;
                    piNode.info = pjNode.info;
                    pjNode.info = temp;
                }
                pjNode = pjNode.next;
            }
            piNode = piNode.next;
        }
    }

    void sortByName() {
        // nếu sắp xếp theo chữ
        Node endNode = head;
        while (endNode != null && !endNode.info.place.equals("I")) {
            endNode = endNode.next;
        }
        Node piNode, pjNode;
        Brick temp;
        piNode = head;
        while (piNode != null && piNode != endNode) {
            pjNode = piNode.next;
            while (pjNode != null && pjNode != endNode) {
                // So sánh tên để sắp xếp
                if (piNode.info.place.compareTo(pjNode.info.place) > 0) {
                    // Hoán đổi thông tin giữa hai node
                    temp = piNode.info;
                    piNode.info = pjNode.info;
                    pjNode.info = temp;
                }
                pjNode = pjNode.next;
            }
            piNode = piNode.next;
        }
    }
    // ---------------------------------------------
    <<<<<<<HEAD

    // xóa node sau node lớn nhất
    public void RemoveAffterNode() {
        Node p = findMaxAge(); // gán node p thành node lớn nhất
        if (p.next == null) { // nếu p là node cuối thì không làm gì
            return;
        } else {
            remove(p.next); // p.next chính là node sau node lớn nhất
        }

    }
    // insertNode

    void insert(Node node, int index) {
        if (node == null)
            return; // Nếu node là null thì không chèn gì cả

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
                tail = node; // Cập nhật tail nếu chèn ở cuối
            }
        }
    }

    // ---------------------------------------------
    // getNode tự làm
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

    // --------------------------------------------------
    // changeColor thay đổi 1 thành phần nào đó trong node
    public void changeColor(int viTri, int newColor) {
        Node node;
        node = getNode(viTri);
        if (node != null && node.info != null) { // Kiểm tra node và thông tin không null
            node.info.color = newColor; // Thay đổi màu sắc
        } else {
            System.out.println("Node or Bottle info is null.");
        }
    }

    // ----------------------------------------------------
    // sắp xếp đến vị trí thứ bao nhiều là dừng
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
}>>>>>>>eb271ef8880fbe86e7a7c59a9ed799c2d359519a

    // ------------------------------------------------------------------------
    // xóa 1 phần tử rồi in nó ra vị trí bất kì
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
        if (node == null)
            return; // Nếu node là null thì không chèn gì cả

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
                tail = node; // Cập nhật tail nếu chèn ở cuối
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

    // -------------------------------------------------------------------------------
    // changenode chỉ định và sắp xếp các node trước đó
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

        // Sắp xếp danh sách tạm theo color sử dụng Bubble Sort (hoặc bạn có thể chọn
        // thuật toán khác)
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