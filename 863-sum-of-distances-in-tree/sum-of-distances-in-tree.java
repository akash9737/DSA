import java.util.*;

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] ans = new int[n];     // ans[i] = sum of distances from i to all nodes
        int[] count = new int[n];   // count[i] = size of subtree rooted at i
        Arrays.fill(count, 1);      // each node counts as 1 by itself

        // Post-order: compute count[] and ans[0]-like base via subtree DP
        postOrder(0, -1, graph, count, ans);

        // Pre-order: re-root to compute ans for all nodes using the parent’s result
        preOrder(0, -1, graph, count, ans, n);

        return ans;
    }

    private void postOrder(int u, int parent, List<List<Integer>> g, int[] count, int[] ans) {
        for (int v : g.get(u)) {
            if (v == parent) continue;
            postOrder(v, u, g, count, ans);
            count[u] += count[v];
            ans[u] += ans[v] + count[v];
        }
    }

    private void preOrder(int u, int parent, List<List<Integer>> g, int[] count, int[] ans, int n) {
        for (int v : g.get(u)) {
            if (v == parent) continue;
            // Re-root from u -> v
            ans[v] = ans[u] - count[v] + (n - count[v]);
            preOrder(v, u, g, count, ans, n);
        }
    }
}