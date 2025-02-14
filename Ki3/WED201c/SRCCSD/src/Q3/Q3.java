/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author Admin
 */
public class Q3 {
    Hàm F1

    // output D A B E H I C G F
    // A B E H I

    int depthFirst2(boolean visited[], int i, int count, int min, int max, RandomAccessFile f) throws Exception {
        if (count >= min && count <= max) {
            fvisit(i, f);
        }
        visited[i] = true;
        int j;
        for (j = 0; j < n; j++) {
            if (a[i][j] > 0 && (!visited[j])) {
                count = depthFirst2(visited, j, (count + 1), min, max, f);
            }
        }
        return count;
    }

    // k la bat dau tu vetex nao
    void depthFirst2(int k, int min, int max, RandomAccessFile f) throws Exception {
        int i;
        boolean[] visited = new boolean[20];
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        int count = depthFirst2(visited, k, 0, min, max, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirst2(visited, i, (count + 1), min, max, f);
            }
        }
        System.out.println();
    }

    // -----------------------------------------
    // output B G A E F I C H D
    // B(1) G(2) A(4) E(3) F(3) I(3) C(1) H(2) D(1)

    int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j];
        }
        s += a[i][i];
        return (s);
    }

    void fvisit2(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i] + "(" + deg(i) + ")");
    }

    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit2(k, f);
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
    // --------------------------------------

    // Dijktra
    // output A B C E D G

    void dijkstra(int fro, int to, RandomAccessFile f) throws Exception {
        int i, j, k, t, INF;
        INF = 999;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }

        int[] ss = new int[n];
        int[] pp = new int[n];
        int m, r;

        j = 0;

        // select fro into the set S
        S[fro] = true;
        ss[0] = fro;
        while (true) {
            k = -1;
            t = INF;
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] < t) {
                    k = i;
                    t = d[i];
                }
            }
            if (k == -1) {
                return;
            }
            S[k] = true;
            j++;
            ss[j] = k;
            if (k == to) {
                break;
            }
            // Recalculate d[i]
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        m = j;
        Stack s = new Stack();
        i = to;
        while (true) {
            s.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
        j = 0;
        while (!s.isEmpty()) {
            i = s.pop();
            pp[j++] = i;
        }
        r = j;
        f.writeBytes("" + v[pp[0]]);
        for (i = 1; i < r; i++) {
            f.writeBytes(" " + v[pp[i]]);
        }
        f.writeBytes("\r\n");

    }
    // -------------------------
    // output E,15 D,19 F,24 G,29
    // the last count vertices ....

    void dijkstra2(int fro, int to, int count_index, RandomAccessFile f) throws IOException {
        List<Integer> listSelected = new ArrayList<>();
        int INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int i, j, k, min;
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
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
                    continue;
                }
                if (d[i] < min) {
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
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        i = to;
        Stack s = new Stack();
        s.push(i);
        while (true) {
            i = p[i];
            s.push(i);
            if (i == fro) {
                break;
            }
        }

        i = s.pop();
        int mm = listSelected.size() - count_index;
        f.writeBytes("" + v[listSelected.get(mm)] + "," + d[listSelected.get(mm)]);
        for (int m = listSelected.size() - (count_index - 1); m < listSelected.size(); m++) {
            int index = listSelected.get(m);
            f.writeBytes(" " + v[index] + "," + d[index]);
        }
        f.writeBytes("\r\n");
    }

    // --------------------------------
    // output A C F E
    // 0 9 11 20

    void dijkstra3(int fro, int to, RandomAccessFile f) throws Exception {
        int i, j, k, t, INF;
        INF = 999;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }

        int[] ss = new int[n];
        int[] pp = new int[n];
        int m, r;
        j = 0;
        S[fro] = true;
        ss[0] = fro;
        while (true) {
            k = -1;
            t = INF;
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] < t) {
                    k = i;
                    t = d[i];
                }
            }
            if (k == -1) {
                return;
            }
            S[k] = true;
            j++;
            ss[j] = k;
            if (k == to) {
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        m = j;
        Stack s = new Stack();
        i = to;
        while (true) {
            s.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
        j = 0;
        while (!s.isEmpty()) {
            i = s.pop();
            pp[j++] = i;
        }
        r = j;
        f.writeBytes("" + v[pp[0]]);
        for (i = 1; i < r; i++) {
            f.writeBytes("   " + v[pp[i]]);
        }
        f.writeBytes("\r\n");
        f.writeBytes("" + d[pp[0]]);
        for (i = 1; i < r; i++) {
            f.writeBytes("   " + d[pp[i]]);
        }
        f.writeBytes("\r\n");
    }

    // -------------------

    // Euler

    boolean hasIsolated() {
        for (int i = 0; i < n; i++) {
            if (deg(i) == 0) {
                return (true);
            }
        }
        return (false);
    }

    boolean isConnected() {
        boolean[] p = new boolean[n];
        int i, j, r;
        for (i = 0; i < n; i++) {
            p[i] = false;
        }
        Stack s = new Stack();
        s.push(0);
        p[0] = true;
        while (!s.isEmpty()) {
            r = s.pop();
            for (i = 0; i < n; i++) {
                if (!p[i] && a[r][i] > 0) {
                    s.push(i);
                    p[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!p[i]) {
                return (false);
            }
        }
        return (true);
    }

    boolean isUnDirected() {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (a[i][j] != a[j][i]) {
                    return (false);
                }
            }
        }
        return (true);
    }

    boolean allDegEven() {
        for (int i = 0; i < n; i++) {
            if (deg(i) % 2 == 1) {
                return (false);
            }
        }
        return (true);
    }

    boolean hasEulerCycle() {
        if (!hasIsolated() && isUnDirected() && isConnected() && allDegEven()) {
            return (true);
        } else {
            return (false);
        }
    }

    void eulerCycle(int fro, RandomAccessFile f) throws IOException {
        if (!hasEulerCycle()) {
            return;
        }
        int[] eu = new int[100];
        int m, i, j, r;
        Stack s = new Stack();
        s.push(fro);
        j = 0;
        while (!s.isEmpty()) {
            r = s.top();
            for (i = 0; i < n; i++) {
                if (a[r][i] > 0) {
                    break;
                }
            }
            if (i == n) {
                s.pop();
                eu[j++] = r;

            } else {
                s.push(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        m = j;
        for (i = 0; i < m; i++) {
            f.writeBytes(v[eu[i]] + " ");
        }
    }

    // -----------------------------------------------------
    int count = 0;

    void breadth2(boolean[] en, int i, int min, int max, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            count++;
            if (count >= min && count <= max) {
                fvisit(r, f);
            }
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth2(int k, int min, int max, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++)
            en[i] = false;
        breadth2(en, k, min, max, f);
        for (i = 0; i < n; i++)
            if (!en[i])
                breadth2(en, i, min, max, f);
    }

    // --f1-graph-depthfirst
    int count1 = 0;

    void depth2(boolean[] visited, int k, int min, int max, RandomAccessFile f) throws Exception {
        count1++;
        if (count1 >= min && count1 <= max) {
            fvisit(k, f);
        }
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0)
                depth2(visited, i, min, max, f);
        }
    }

    void depth2(int k, int min, int max, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++)
            visited[i] = false;
        depth2(visited, k, min, max, f);
        for (i = 0; i < n; i++)
            if (!visited[i])
                depth2(visited, i, min, max, f);
    }

}

    // ------------------------------------------------------------------------------------
    void depth2(int v, boolean[] visited, RandomAccessFile f) throws Exception {
        // Mark the current node as visited
        visited[v] = true;

        // Calculate degree of vertex v (this is a placeholder, adjust to your
        // implementation)
        int degree = calculateDegree(v);

        // Write vertex with degree to file
        f.writeBytes("Vertex " + getVertexName(v) + "(" + degree + ")\n");

        // Traverse neighbors (assuming adjacency list representation)
        for (int neighbor : adjacencyList[v]) {
            if (!visited[neighbor]) {
                depth2(neighbor, visited, f);
            }
        }
    }

    // Helper method to get the degree of a vertex (assuming an adjacency list
    // representation)
    int calculateDegree(int v) {
        return adjacencyList[v].size();
    }

    // Helper method to map vertex index to vertex name, e.g., 1 -> "B"
String getVertexName(int index) {
    // Map index to letter (assuming 0 -> A, 1 -> B, etc.)
    return String.valueOf((char) ('A' + index));
}