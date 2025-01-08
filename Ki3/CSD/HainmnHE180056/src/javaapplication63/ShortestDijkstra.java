public class ShortestDijkstra {

    public static void main(String[] args) {
        Graph g = new Graph();
        int[][] b = {
            {0, 5, 9, 7, 999, 999,999,999,999},
            {5, 0, 1, 12, 999, 999,999,999,999},
            {9, 1, 0, 4, 999, 999,999,999,999},
            {7, 12, 4, 0, 999, 20,999,999,999},
            {999, 999, 999, 999, 0, 27,999,999,999},
            {999, 999, 999, 20, 27, 0,999,999,999},
            {999,999,999,999,999,999,0,2,5},
            {999,999,999,999,999,999,2,0,999},
            {999,999,999,999,999,999,5,999,0}
        };
        g.setData(b);
        g.dispAdj();
        System.out.println("\n1. Test Dijkstra's shortest path algorithm:");
        g.dijkstra(0, 4);
        System.out.println();
    }
}