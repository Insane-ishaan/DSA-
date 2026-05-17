import java.util.*;

/* LEETCODE 2359 */
/* DFS based Approach */
class FindClosestNodetoGivenTwoNodes {
    private static void helper(List<List<Integer>> directedGraph, int node, int[] dist, int distSoFar) {
        if (node == -1 || dist[node] != -1) {
            return;
        }

        dist[node] = distSoFar;

        helper(directedGraph, directedGraph.get(node).get(0), dist, distSoFar + 1);
    }

    public static void main(String[] args) {
        int[] edges = { 2, 2, 3, -1 };
        int node1 = 0;
        int node2 = 1;

        List<List<Integer>> directedGraph = new ArrayList<>();
        int n = edges.length;

        for (int i = 0; i < n; i++) {
            directedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int v = edges[i];

            /* directed graph */
            directedGraph.get(i).add(v);
        }

        int dist1[] = new int[n];
        int dist2[] = new int[n];

        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        helper(directedGraph, node1, dist1, 0);
        helper(directedGraph, node2, dist2, 0);

        int minPos = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int currMax = Math.max(dist1[i], dist2[i]);

                if (minPos > currMax) {
                    minPos = currMax;
                    result = i;
                }
            }
        }

        System.out.println(result);
    }
}