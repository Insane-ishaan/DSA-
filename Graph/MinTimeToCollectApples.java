import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Leetcode 1443 */
class Graph {
    private static int helper(int u, int parent, List<Boolean> hasApple, List<List<Integer>> graph) {
        int time = 0;
        for (int neigh : graph.get(u)) {
            if (neigh == parent)
                continue;

            int costReq = helper(neigh, u, hasApple, graph);

            if (costReq > 0 || hasApple.get(neigh)) {
                time += costReq + 2;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
        Boolean[] flag = { false, false, true, false, true, true, false };
        List<Boolean> hasApple = new ArrayList<>(Arrays.asList(flag));
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int value = helper(0, -1, hasApple, graph);
        System.out.print(value);
    }
}