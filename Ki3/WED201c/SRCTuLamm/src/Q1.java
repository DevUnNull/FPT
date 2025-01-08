// Hàm tìm giá trị lớn nhất của thuộc tính `type` trong danh sách liên kết
// tương ứng với thứ tự `n` (tức là max lớn thứ n trong danh sách).
int MaxAgeN(int n) {
    // Khởi tạo con trỏ `p` trỏ đến `head` (nút đầu tiên của danh sách)
    Node p = head;
    
    // Khởi tạo biến `max` với giá trị -1, đây là giá trị mặc định cho max nếu không có phần tử nào
    int max = -1;
    
    // Kiểm tra nếu `n` là 1, nghĩa là tìm phần tử lớn nhất trong danh sách
    if (n == 1) {
        // Đặt `max` thành giá trị `type` của nút đầu tiên
        max = p.info.type;
        
        // Duyệt qua danh sách để tìm giá trị `type` lớn nhất
        while (p.next != null) {
            // Cập nhật `max` nếu tìm thấy giá trị `type` lớn hơn
            if (p.next.info.type > max) {
                max = p.next.info.type;
            }
            // Di chuyển đến nút tiếp theo
            p = p.next;
        }
    }
    else {
        // Nếu `n` không phải là 1, nghĩa là cần tìm giá trị max thứ `n`
        
        // Gọi đệ quy để tìm giá trị max lớn thứ `n-1`
        int maxN = MaxAgeN(n - 1);
        
        // Duyệt qua danh sách để tìm giá trị nhỏ hơn `maxN`
        while (p != null) {
            // Cập nhật `max` nếu tìm thấy giá trị `type` nhỏ hơn `maxN`
            if (p.info.type < maxN) {
                max = p.info.type;
            }
            // Di chuyển đến nút tiếp theo
            p = p.next;
        }
        
        // Đặt lại con trỏ `p` về `head` để bắt đầu duyệt lại từ đầu
        p = head;
        
        // Tìm giá trị lớn nhất nhỏ hơn `maxN` và lớn hơn `max`
        while (p.next != null) {
            // Nếu tìm thấy giá trị thỏa mãn điều kiện, cập nhật `max`
            if (p.next.info.type > max && p.next.info.type < maxN) {
                max = p.next.info.type;
            }
            // Di chuyển đến nút tiếp theo
            p = p.next;
        }
    }
    
    // Trả về giá trị max lớn thứ `n` tìm được
    return max;
}

// Hàm tìm giá trị lớn thứ 2 của thuộc tính `type` trong danh sách
// và gán thuộc tính `place` của nút đó là "YY"
void max1() {
    // Tìm giá trị lớn thứ 2 của thuộc tính `type` trong danh sách liên kết
    int max = MaxAgeN(2); // gọi hàm MaxAgeN với tham số 2 để tìm giá trị lớn thứ 2

    // Đặt con trỏ `p` trỏ đến `head` (nút đầu tiên trong danh sách)
    Node p = head;
    
    // Duyệt qua danh sách để tìm nút có giá trị `type` bằng với `max`
    while (p != null) {
        // Nếu tìm thấy nút có `type` bằng `max`, gán `place` của nút này là "YY"
        if (max == p.info.type) {
            p.info.place = "YY"; // gán giá trị "YY" cho thuộc tính `place`
            break; // dừng vòng lặp sau khi tìm thấy và cập nhật nút
        }
        // Di chuyển đến nút tiếp theo trong danh sách
        p = p.next;
    }
}

// Hàm thêm một nút chứa dữ liệu `Castor` vào cuối danh sách liên kết
void addLast(Castor x) {
    // Tạo một nút mới `q` chứa dữ liệu `x`
    Node q = new Node(x);
    
    // Kiểm tra nếu danh sách hiện tại rỗng
    if (isEmpty()) {
        // Nếu rỗng, gán cả `head` và `tail` đều trỏ đến `q`
        head = tail = q;
    } else {
        // Nếu danh sách không rỗng, thêm `q` vào cuối danh sách
        tail.next = q; // Gán `next` của `tail` hiện tại trỏ đến `q`
        tail = q;      // Cập nhật `tail` trỏ đến `q`, nút mới vừa thêm
    }
}

// Hàm thêm một đối tượng `Car` vào cuối danh sách liên kết,
// với điều kiện `xOwner` không bắt đầu bằng 'B' và `xPrice` không lớn hơn 100
void addLast(String xOwner, int xPrice) {
    // Kiểm tra điều kiện: nếu tên chủ xe bắt đầu bằng 'B' hoặc giá xe lớn hơn 100, kết thúc hàm
    if (xOwner.charAt(0) == 'B' || xPrice > 100) return;

    // Nếu điều kiện thỏa mãn, tạo đối tượng `Car` mới với `xOwner` và `xPrice`
    Car x = new Car(xOwner, xPrice);
    
    // Gọi phương thức `addLast` (phiên bản khác) để thêm đối tượng `Car` mới vào cuối danh sách
    addLast(x);
}

// 2 hàm addFirst không khác gì nhau 
// Hàm thêm một nút chứa dữ liệu `Castor` vào đầu danh sách liên kết
void addFirst(Castor x) {
    // Tạo một nút mới với dữ liệu `x` và liên kết `next` của nút này trỏ đến `head` hiện tại
    head = new Node(x, head);
    
    // Kiểm tra nếu danh sách đang rỗng (tức là `tail` bằng `null`)
    if (tail == null) {
        // Nếu danh sách rỗng, gán `tail` trỏ đến `head` (vì đây là nút đầu tiên và duy nhất)
        tail = head;
    }
}

// Hàm thêm một nút chứa dữ liệu `Castor` vào đầu danh sách liên kết
void addFirst(Castor x) {
    // Tạo một nút mới `p` với dữ liệu `x`
    Node p = new Node(x);
    
    // Kiểm tra nếu danh sách hiện tại rỗng
    if (isEmpty()) {
        // Nếu danh sách rỗng, gán cả `head` và `tail` đều trỏ đến `p`
        head = tail = p;
        return; // Kết thúc hàm vì đã thêm nút `p` vào danh sách rỗng
    }
    
    // Nếu danh sách không rỗng, đặt `next` của `p` trỏ đến `head` hiện tại
    p.next = head;
    
    // Cập nhật `head` trỏ đến `p`, biến `p` thành nút đầu tiên trong danh sách
    head = p;
}

// Hàm thêm một nút mới chứa dữ liệu `Castor` vào ngay sau nút `p`
void addAfter(Node p, Castor x) {
    // Tạo một nút mới `p1` với dữ liệu `x`
    Node p1 = new Node(x);

    // Kiểm tra nếu danh sách hiện tại rỗng
    if (isEmpty()) {
        // Nếu rỗng, không thể thêm sau `p`, kết thúc hàm
        return;
    }

    // Liên kết `next` của `p1` trỏ đến nút kế tiếp của `p`
    p1.next = p.next;

    // Cập nhật `next` của `p` để trỏ đến `p1`, chèn `p1` ngay sau `p`
    p.next = p1;

    // Kiểm tra nếu `p` là `tail` (tức là nút cuối cùng của danh sách)
    if (p == tail) {
        // Nếu `p` là `tail`, cập nhật `tail` trỏ đến `p1`, nút mới vừa thêm
        tail = p1;
    }
}

// Hàm chèn một nút chứa dữ liệu `Castor` vào vị trí `index` trong danh sách liên kết
void insert(Castor x, int index) {
    int count = 0; // Biến đếm để theo dõi vị trí hiện tại trong danh sách
    Node p = head; // Bắt đầu từ nút đầu tiên (head) của danh sách

    // Duyệt qua các nút trong danh sách cho đến khi `p.next` là null
    while (p != null) {
        // Nếu `index` là 0, chèn vào đầu danh sách bằng cách gọi `addFirst`
        if (index == 0) {
            this.addFirst(x);
            break; // Kết thúc vòng lặp sau khi đã chèn
        }
        
        // Nếu `count` đạt đến `index - 1`, gọi `addAfter` để chèn `x` sau nút `p`
        if (count == index - 1) {
            this.addAfter(p, x);
            break; // Kết thúc vòng lặp sau khi đã chèn
        }
        
        // Tăng biến đếm và di chuyển `p` đến nút tiếp theo
        count++;
        p = p.next;
    }
}

// Hàm tìm và trả về giá trị lớn nhất của thuộc tính `depth` trong danh sách liên kết
int max() {
    Node p = head; // Bắt đầu từ nút đầu tiên (head) của danh sách
    int max = head.info.depth; // Khởi tạo `max` với giá trị `depth` của nút đầu tiên

    // Duyệt qua tất cả các nút trong danh sách cho đến khi `p` trỏ đến null
    while (p != null) {
        // So sánh giá trị `depth` hiện tại với giá trị `max`
        if (max < p.info.depth) {
            max = p.info.depth; // Cập nhật `max` nếu giá trị hiện tại lớn hơn
        }
        p = p.next; // Di chuyển `p` đến nút tiếp theo
    }
    
    return max; // Trả về giá trị lớn nhất tìm được
}

// Hàm sắp xếp một phần của danh sách liên kết từ `startIndex` đến `endIndex`
void sort(int startIndex, int endIndex) {       
    int count = 0; // Biến đếm để theo dõi chỉ số hiện tại trong danh sách
    int m = 0; // Biến để theo dõi số lần lặp bên trong
    Castor tmp; // Biến tạm để hoán đổi dữ liệu
    Node p = head; // Bắt đầu từ nút đầu tiên (head) của danh sách
    Node i; // Khai báo một nút để duyệt trong vòng lặp

    // Duyệt qua các nút trong danh sách cho đến khi `p.next` là null
    while (p != null) {
        // Kiểm tra nếu `count` đạt đến `startIndex`
        if (count == startIndex) {
            // Sắp xếp từ `startIndex` đến `endIndex`
            for (; p != null; p = p.next) {
                int n = 0; // Biến đếm cho vòng lặp bên trong
                for (i = p.next; i != null; i = i.next) {
                    // Nếu `type` của nút hiện tại lớn hơn nút tiếp theo, hoán đổi chúng
                    if (p.info.type > i.info.type) {
                        tmp = p.info; // Lưu trữ giá trị hiện tại
                        p.info = i.info; // Đặt giá trị của nút tiếp theo vào nút hiện tại
                        i.info = tmp; // Gán lại giá trị đã lưu vào nút tiếp theo
                    }
                    n++; // Tăng biến đếm cho vòng lặp bên trong
                    // Kiểm tra xem đã sắp xếp đủ số phần tử chưa
                    if (m + n == endIndex - startIndex) {
                        break; // Thoát khỏi vòng lặp nếu đã sắp xếp đủ
                    }
                }
                // Nếu đã sắp xếp đủ số phần tử, thoát khỏi vòng lặp chính
                if (m + 1 == endIndex - startIndex) {
                    break; // Kết thúc việc sắp xếp
                }
                m++; // Tăng biến đếm bên ngoài
            }
            break; // Thoát khỏi vòng lặp chính sau khi sắp xếp xong
        }
        count++; // Tăng biến đếm cho vòng lặp chính
        p = p.next; // Di chuyển đến nút tiếp theo
    }
}

// Hàm xóa một nút cụ thể `q` khỏi danh sách liên kết
void dele(Node q) {
    Node f, p; // Khai báo hai nút: f (nút trước) và p (nút hiện tại)
    f = null; // Khởi tạo f là null
    p = head; // Bắt đầu từ nút đầu tiên (head) của danh sách

    // Duyệt qua danh sách để tìm nút `q`
    while (p != null) {
        if (p == q) { // Nếu tìm thấy nút `q`
            break; // Thoát vòng lặp
        }
        f = p; // Cập nhật f là nút hiện tại
        p = p.next; // Di chuyển p đến nút tiếp theo
    }

    // Nếu p là null, có nghĩa là không tìm thấy nút `q`
    if (p == null) {
        return; // Thoát khỏi hàm
    }

    // Nếu `q` là nút đầu tiên (head)
    if (f == null) {
        head = head.next; // Đặt head trỏ đến nút tiếp theo
        if (head == null) { // Nếu danh sách giờ rỗng
            tail = null; // Đặt tail cũng bằng null
        }
        return; // Kết thúc hàm
    }

    // Nếu `q` không phải là nút đầu tiên
    f.next = p.next; // Cập nhật nút trước f để bỏ qua nút p
    if (f.next == null) { // Nếu nút sau f là null, có nghĩa là `p` là nút cuối
        tail = f; // Cập nhật tail để trỏ đến nút f
    }
}

// Hàm xóa nút đầu tiên có giá nhỏ hơn xPrice
void dele(int xPrice) {
    Node p = head; // Bắt đầu từ nút đầu tiên (head) của danh sách

    // Duyệt qua danh sách để tìm nút đầu tiên có giá nhỏ hơn xPrice
    while (p != null) {
        // Nếu giá của nút hiện tại nhỏ hơn xPrice
        if (p.info.price < xPrice) {
            break; // Thoát vòng lặp
        }
        p = p.next; // Di chuyển p đến nút tiếp theo
    }

    // Nếu tìm thấy nút p không phải là null
    if (p != null) {
        dele(p); // Gọi hàm dele để xóa nút p
    }
}

// Hàm xóa nút thứ hai có màu nhỏ hơn xColor
void dele(int xColor) {
    int count = 0; // Đếm số nút có màu nhỏ hơn xColor
    Node p = head; // Bắt đầu từ nút đầu tiên (head) của danh sách

    // Duyệt qua danh sách để tìm nút thứ hai có màu nhỏ hơn xColor
    while (p != null) {
        // Nếu màu của nút hiện tại nhỏ hơn xColor
        if (p.info.color < xColor) {
            count++; // Tăng biến đếm
            // Nếu đây là nút thứ hai
            if (count == 2) {
                dele(p); // Gọi hàm dele(Node q) để xóa nút p
                break; // Thoát vòng lặp sau khi xóa
            }
        }
        p = p.next; // Di chuyển đến nút tiếp theo
    }
}

// Hàm sắp xếp danh sách theo giá của các đối tượng Car
void sortByPrice() {
    Node pi, pj; // Khai báo hai con trỏ Node
    pi = head; // Bắt đầu từ nút đầu tiên (head)

    // Duyệt qua từng nút trong danh sách
    while (pi != null) {
        pj = pi.next; // Đặt pj là nút tiếp theo của pi

        // Duyệt qua các nút tiếp theo để so sánh
        while (pj != null) {
            // Nếu giá của nút pi lớn hơn giá của nút pj
            if (pi.info.price > pj.info.price) {
                // Hoán đổi thông tin giữa hai nút
                Car temp = pi.info; // Lưu thông tin của nút pi vào temp
                pi.info = pj.info; // Gán thông tin của nút pj cho nút pi
                pj.info = temp; // Gán thông tin tạm thời (temp) cho nút pj
            }
            pj = pj.next; // Di chuyển pj đến nút tiếp theo
        }
        pi = pi.next; // Di chuyển pi đến nút tiếp theo
    }
}

// Hàm trả về kích thước của danh sách liên kết
int size() {
    int size = 0; // Khởi tạo biến đếm size
    Node p = head; // Bắt đầu từ nút đầu tiên (head)

    // Duyệt qua danh sách để đếm số nút
    while (p.next != null) {
        size++; // Tăng biến đếm size cho mỗi nút
        p = p.next; // Di chuyển đến nút tiếp theo
    }

    return size; // Trả về kích thước của danh sách
}


// Hàm trả về kích thước của danh sách liên kết
int size() {
    int size = 0;
    Node p = head;
    // Duyệt qua danh sách để đếm số nút
    while (p != null) {
        size++; // Tăng biến đếm size cho mỗi nút
        p = p.next; // Di chuyển đến nút tiếp theo
    }
    return size; // Trả về kích thước của danh sách
}

// Hàm trả về nút tại vị trí k trong danh sách liên kết
public Node getNode(int k) {
    if (k < 0) return null; // Kiểm tra nếu k không hợp lệ
    int c = 0;
    Node p = head;
    while (p != null && c < k) {
        p = p.next;
        c++;
    }
    return p; // Trả về nút tại vị trí k, hoặc null nếu không tìm thấy
}

// Hàm để xóa một nút q khỏi danh sách liên kết
void dele(Node q) {
    Node f, p; // Khai báo hai nút f (nút trước) và p (nút hiện tại)
    f = null; // Khởi tạo f là null, sẽ giữ nút trước p
    p = head; // Bắt đầu từ nút đầu tiên (head)

    // Duyệt qua danh sách để tìm nút q
    while (p != null) {
        if (p == q) { // Nếu tìm thấy nút q
            break; // Dừng vòng lặp
        }
        f = p; // Cập nhật f là nút hiện tại
        p = p.next; // Di chuyển đến nút tiếp theo
    }

    // Nếu p là null, nghĩa là không tìm thấy nút q
    if (p == null) {
        return; // Kết thúc hàm
    }

    // Nếu f là null, có nghĩa là q là nút đầu tiên (head)
    if (f == null) {
        head = head.next; // Cập nhật head để bỏ qua nút đầu tiên
        if (head == null) { // Nếu danh sách giờ trống
            tail = null; // Cập nhật tail thành null
        }
        return; // Kết thúc hàm
    }

    // Kết nối nút trước f với nút sau p để xóa nút q
    f.next = p.next; 
    // Nếu nút tiếp theo của f là null, nghĩa là nút p là nút cuối cùng
    if (f.next == null) {
        tail = f; // Cập nhật tail thành nút trước
    }
}

// Hàm để xóa tối đa hai nút cuối cùng có giá bằng 5 từ danh sách liên kết
public void removeTwoLastNodeCondition() {
    int c = 0; // Biến đếm số nút đã xóa
    int sz = size(); // Lấy kích thước của danh sách

    // Duyệt danh sách từ cuối đến đầu
    for (int i = sz - 1; i >= 0; i--) {
        Node p = getNode(i); // Lấy nút tại chỉ số i

        // Kiểm tra nếu giá của nút bằng 5
        if (p.info.price == 5) {
            c++; // Tăng biến đếm lên
            dele(p); // Xóa nút p

            // Nếu đã xóa đủ hai nút, dừng vòng lặp
            if (c >= 2) { // Chỉnh sửa từ 1 thành 2 để xóa tối đa 2 nút
                break; // Kết thúc vòng lặp
            }
        }
    }
}

// Hàm để thay đổi thuộc tính rate của nút thứ hai có wing < 6 thành 99
void Replace() {
    int count = 0; // Biến đếm số nút có wing < 6
    Node p = head; // Khởi tạo nút p tại đầu danh sách

    // Duyệt qua từng nút trong danh sách
    while (p != null) {
        // Kiểm tra xem thuộc tính wing có nhỏ hơn 6 không
        if (p.info.wing < 6) {
            count++; // Tăng biến đếm lên
            // Nếu đây là nút thứ hai thỏa mãn điều kiện
            if (count == 2) {
                p.info.rate = 99; // Thay đổi thuộc tính rate thành 99
            }
        }
        p = p.next; // Chuyển sang nút tiếp theo
    }
}

// Hàm để tìm chỉ số của nút cuối cùng trong danh sách liên kết
int indexLast() {
    int index1 = 0; // Khởi tạo biến để lưu chỉ số
    Node p = head; // Khởi tạo nút p tại đầu danh sách

    // Duyệt qua từng nút trong danh sách cho đến khi gặp nút cuối
    while (p.next != null) {
        index1++; // Tăng chỉ số lên
        p = p.next; // Chuyển đến nút tiếp theo
    }

    return index1; // Trả về chỉ số của nút cuối cùng
}

// Hàm để tìm chỉ số của nút có thuộc tính wing lớn nhất
int MaxAgeN() {
    Node p = head; // Khởi tạo nút p tại đầu danh sách
    int index = 0; // Biến để lưu chỉ số của nút
    int max = p.info.wing; // Khởi tạo max với giá trị wing của nút đầu tiên

    // Duyệt qua danh sách để tìm giá trị wing lớn nhất
    while (p.next != null) {
        if (p.next.info.wing > max) {
            max = p.next.info.wing; // Cập nhật max nếu tìm thấy wing lớn hơn
        }
        p = p.next; // Chuyển đến nút tiếp theo
    }

    Node p1 = head; // Khởi tạo nút p1 tại đầu danh sách
    while (p1.next != null) {
        index++; // Tăng chỉ số lên
        if (p1.info.wing == max) {
            break; // Nếu tìm thấy nút có wing = max, dừng vòng lặp
        }
        p1 = p1.next; // Chuyển đến nút tiếp theo
    }

    return index; // Trả về chỉ số của nút có wing lớn nhất
}








































































