import java.util.*;

class NumberOfNodesInSubtree {

    public static int[] helper(int u, int parent, List<List<Integer>> graph, int[] answer, String labels) {
        int count[] = new int[26];

        count[labels.charAt(u) - 'a'] = 1;
        for (int neigh : graph.get(u)) {
            if (neigh == parent)
                continue;

            int countChild[] = helper(neigh, u, graph, answer, labels);

            for (int i = 0; i < 26; i++) {
                count[i] += countChild[i];
            }
        }

        answer[u] = count[labels.charAt(u) - 'a'];
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 3 } };
        String labels = "bbbb";

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

        int answer[] = new int[n];
        helper(0, -1, graph, answer, labels);

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}