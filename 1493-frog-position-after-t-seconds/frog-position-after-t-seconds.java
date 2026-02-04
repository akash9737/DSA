import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    double ans = 0.0;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        visited = new boolean[n + 1];
        dfs(1, t, target, 1.0);
        return ans;
    }

    private void dfs(int node, int time, int target, double prob) {
        visited[node] = true;

        // count unvisited neighbors
        int count = 0;
        for (int nei : graph[node]) {
            if (!visited[nei]) count++;
        }

        // if time is up or no moves left
        if (time == 0 || count == 0) {
            if (node == target) ans = prob;
            return;
        }

        for (int nei : graph[node]) {
            if (!visited[nei]) {
                dfs(nei, time - 1, target, prob / count);
            }
        }

        visited[node] = false; // backtrack
    }
}
