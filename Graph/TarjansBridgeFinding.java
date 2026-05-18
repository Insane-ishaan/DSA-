import java.util.*;

class Pair {
    int disc = 0;
    int low = 0;

    public Pair(int disc, int low) {
        this.disc = disc;
        this.low = low;
    }
}

public class TarjansBridgeFinding {
    static int time = 0;

    private static void dfs(int u, int parent, Pair[] stats, boolean[] isV, List<List<Integer>> unDirectedgraph) {
        isV[u] = true;
        stats[u].disc = stats[u].low = ++time;

        for (int v : unDirectedgraph.get(u)) {
            if (v == parent)
                continue;

            if (!isV[v]) {
                dfs(v, u, stats, isV, unDirectedgraph);
                stats[u].low = Math.min(stats[u].low, stats[v].low);

                if (stats[u].disc < stats[v].low) {
                    System.out.println("Bridge found at " + "(" + u + "," + v + ")");
                }
            } else if (isV[v]) {
                stats[u].low = Math.min(stats[u].low, stats[v].disc);
            }
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

        Pair stats[] = new Pair[n];

        for(int i=0; i<stats.length; i++){
            stats[i]=new Pair(0, 0);
        }
        boolean isV[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isV[i]) {
                dfs(i, -1, stats, isV, unDirectedgraph);
            }
        }
    }
}
