class Graph {

    int[][] a;
    int n;
    char[] v;

    Graph() {
        v = "ABCDEFGHIJKLMN".toCharArray();
    }

    void setData(int[][] b) {
        n = b.length;
        int i, j;
        a = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%5d", a[i][j]);
            }
        }
        System.out.println();
    }

    void visit(int i) {
        System.out.print(v[i] + "  ");
    }
    /*
    1) Khởi tạo giá trị:
    Khởi tạo tất cả các đỉnh là chưa được duyệt và khoảng cách từ đỉnh bắt đầu 
    đến các đỉnh khác bằng giá trị ban đầu từ ma trận trọng số.
    
    2) Chọn đỉnh gần nhất chưa được duyệt:
    Tìm đỉnh có khoảng cách ngắn nhất mà chưa được duyệt.
    
    3) Cập nhật khoảng cách đến các đỉnh lân cận:
    Nếu tìm được đường đi ngắn hơn qua đỉnh hiện tại, cập nhật khoảng cách 
    và lưu đỉnh trước đó.
    
    4) Truy xuất và in ra đường đi ngắn nhất:
    Dùng ngăn xếp để truy xuất ngược lại đường đi từ đỉnh đích đến đỉnh bắt đầu.
    */
    void dijkstra(int fro, int to) {
        // Định nghĩa giá trị vô cực (để so sánh khoảng cách lớn)
        int INF = 999;
        // Mảng đánh dấu các đỉnh đã được duyệt
        boolean[] s = new boolean[n];
        // Mảng lưu khoảng cách ngắn nhất từ đỉnh bắt đầu đến các đỉnh khác
        int[] d = new int[n];
        // Mảng lưu đỉnh trước đó trong đường đi ngắn nhất
        int[] p = new int[n];
        int i, k, t;

        // Khởi tạo giá trị ban đầu cho mảng s, d, và p
        for (i = 0; i < n; i++) {
            // Tất cả các đỉnh đều chưa được duyệt
            s[i] = false;
            // Khoảng cách từ đỉnh bắt đầu (fro) đến các đỉnh khác
            d[i] = a[fro][i];
            // Đỉnh trước đó trong đường đi ngắn nhất khởi tạo là đỉnh bắt đầu
            p[i] = fro;
        }
        // Đánh dấu đỉnh bắt đầu (fro) là đã được duyệt
        s[fro] = true;

        while (true) {
            // Đặt giá trị tạm thời cho khoảng cách ngắn nhất là vô cực
            t = INF;
            // Khởi tạo giá trị đỉnh tạm thời
            k = -1;

            // Tìm đỉnh k chưa được duyệt với khoảng cách ngắn nhất từ đỉnh bắt đầu
            for (i = 0; i < n; i++) {
                // Nếu đỉnh i chưa được duyệt và khoảng cách ngắn hơn t
                if (!s[i] && d[i] < t) {
                    // Cập nhật khoảng cách ngắn nhất
                    t = d[i];
                    // Gán k là đỉnh có khoảng cách ngắn nhất
                    k = i;
                }
            }

            // Nếu không tìm thấy đỉnh k, tức là không còn đỉnh nào để duyệt
            if (k == -1) {
                // In ra thông báo không có đường đi
                System.out.println("No solution");
                return; // Kết thúc thuật toán
            }

            s[k] = true; // Đánh dấu đỉnh k là đã được duyệt

            // Nếu đỉnh k là đích đến thì dừng thuật toán
            if (k == to) {
                break; // Thoát khỏi vòng lặp
            }

            // Cập nhật lại khoảng cách ngắn nhất từ đỉnh bắt đầu đến các đỉnh lân cận của k
            for (i = 0; i < n; i++) {
                if (s[i]) { // Nếu đỉnh i đã được duyệt thì bỏ qua
                    continue;
                }
                // Nếu đường đi qua đỉnh k ngắn hơn thì cập nhật khoảng cách và đỉnh trước đó
                if (d[k] + a[k][i] < d[i]) {
                    d[i] = d[k] + a[k][i]; // Cập nhật khoảng cách ngắn nhất đến đỉnh i
                    p[i] = k; // Cập nhật đỉnh trước đó của i là k
                }
            }
        }
        // In ra khoảng cách ngắn nhất từ đỉnh bắt đầu đến đỉnh đích
        System.out.println("Shortest distance from the vertex " + v[fro] + " to the vertex " + v[to] + " = " + d[to]);
        // Tạo một ngăn xếp để lưu đường đi ngắn nhất
        MyStack h = new MyStack(); 
        i = to;
        h.push(i); // Đẩy đỉnh đích vào ngăn xếp

        // Lặp lại quá trình để lấy đường đi từ đỉnh đích đến đỉnh bắt đầu
        while (true) {
            i = p[i]; // Lấy đỉnh trước đó của đỉnh hiện tại
            h.push(i); // Đẩy đỉnh vào ngăn xếp
            if (i == fro) { // Nếu đỉnh hiện tại là đỉnh bắt đầu thì dừng lại
                break;
            }
        }
        // In ra đường đi ngắn nhất từ đỉnh bắt đầu đến đỉnh đích
        i = h.pop(); // Lấy đỉnh từ ngăn xếp
        System.out.print(v[i]); // In đỉnh đầu tiên
        while (!h.isEmpty()) { // Lặp lại cho đến khi ngăn xếp rỗng
            i = h.pop(); // Lấy đỉnh tiếp theo từ ngăn xếp
            System.out.print(" -> " + v[i]); // In ra đường đi giữa các đỉnh
        }
    }
}