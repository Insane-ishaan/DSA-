import java.util.ArrayList;
import java.util.List;

public class TarjansArticulationPointFinding {
    static int time = 0;

    private static void helper(int u, int parent, List<List<Integer>> unDirectedgraph, boolean[] isV, int[] low,
            int dicv[]) {
        isV[u] = true;
        dicv[u] = low[u] = ++time;
        int children = 0;
        for (int neigh : unDirectedgraph.get(u)) {
            if (neigh == parent)
                continue;

            if (!isV[neigh]) {
                children++;
                helper(neigh, u, unDirectedgraph, isV, low, dicv);

                low[u] = Math.min(low[u], low[neigh]);
                if (parent != -1 && dicv[u] <= low[neigh]) {
                    System.out.println("Articulaiton point found " + u);
                }
            } else if (isV[neigh] && parent != -1) {
                low[u] = Math.min(low[u], dicv[neigh]);
            }
        }

        if (parent == -1 && children > 1) {
            System.out.println("Articulaiton point found " + u);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int edges[][] = { { 1, 0 }, { 1, 2 }, { 2, 0 }, { 0, 3 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };

        List<List<Integer>> unDirectedgraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            unDirectedgraph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            unDirectedgraph.get(u).add(v);
            unDirectedgraph.get(v).add(u);
        }

        boolean isV[] = new boolean[n];
        int low[] = new int[n];
        int disc[] = new int[n];

        helper(0, -1, unDirectedgraph, isV, low, disc);
    }
}
