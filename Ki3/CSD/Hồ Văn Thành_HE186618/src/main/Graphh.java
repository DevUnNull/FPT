package main;

import java.util.Arrays;

public class Graphh {

    private int[][] weight;  // Ma trận trọng số
    private int n;  // Số lượng đỉnh

    public Graphh(int[][] weight, int n) {
        this.weight = weight;
        this.n = n;
    }

    // Thuật toán Dijkstra
    public void dijkstra(int src) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = findMinDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && weight[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + weight[u][v] < dist[v]) {
                    dist[v] = dist[u] + weight[u][v];
                }
            }
        }

        printSolution(dist);
    }

    private int findMinDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printSolution(int[] dist) {
        System.out.println("Đỉnh\tKhoảng cách từ nguồn");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] weight = {
            {0, 10, 0, 30, 100},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {100, 0, 10, 60, 0}
        };
        Graphh graph = new Graphh(weight, 5);
        graph.dijkstra(0);  // Bắt đầu từ đỉnh 0
    }
}
