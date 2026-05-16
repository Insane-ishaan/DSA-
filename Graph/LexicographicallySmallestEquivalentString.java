import java.util.*;

/* LEETCODE 1061 */
class LexicographicallySmallestEquivalentString {
    public static char helper(char u, char minChar, String baseStr, List<List<Character>> graph, boolean[] isV) {
        isV[u - 'a'] = true;

        minChar = (char) Math.min(u, minChar);

        for (Character neigh : graph.get(u - 'a')) {
            if (!isV[neigh - 'a']) {
                minChar = helper(neigh, minChar, baseStr, graph, isV);
            }
        }
        return minChar;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String baseStr = "hold";

        List<List<Character>> graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < s1.length(); i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);

            graph.get(u - 'a').add(v);
            graph.get(v - 'a').add(u);
        }

        boolean isV[] = new boolean[26];
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < baseStr.length(); i++) {
            Arrays.fill(isV, false);
            char minChar = baseStr.charAt(i);
            char processedMinChar = helper(minChar, minChar, baseStr, graph, isV);
            result.append(processedMinChar);
        }

        String resultFinal = new String(result);
        System.out.println(resultFinal);
    }

}