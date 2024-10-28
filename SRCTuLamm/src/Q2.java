// Hàm để chèn một đối tượng Ball vào cây nhị phân
void insert(Ball x) {
    Node q = new Node(x); // Tạo một nút mới q từ đối tượng Ball x

    // Nếu cây rỗng, gán nút mới làm root
    if (root == null) {
        root = q;
        return;
    }

    Node f, p;
    p = root; // Khởi tạo p tại nút root
    f = null; // Khởi tạo f (cha của nút p) là null

    // Duyệt cây để tìm vị trí chèn
    while (p != null) {
        // Nếu đã tồn tại một nút có cùng type, không làm gì và thoát
        if (p.info.type == x.type) {
            return;
        }

        // Nếu type của x nhỏ hơn type của p, chuyển sang nhánh trái
        if (x.type < p.info.type) {
            f = p; // Cập nhật nút cha f
            p = p.left; // Chuyển sang nhánh trái
        } else {
            f = p; // Cập nhật nút cha f
            p = p.right; // Chuyển sang nhánh phải
        }
    }

    // Chèn nút q vào vị trí phù hợp trong cây
    if (x.type < f.info.type) {
        f.left = q; // Nếu type nhỏ hơn, gán q là nút con trái của f
    } else {
        f.right = q; // Nếu type lớn hơn, gán q là nút con phải của f
    }
}

// Hàm để chèn một đối tượng Ball vào cây nhị phân từ các thuộc tính của nó
void insert(String xMaker, int xType, int xRadius) {
    // Kiểm tra nếu ký tự đầu tiên của xMaker là 'B', nếu đúng thì không thực hiện chèn
    if (xMaker.charAt(0) == 'B') {
        return; // Thoát khỏi hàm nếu điều kiện trên đúng
    }

    // Tạo một đối tượng Ball mới từ các tham số
    Ball x = new Ball(xMaker, xType, xRadius);
    insert(x); // Gọi hàm insert để chèn đối tượng Ball vào cây nhị phân
}

// Hàm duyệt cây nhị phân theo thứ tự sau và ghi thông tin vào tệp
void postOrder2(Node p, RandomAccessFile f) throws Exception {
    // Nếu nút hiện tại là null, thoát khỏi hàm
    if (p == null) {
        return; // Không làm gì nếu nút là null
    }

    // Duyệt cây con bên trái
    postOrder2(p.left, f);
    
    // Duyệt cây con bên phải
    postOrder2(p.right, f);

    // Ghi thông tin của nút vào tệp nếu điều kiện dưới đây thỏa mãn
    if (p.info.radius < 5) {
        fvisit(p, f); // Gọi hàm fvisit để ghi thông tin của nút vào tệp
    }
}

// Hàm duyệt cây nhị phân theo thứ tự trước và ghi thông tin vào tệp
void inOrder2(Node p, RandomAccessFile f) throws Exception {
    // Nếu nút hiện tại là null, thoát khỏi hàm
    if (p == null) {
        return; // Không làm gì nếu nút là null
    }
    
    // Duyệt cây con bên trái
    inOrder2(p.left, f);
    
    // Kiểm tra và ghi thông tin vào tệp nếu điều kiện dưới đây thỏa mãn
    if (p.info.price < 7) {
        fvisit(p, f); // Gọi hàm fvisit để ghi thông tin của nút vào tệp
    }
    
    // Duyệt cây con bên phải
    inOrder2(p.right, f);
}

int count =0;
// Hàm duyệt cây nhị phân theo thứ tự trước và xóa một nút nếu điều kiện được thỏa mãn
void inOrder2(Node p, RandomAccessFile f) throws Exception {
    // Nếu nút hiện tại là null, thoát khỏi hàm
    if (p == null) {
        return; // Không làm gì nếu nút là null
    }
    
    // Duyệt cây con bên trái
    inOrder2(p.left, f);
    
    // Kiểm tra và xóa nút nếu điều kiện dưới đây thỏa mãn
    if (p.left != null && p.right != null && count == 0) {
        count++; // Tăng biến đếm
        deleByCopy(p.info.type); // Gọi hàm deleByCopy để xóa nút
    }
    
    // Duyệt cây con bên phải
    inOrder2(p.right, f);
}

// Hàm xóa một nút trong cây nhị phân tìm kiếm bằng cách sao chép giá trị
void deleByCopy(int xPrice) {
    // Kiểm tra xem cây có rỗng không
    if (root == null) {
        System.out.println(" The tree is empty, no deletion");
        return; // Nếu cây rỗng, không có gì để xóa
    }

    Node f, p; // f là cha của p
    p = root; // Bắt đầu từ nút gốc
    f = null; // Không có cha ban đầu

    // Tìm kiếm nút cần xóa
    while (p != null) {
        if (p.info.type == xPrice) {
            break; // Đã tìm thấy nút với giá trị xPrice
        }
        // Di chuyển xuống cây
        if (xPrice < p.info.type) {
            f = p; // Cập nhật cha
            p = p.left; // Di chuyển sang con trái
        } else {
            f = p; // Cập nhật cha
            p = p.right; // Di chuyển sang con phải
        }
    }

    // Nếu không tìm thấy nút
    if (p == null) {
        System.out.println(" The key " + xPrice + " does not exist, no deletion");
        return; // Không có gì để xóa
    }

    // Trường hợp 1: p là nút lá (không có con)
    if (p.left == null && p.right == null) {
        if (f == null) { // Cây chỉ có một nút
            root = null; // Đặt gốc thành null
        } else {
            // Xóa nút p bằng cách cập nhật con của cha
            if (f.left == p) {
                f.left = null; // p là con trái của f
            } else {
                f.right = null; // p là con phải của f
            }
        }
        return; // Kết thúc hàm
    }

    // Trường hợp 2: p chỉ có con trái
    if (p.left != null && p.right == null) {
        if (f == null) { // p là gốc
            root = p.left; // Đặt gốc thành con trái của p
        } else {
            // Cập nhật con của cha f
            if (f.left == p) {
                f.left = p.left; // p là con trái của f
            } else {
                f.right = p.left; // p là con phải của f
            }
        }
        return; // Kết thúc hàm
    }

    // Trường hợp 3: p chỉ có con phải
    if (p.left == null && p.right != null) {
        if (f == null) { // p là gốc
            root = p.right; // Đặt gốc thành con phải của p
        } else {
            // Cập nhật con của cha f
            if (f.left == p) {
                f.left = p.right; // p là con trái của f
            } else {
                f.right = p.right; // p là con phải của f
            }
        }
        return; // Kết thúc hàm
    }

    // Trường hợp 4: p có cả hai con
    if (p.left != null && p.right != null) {
        Node q, fr, rp; // q là nút trái của p, fr là cha của rp
        fr = null; // Không có cha ban đầu cho rp
        q = p.left; // Bắt đầu từ con trái của p
        rp = q; // rp sẽ tìm nút phải nhất trong cây con trái

        // Tìm nút phải nhất trong cây con trái
        while (rp.right != null) {
            fr = rp; // Cập nhật cha
            rp = rp.right; // Di chuyển sang con phải
        }

        // Sao chép giá trị của rp vào p
        p.info = rp.info; // Sao chép giá trị
        // Xóa nút rp khỏi cây con trái
        if (fr == null) { // rp chỉ là con trái của p
            p.left = rp.left; // Cập nhật cây con trái
        } else {
            fr.right = rp.left; // Cập nhật con phải của fr
        }
    }
}

void inOrder3(Node p, RandomAccessFile f) throws Exception {
    // Nếu nút hiện tại là null, kết thúc hàm
    if (p == null) {
        return;
    }

    // Duyệt cây con trái
    inOrder3(p.left, f);

    // Nếu nút p có cả hai con và chưa thực hiện phép quay trái
    if (p.left != null && p.right != null && count1 == 0) {
        count1++; // Đánh dấu rằng đã thực hiện phép quay trái
        rotateLeft(p); // Thực hiện phép quay trái trên nút p
    }

    // Duyệt cây con phải
    inOrder3(p.right, f);
}

Node parent(Node ch) {
    // Nếu nút con là root hoặc nút con là null, không có nút cha nào
    if (ch == root || ch == null) {
        return null;
    }

    Node p = root; // Bắt đầu từ root
    Node parent = null; // Biến để lưu trữ nút cha

    // Duyệt cây để tìm nút cha của nút con ch
    while (p != null) {
        // Kiểm tra nếu tìm thấy nút con
        if (p.info.type == ch.info.type) {
            break;
        }
        parent = p; // Cập nhật nút cha
        // Di chuyển xuống cây
        if (p.info.type > ch.info.type) {
            p = p.left; // Di chuyển sang cây con trái
        } else {
            p = p.right; // Di chuyển sang cây con phải
        }
    }

    return parent; // Trả về nút cha
}

void rotateLeft(Node par) {
    // Kiểm tra xem nút cha có hợp lệ và có nút con bên phải không
    if (par == null || par.right == null) {
        return; // Không thể thực hiện quay nếu nút cha hoặc nút bên phải không tồn tại
    }

    Node ch = par.right; // Lưu trữ nút bên phải của nút cha
    par.right = ch.left; // Đặt nút bên trái của ch làm nút bên phải của par
    ch.left = par; // Đặt par làm nút bên trái của ch

    // Kiểm tra nếu par là root
    if (parent(par) == null) {
        root = ch; // Nếu par là root, cập nhật root thành ch
        return; // Kết thúc hàm
    }

    // Cập nhật nút cha của par
    if (parent(par).left == par) {
        parent(par).left = ch; // Nếu par là nút con trái
    } else {
        parent(par).right = ch; // Nếu par là nút con phải
    }
}

int MaxAgeN(int n) {
    Node p = root; // Khởi tạo nút p trỏ đến gốc cây
    int max = -1; // Khởi tạo biến max để lưu giá trị lớn nhất
    Queue q = new Queue(); // Khởi tạo hàng đợi để duyệt cây
    q.enqueue(root); // Đưa gốc cây vào hàng đợi

    // Nếu n là 1, tìm giá trị lớn nhất của color toàn bộ cây
    if (n == 1) {
        while (!q.isEmpty()) {
            p = (Node) q.dequeue(); // Lấy nút từ hàng đợi
            // Cập nhật giá trị lớn nhất
            if (p.info.color > max) {
                max = p.info.color;
            }
            // Đưa nút con trái vào hàng đợi
            if (p.left != null) {
                q.enqueue(p.left);
            }
            // Đưa nút con phải vào hàng đợi
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
    } else {
        // Nếu n > 1, gọi đệ quy để tìm maxN từ lần gọi trước
        p = root; // Đặt lại p trỏ đến gốc cây
        int maxN = MaxAgeN(n - 1); // Tìm giá trị lớn nhất từ lần gọi trước
        max = 0; // Khởi tạo lại giá trị max

        // Duyệt cây để tìm giá trị lớn nhất của color nhỏ hơn maxN
        while (!q.isEmpty()) {
            p = (Node) q.dequeue(); // Lấy nút từ hàng đợi
            // Cập nhật giá trị lớn nhất nếu thỏa mãn điều kiện
            if (p.info.color > max && p.info.color < maxN) {
                max = p.info.color;
            }
            // Đưa nút con trái vào hàng đợi
            if (p.left != null) {
                q.enqueue(p.left);
            }
            // Đưa nút con phải vào hàng đợi
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
    }
    return max; // Trả về giá trị lớn nhất tìm được
}

/**
 * Xóa nút trong cây nhị phân tìm kiếm dựa trên giá trị của thuộc tính color.
 *
 * @param xPrice Giá trị color của nút cần xóa.
 */
void deleByCopy(int xPrice) {
    // Kiểm tra xem cây có rỗng hay không
    if (root == null) {
        System.out.println(" The tree is empty, no deletion");
        return;
    }

    Node f, p; // f là cha của p
    p = root; // Khởi tạo p trỏ đến gốc cây
    f = null; // Khởi tạo f là null

    // Tìm nút p có giá trị color bằng xPrice
    while (p != null) {
        if (p.info.color == xPrice) {
            break; // Đã tìm thấy nút cần xóa
        }
        // Cập nhật f và p để tìm đúng vị trí
        if (xPrice < p.info.color) {
            f = p; // Cập nhật cha
            p = p.left; // Di chuyển sang cây con trái
        } else {
            f = p; // Cập nhật cha
            p = p.right; // Di chuyển sang cây con phải
        }
    }

    // Nếu không tìm thấy nút cần xóa
    if (p == null) {
        System.out.println(" The key " + xPrice + " does not exist, no deletion");
        return;
    }

    // Trường hợp 1: Nút p là nút lá (không có con)
    if (p.left == null && p.right == null) {
        if (f == null) { // Cây chỉ có một nút
            root = null; // Đặt gốc thành null
        } else {
            if (f.left == p) {
                f.left = null; // Xóa nút p khỏi cây
            } else {
                f.right = null; // Xóa nút p khỏi cây
            }
        }
        return;
    }

    // Trường hợp 2: Nút p có một con trái
    if (p.left != null && p.right == null) {
        if (f == null) { // Nếu p là gốc
            root = p.left; // Đặt gốc thành con trái
        } else {
            if (f.left == p) {
                f.left = p.left; // Cập nhật cha
            } else {
                f.right = p.left; // Cập nhật cha
            }
        }
        return;
    }

    // Trường hợp 3: Nút p có một con phải
    if (p.left == null && p.right != null) {
        if (f == null) { // Nếu p là gốc
            root = p.right; // Đặt gốc thành con phải
        } else {
            if (f.left == p) {
                f.left = p.right; // Cập nhật cha
            } else {
                f.right = p.right; // Cập nhật cha
            }
        }
        return;
    }

    // Trường hợp 4: Nút p có cả hai con
    if (p.left != null && p.right != null) {
        Node q, fr, rp; // q là nút con trái, rp là nút thay thế
        fr = null; // Khởi tạo cha của nút thay thế
        q = p.left; // Bắt đầu từ con trái
        rp = q;

        // Tìm nút phải cùng cực nhất trong cây con trái
        while (rp.right != null) {
            fr = rp; // Cập nhật cha của rp
            rp = rp.right; // Di chuyển sang phải
        }

        // Sao chép giá trị từ nút rp vào nút p
        p.info = rp.info; 
        // Xóa nút thay thế (rp) khỏi cây
        if (fr == null) { // Nếu rp là con trái của p
            p.left = rp.left; // Cập nhật con trái của p
        } else {
            fr.right = rp.left; // Cập nhật cha của rp
        }
    }
}

/**
 * Tìm nút có giá trị lớn nhất trong cây nhị phân tìm kiếm 
 * và thực hiện phép xoay trái tại cha của nút đó.
 */
void max2() {
    // Kiểm tra xem cây có rỗng hay không
    if (isEmpty()) {
        return; // Nếu cây rỗng, không làm gì cả
    }

    Node p = root; // Bắt đầu từ nút gốc
    // Di chuyển đến nút bên phải cùng cực (nút lớn nhất)
    while (p.right != null) {
        p = p.right; // Di chuyển đến nút bên phải
    }

    // Thực hiện phép xoay trái tại nút cha của nút lớn nhất
    rotateL(parent(p));
}


/**
 * Thực hiện phép xoay trái tại nút `par`.
 * 
 * @param par Nút cha cần thực hiện phép xoay trái.
 * @return Nút mới trở thành cha sau phép xoay.
 */
public Node rotateL(Node par) {
    // Kiểm tra xem nút `par` có phải là null không
    if (par == null) {
        return null; // Nếu nút không tồn tại, trả về null
    }
    // Kiểm tra xem `par` có nút con bên trái không
    if (par.left == null) {
        return null; // Nếu không có nút con bên trái, không thực hiện phép xoay
    }

    Node p = root; // Bắt đầu từ nút gốc
    Node gr = null; // `gr` là nút ông (ông nội) của nút `par`
    
    // Tìm nút cha của `par`
    while (p != null) {
        if (p == par) {
            break; // Nếu tìm thấy nút `par`, thoát vòng lặp
        }
        gr = p; // Cập nhật nút ông
        // So sánh màu của nút để di chuyển về bên trái hoặc bên phải
        if (p.info.color > par.info.color) {
            p = p.left; // Di chuyển sang trái
        } else {
            p = p.right; // Di chuyển sang phải
        }
    }

    Node ch = par.right; // Nút con bên phải của `par`
    par.right = ch.left; // Cập nhật con bên phải của `par` thành con bên trái của `ch`
    ch.left = par; // Đặt `par` là con trái của `ch`
    
    // Cập nhật cấu trúc cây
    if (gr == null) {
        root = ch; // Nếu `par` là nút gốc, cập nhật gốc cây
    } else if (gr.left == p) {
        gr.left = ch; // Nếu `par` là con trái của `gr`, cập nhật con trái của `gr`
    } else if (gr.right == p) {
        gr.right = ch; // Nếu `par` là con phải của `gr`, cập nhật con phải của `gr`
    }

    return ch; // Trả về nút mới trở thành cha
}


/**
 * Tìm nút cha của nút `x` trong cây nhị phân.
 * 
 * @param x Nút mà bạn muốn tìm nút cha.
 * @return Nút cha của `x`, hoặc null nếu `x` không tồn tại hoặc là gốc.
 */
Node parent(Node x) {
    Node p = root; // Bắt đầu từ nút gốc
    Node parent = null; // Khởi tạo biến để lưu trữ nút cha

    // Duyệt qua cây để tìm nút cha của `x`
    while (p != null) {
        // Kiểm tra xem nút `p` có phải là nút `x` không
        if (p.info.color == x.info.color) {
            break; // Nếu tìm thấy, thoát vòng lặp
        }
        parent = p; // Cập nhật biến `parent` thành `p`
        
        // So sánh màu của nút để di chuyển về bên trái hoặc bên phải
        if (p.info.color > x.info.color) {
            p = p.left; // Nếu màu của `p` lớn hơn màu của `x`, di chuyển sang trái
        } else {
            p = p.right; // Ngược lại, di chuyển sang phải
        }
    }
    return parent; // Trả về nút cha, hoặc null nếu không tìm thấy
}


/**
 * Thực hiện phép xoay phải trên nút `par` trong cây nhị phân.
 * 
 * @param par Nút mà bạn muốn thực hiện phép xoay phải.
 */
public void rotateRight(Node par) {
    Node p = root; // Bắt đầu từ nút gốc
    Node gr = null; // Biến lưu trữ nút ông (grandparent) của `par`

    // Tìm nút `par` trong cây
    while (p != null) {
        if (p == par) {
            break; // Nếu tìm thấy nút `par`, thoát vòng lặp
        }
        gr = p; // Cập nhật nút ông là nút `p`
        
        // So sánh tên của nút để di chuyển sang trái hoặc phải
        if (p.info.getName().compareToIgnoreCase(par.info.getName()) > 0) {
            p = p.left; // Di chuyển sang trái nếu tên của `p` lớn hơn tên của `par`
        } else {
            p = p.right; // Ngược lại, di chuyển sang phải
        }
    }

    // Nếu không có nút con bên trái, không thể thực hiện phép xoay
    if (par.left == null) {
        return; 
    }

    // Thực hiện phép xoay phải
    Node ch = par.left; // `ch` là nút con bên trái của `par`
    par.left = ch.right; // Chuyển nút con bên phải của `ch` thành nút con bên trái của `par`
    ch.right = par; // Đặt `par` làm nút con bên phải của `ch`

    // Cập nhật cấu trúc cây
    if (gr == null) {
        root = ch; // Nếu `par` là gốc, cập nhật gốc mới
    } else if (gr.left == p) {
        gr.left = ch; // Nếu `par` là con trái của ông, cập nhật con trái
    } else if (gr.right == p) {
        gr.right = ch; // Nếu `par` là con phải của ông, cập nhật con phải
    }
}


/**
 * Duyệt cây nhị phân theo thứ tự trước và xóa nút thứ 4.
 *
 * @param p Nút hiện tại trong cây.
 * @param f Tệp RandomAccessFile để lưu trữ thông tin (nếu cần).
 * @throws Exception Nếu có lỗi trong quá trình ghi vào tệp.
 */
void preOrder4(Node p, RandomAccessFile f) throws Exception {
    // Nếu nút hiện tại là null, dừng lại
    if (p == null) {
        return;
    }

    count2++; // Tăng biến đếm số lượng nút đã duyệt

    // Khi đã duyệt đến nút thứ 4, gọi hàm xóa và kết thúc duyệt
    if (count2 == 4) {
        deleByCopy(p.info.sound); // Xóa nút hiện tại bằng giá trị sound
        return; // Kết thúc hàm sau khi xóa
    }

    // Tiếp tục duyệt cây theo thứ tự trước
    preOrder4(p.left, f); // Duyệt cây con bên trái
    preOrder4(p.right, f); // Duyệt cây con bên phải
}

/**
 * Thực hiện phép xoay trái tại nút đã cho trong cây nhị phân.
 *
 * @param par Nút cần thực hiện phép xoay trái.
 */
public void rotateL(Node par) {
    
    Node p = root; // Khởi tạo nút hiện tại là root
    Node gr = null; // Khởi tạo biến grandparent là null

    // Tìm nút cha (parent) của nút par
    while (p != null) {
        if (p == par) {
            break; // Đã tìm thấy nút par
        }
        gr = p; // Lưu trữ nút hiện tại như là grandparent
        if (p.info.sound > par.info.sound) {
            p = p.left; // Di chuyển sang cây con bên trái nếu giá trị nhỏ hơn
        } else {
            p = p.right; // Di chuyển sang cây con bên phải nếu giá trị lớn hơn
        }
    }

    // Thực hiện phép xoay trái
    Node ch = par.right; // Nút con bên phải của par
    par.right = ch.left; // Đặt cây con bên trái của ch làm cây con bên phải của par
    ch.left = par; // Đặt par làm cây con bên trái của ch

    // Cập nhật cha của par
    if (gr == null) {
        root = ch; // Nếu par là root, cập nhật root thành ch
    } else if (gr.left == p) {
        gr.left = ch; // Nếu par là con trái của grandparent, cập nhật con trái
    } else if (gr.right == p) {
        gr.right = ch; // Nếu par là con phải của grandparent, cập nhật con phải
    }
}

/**
 * Duyệt cây theo chiều rộng và thực hiện phép xóa trên nút thỏa mãn điều kiện nhất định.
 *
 * @param p Nút gốc của cây nhị phân.
 * @param f Tệp để ghi thông tin (có thể dùng để lưu trữ, nhưng chưa rõ trong mã này).
 * @throws Exception nếu có lỗi khi thao tác với tệp.
 */
void breadth2(Node p, RandomAccessFile f) throws Exception {
    int count = 0; // Khởi tạo biến đếm để theo dõi số lượng nút con bên trái
    if (p == null) {
        return; // Nếu nút gốc là null, không làm gì
    }
    
    Queue q = new Queue(); // Khởi tạo hàng đợi để duyệt cây
    q.enqueue(p); // Thêm nút gốc vào hàng đợi
    Node r; // Biến tạm để lưu nút hiện tại

    // Duyệt cây theo chiều rộng
    while (!q.isEmpty()) {
        r = q.dequeue(); // Lấy nút đầu tiên ra khỏi hàng đợi
        
        // Kiểm tra nút con bên trái của nút hiện tại
        if (r.left != null) {
            count++; // Tăng đếm khi tìm thấy nút con bên trái

            // Nếu đếm đến 2, thực hiện phép xóa
            if (count == 2) {
                // Nếu nút con trái không có con nào thì xóa nút hiện tại
                if (r.left == null && r.right == null) {
                    dele(r.info.depth); // Xóa theo độ sâu
                } else {
                    // Nếu có nút con, xóa nút lớn nhất trong cây con bên trái
                    dele(MaxN(r, 1)); // r là root của sub-tree, 1 là độ sâu
                }
            }
        }

        // Thêm các nút con vào hàng đợi để tiếp tục duyệt
        if (r.left != null) {
            q.enqueue(r.left); // Thêm nút con trái vào hàng đợi
        }
        if (r.right != null) {
            q.enqueue(r.right); // Thêm nút con phải vào hàng đợi
        }
    }
}


/**
 * Tìm giá trị lớn nhất của thuộc tính depth trong cây nhị phân.
 *
 * @param p Nút gốc của cây hoặc cây con mà cần tìm kiếm.
 * @param n Độ sâu hiện tại (1 cho toàn bộ cây, >1 cho cây con ở độ sâu n).
 * @return Giá trị lớn nhất của depth trong cây.
 */
int MaxN(Node p, int n) {
    int max = -1; // Khởi tạo biến max với giá trị nhỏ nhất
    Queue q = new Queue(); // Khởi tạo hàng đợi để duyệt cây
    q.enqueue(p); // Thêm nút gốc vào hàng đợi

    // Nếu n bằng 1, tìm giá trị lớn nhất trong toàn bộ cây
    if (n == 1) {
        while (!q.isEmpty()) {
            p = (Node) q.dequeue(); // Lấy nút đầu tiên ra khỏi hàng đợi
            
            // Cập nhật max nếu depth của nút hiện tại lớn hơn max
            if (p.info.depth > max) {
                max = p.info.depth; // Cập nhật giá trị max
            }

            // Thêm các nút con vào hàng đợi
            if (p.left != null) {
                q.enqueue(p.left); // Thêm nút con trái vào hàng đợi
            }
            if (p.right != null) {
                q.enqueue(p.right); // Thêm nút con phải vào hàng đợi
            }
        }
    } else {
        // Nếu n lớn hơn 1, gọi đệ quy để tìm max tại độ sâu n-1
        int maxN = MaxN(p, n - 1); // Tìm giá trị lớn nhất tại độ sâu n-1
        max = 0; // Khởi tạo lại max

        // Duyệt cây để tìm giá trị lớn nhất trong các nút có depth nhỏ hơn maxN
        while (!q.isEmpty()) {
            p = (Node) q.dequeue(); // Lấy nút đầu tiên ra khỏi hàng đợi
            
            // Nếu depth của nút hiện tại lớn hơn max và nhỏ hơn maxN, cập nhật max
            if (p.info.depth > max && p.info.depth < maxN) {
                max = p.info.depth; // Cập nhật giá trị max
            }

            // Thêm các nút con vào hàng đợi
            if (p.left != null) {
                q.enqueue(p.left); // Thêm nút con trái vào hàng đợi
            }
            if (p.right != null) {
                q.enqueue(p.right); // Thêm nút con phải vào hàng đợi
            }
        }
    }
    return max; // Trả về giá trị lớn nhất tìm được
}

/**
 * Xóa nút có depth nhất định khỏi cây nhị phân.
 *
 * @param xDepth Giá trị depth của nút cần xóa.
 */
void dele(int xDepth) {
    if (isEmpty()) {
        return; // Nếu cây rỗng, không có gì để xóa
    }

    Node p = root; // Bắt đầu từ nút gốc
    Node parent = null; // Khởi tạo nút cha

    // Tìm nút cần xóa
    while (p != null) {
        if (p.info.depth == xDepth) {
            break; // Đã tìm thấy nút cần xóa
        }
        parent = p; // Cập nhật nút cha
        // Duyệt cây theo giá trị depth
        if (p.info.depth > xDepth) {
            p = p.left; // Đi sang nút con trái
        } else {
            p = p.right; // Đi sang nút con phải
        }
    }

    // Nếu không tìm thấy nút cần xóa
    if (p == null) {
        return; // Kết thúc hàm
    }

    // Trường hợp 1: Nút p là nút lá (không có con)
    if (p.left == null && p.right == null) {
        if (parent == null) {
            root = null; // Cây chỉ có một nút
            return;
        }
        // Cập nhật con của nút cha
        if (parent.left == p) {
            parent.left = null; // Nếu p là con trái
        } else {
            parent.right = null; // Nếu p là con phải
        }
        return; // Kết thúc hàm
    }

    // Trường hợp 2: Nút p có một con
    if ((p.left != null && p.right == null) || (p.left == null && p.right != null)) {
        if (p == root) { // Nếu p là nút gốc
            if (p.left != null) {
                root = p.left; // Cập nhật gốc
            } else {
                root = p.right; // Cập nhật gốc
            }
            return; // Kết thúc hàm
        }
        // Cập nhật nút cha
        if (parent.left == p) {
            parent.left = (p.left != null) ? p.left : p.right; // Nếu p là con trái
        } else {
            parent.right = (p.left != null) ? p.left : p.right; // Nếu p là con phải
        }
        return; // Kết thúc hàm
    }

    // Trường hợp 3: Nút p có cả hai con
    Node rm = p.left; // Bắt đầu từ nút trái
    Node parentRM = null; // Khởi tạo nút cha của rm
    // Tìm nút lớn nhất trong cây con trái
    while (rm.right != null) {
        parentRM = rm; // Cập nhật cha của rm
        rm = rm.right; // Di chuyển đến nút con phải
    }
    
    // Thay đổi giá trị của nút p bằng giá trị của nút lớn nhất
    p.info = rm.info;

    // Cập nhật con của nút lớn nhất
    if (parentRM == null) {
        p.left = rm.left; // Nếu rm là con trái của p
    } else {
        parentRM.right = rm.left; // Cập nhật con phải của nút cha
    }
}

/**
 * Duyệt cây nhị phân theo chiều rộng và xoay nút bên phải của nút đầu tiên có hai con trái.
 *
 * @param p Nút gốc của cây nhị phân.
 * @param f Tệp tin RandomAccessFile (chưa được sử dụng trong hàm này).
 * @throws Exception nếu có lỗi xảy ra trong quá trình thao tác với tệp tin.
 */
void breadth3(Node p, RandomAccessFile f) throws Exception {
    int count3 = 0; // Biến đếm số nút trái đã gặp
    if (p == null) {
        return; // Nếu nút gốc null, kết thúc hàm
    }

    Queue q = new Queue(); // Khởi tạo hàng đợi để duyệt cây
    q.enqueue(p); // Đưa nút gốc vào hàng đợi
    Node r; // Khai báo nút r để sử dụng trong quá trình duyệt

    // Duyệt cây theo chiều rộng
    while (!q.isEmpty()) {
        r = q.dequeue(); // Lấy nút đầu tiên trong hàng đợi

        // Kiểm tra xem nút r có con trái không
        if (r.left != null) {
            count3++; // Tăng biến đếm nếu có con trái

            // Nếu đã gặp hai nút trái, thực hiện xoay phải
            if (count3 == 2) {
                rotateRight(r); // Gọi hàm xoay phải
                // Sau khi xoay, bạn có thể muốn thoát khỏi hàm nếu không cần thực hiện thêm hành động nào khác
                return; // Kết thúc hàm
            }
        }

        // Đưa các nút con vào hàng đợi để duyệt tiếp
        if (r.left != null) {
            q.enqueue(r.left); // Đưa nút con trái vào hàng đợi
        }
        if (r.right != null) {
            q.enqueue(r.right); // Đưa nút con phải vào hàng đợi
        }
    }
}

/**
 * Tính chiều cao của cây nhị phân.
 *
 * @param p Nút gốc của cây nhị phân.
 * @return Chiều cao của cây.
 */
public int getHeight(Node p) {
    if (p == null) {
        return 0; // Nếu nút là null, chiều cao là 0
    }
    
    // Tính chiều cao của cây bằng cách lấy chiều cao tối đa giữa hai cây con
    return Math.max(getHeight(p.left), getHeight(p.right)) + 1; // Thêm 1 cho nút hiện tại
}

/**
 * Tìm nút cha của nút x trong cây nhị phân.
 *
 * @param x Nút cần tìm cha.
 * @return Nút cha của nút x. Nếu không tìm thấy, trả về null.
 */
Node parent(Node x) {
    Node p = root;     // Bắt đầu từ nút gốc
    Node parent = null; // Khởi tạo biến parent là null
    while (p != null) {
        // Nếu giá trị wing của nút p bằng giá trị wing của nút x, dừng vòng lặp
        if (p.info.wing == x.info.wing) {
            break;
        }
        parent = p; // Cập nhật nút cha
        // Nếu wing của nút hiện tại lớn hơn wing của nút x, di chuyển sang cây con bên trái
        if (p.info.wing > x.info.wing) {
            p = p.left;
        } else {
            // Nếu wing của nút hiện tại nhỏ hơn wing của nút x, di chuyển sang cây con bên phải
            p = p.right;
        }
    }
    return parent; // Trả về nút cha đã tìm được
}

void dele(int xDepth) {
    if (isEmpty()) {
        return; // Nếu cây rỗng, thoát.
    }

    Node p = root;
    Node parent = null;
    
    // Tìm nút có giá trị wing bằng xDepth
    while (p != null) {
        if (p.info.wing == xDepth) {
            break; // Nếu tìm thấy nút, thoát khỏi vòng lặp.
        }
        parent = p; // Cập nhật nút cha.
        
        // Di chuyển xuống cây
        if (p.info.wing > xDepth) {
            p = p.left; // Đi sang cây con bên trái.
        } else {
            p = p.right; // Đi sang cây con bên phải.
        }
    }
    
    if (p == null) {
        return; // Nếu không tìm thấy nút, thoát.
    }

    // Xóa nút
    if (p.left == null && p.right == null) { // Nút lá
        if (parent == null) {
            root = null; // Nếu nút cần xóa là nút gốc
            return;
        }
        if (parent.left == p) {
            parent.left = null; // Xóa nút lá khỏi cây
        } else {
            parent.right = null; // Xóa nút lá khỏi cây
        }
    } 
    else if ((p.left != null && p.right == null) || (p.left == null && p.right != null)) { // Nút có một con
        if (p == root) { // Nếu nút cần xóa là nút gốc
            root = (p.left != null) ? p.left : p.right; // Cập nhật gốc cây
            return;
        }
        // Cập nhật nút cha
        if (parent.left == p) {
            parent.left = (p.left != null) ? p.left : p.right; // Thay thế nút cần xóa
        } else {
            parent.right = (p.left != null) ? p.left : p.right; // Thay thế nút cần xóa
        }
    } 
    else { // Nút có hai con
        Node rm = p.left; // Bắt đầu tìm kiếm từ con trái
        Node parentRM = null;
        while (rm.right != null) { // Tìm nút lớn nhất trong cây con bên trái
            parentRM = rm;
            rm = rm.right;
        }
        p.info = rm.info; // Thay đổi thông tin của nút cần xóa
        if (parentRM == null) {
            p.left = rm.left; // Nếu rm là nút gốc của cây con trái
        } else {
            parentRM.right = rm.left; // Cập nhật con bên phải của parentRM
        }
    }
}

int count = 0; // Biến đếm số nút đã duyệt
Node node3 = null; // Biến để lưu nút thứ tư

void postOrder(Node p) {
    if (p == null) {
        return; // Nếu nút hiện tại là null, thoát khỏi hàm
    }
    postOrder(p.left); // Duyệt cây con bên trái
    postOrder(p.right); // Duyệt cây con bên phải
    
    // Logic xử lý
    if (count == 4 && node3 == null) { // Nếu đã duyệt đủ 4 nút và chưa lưu nút thứ tư
        node3 = p; // Lưu nút hiện tại vào node3
    }
    count++; // Tăng biến đếm
}

/**
 * Hàm đếm số lượng nút trong cây nhị phân.
 * 
 * @param pNode - nút hiện tại trong cây.
 * @return - số lượng nút trong cây con bắt đầu từ nút pNode.
 */
int countNode(Node pNode) {
    // Nếu nút hiện tại là null, trả về 0 (không có nút nào)
    if (pNode == null) {
        return 0; 
    }
    
    // Đệ quy để đếm số nút trong cây con bên trái
    int k = countNode(pNode.left);  
    // Đệ quy để đếm số nút trong cây con bên phải
    int h = countNode(pNode.right); 
    
    // Tính tổng số nút: số nút bên trái + số nút bên phải + nút hiện tại
    int rNode = k + h + 1; 
    
    // Trả về tổng số nút trong cây con bắt đầu từ nút pNode
    return rNode; 
}


