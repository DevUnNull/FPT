package main;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int[][] a;  // Ma trận kề
    private String[] label;  // Nhãn đỉnh
    private int n;  // Số lượng đỉnh

    // Phương thức để thiết lập ma trận kề và số lượng đỉnh
    public void setAMatrix(int[][] b, int m) {
        this.n = m;
        this.a = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                this.a[i][j] = b[i][j];
            }
        }
    }

    // Phương thức để thiết lập nhãn cho các đỉnh
    public void setLabel(String[] c) {
        this.label = new String[n];
        for (int i = 0; i < n; i++) {
            this.label[i] = c[i];
        }
    }

    // Phương thức duyệt theo chiều rộng (BFS)
    public void bfs(int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(label[v] + " ");
            for (int i = 0; i < n; i++) {
                if (a[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // Phương thức duyệt theo chiều sâu (DFS)
    public void dfs(int start) {
        boolean[] visited = new boolean[n];
        dfsHelper(start, visited);
    }

    // Hàm đệ quy hỗ trợ duyệt DFS
    private void dfsHelper(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(label[v] + " ");
        for (int i = 0; i < n; i++) {
            if (a[v][i] == 1 && !visited[i]) {
                dfsHelper(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        // Ví dụ về ma trận kề và nhãn đỉnh
        int[][] matrix = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 0},
            {0, 1, 0, 0}
        };
        String[] labels = {"A", "B", "C", "D"};

        g.setAMatrix(matrix, 4);
        g.setLabel(labels);

        System.out.println("BFS từ đỉnh A:");
        g.bfs(0);  // Duyệt từ đỉnh A (vị trí 0)

        System.out.println("\nDFS từ đỉnh A:");
        g.dfs(0);  // Duyệt từ đỉnh A (vị trí 0)
    }
}
