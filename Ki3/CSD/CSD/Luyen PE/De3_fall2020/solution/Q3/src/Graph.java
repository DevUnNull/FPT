/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) {  //do not edit this function
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

    int count = 0;

    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        if (count > 0 && count < 6) {
            fvisit(k, f);
        }
        count++;
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }

    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(3, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth2(3, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=================================================================
    String s1 = "";
    String s2 = "";

    void dijkstra(int fro, int to) {
        List<Integer> listSelected = new ArrayList<>();
        int INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];//khoảng cách từ gốc đến đích
        int[] p = new int[n];//lưu lại các đỉnh của đường đi ngắn nhất
        int i, j, k, min;
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];//Khoảng cách từ front đến đỉnh i
            p[i] = fro;
        }
        S[fro] = true;
        listSelected.add(fro);
        while (true) {
            // Find k so that d[k] = min
            min = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;//Đỉnh nào được chọn thì bỏ qua
                }
                if (d[i] < min) {//nếu k;hoảng cách nhỏ hơn thì cập nhật lại
                    min = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("No solution");
                return;
            }
            // select k into the set S
            S[k] = true;
            listSelected.add(k);
            if (k == to) {
                break;//gặp đỉnh đích
            }       // update d[i] and p[i]
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {//Nếu đường đi cũ lớn hơn đường đi mới thì chọn đường đi mới
                    d[i] = d[k] + a[k][i];
                    p[i] = k;//bổ sung đỉnh trước là đỉnh k
                }
            }
        }
        System.out.println("The shortest distance is " + d[to]);
        System.out.println("The path is:");
        i = to;
        Stack s = new Stack();//Phải duyệt từ cuối về để tìm đường đi nên phải dùng stack
        s.push(i);
        while (true) {
            i = p[i];
            s.push(i);
            if (i == fro) {
                break;
            }
        }
        //add tat cac cac dinh vao stack roi
        i = s.pop();
//        System.out.print(v[i] + "(" + d[i] + ")");
        s1 += v[i];
        while (!s.isEmpty()) {
            i = s.pop();
//            System.out.print(" -> " + v[i] + "(" + d[i] + ")");
            s1 += " " + v[i];
        }
        for (int m = listSelected.size() - 3; m < listSelected.size(); m++) {
            int vertice = listSelected.get(m);
            s2 += " " + v[vertice] + "," + d[vertice];
        }
        s2 = s2.trim();
//        System.out.println();
    }

    void f2() throws Exception {
        loadData(12);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f2.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  
        s1 = "";
        dijkstra(2, 5);
        f.writeBytes(s1 + "\r\n");
        s1 = "";
        s2 = "";
        dijkstra(0, 6);
        f.writeBytes(s2 + "\r\n");
        f.writeBytes(s1 + "\r\n");
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

}
