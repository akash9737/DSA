import java.util.*;

public class Solution {
    public int checkWays(int[][] pairs) {
        // Collect all nodes
        Set<Integer> nodes = new HashSet<>();
        for (int[] p : pairs) {
            nodes.add(p[0]);
            nodes.add(p[1]);
        }

        int n = nodes.size();

        // Build adjacency (undirected)
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int x : nodes) {
            adj.put(x, new HashSet<>());
        }
        for (int[] p : pairs) {
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }

        // Find root: node whose degree = n - 1
        Integer root = null;
        for (int x : nodes) {
            if (adj.get(x).size() == n - 1) {
                root = x;
                break;
            }
        }
        if (root == null) {
            return 0; // no node connected to all others
        }

       
        List<Integer> list = new ArrayList<>(nodes);
        list.sort(Comparator.comparingInt(a -> adj.get(a).size()));

        int result = 1; 

        
        for (int x : list) {
            if (x == root) continue;
            int degX = adj.get(x).size();

           
            int parent = -1;
            int parentDeg = Integer.MAX_VALUE;

            for (int y : adj.get(x)) {
                int degY = adj.get(y).size();
                if (degY >= degX && degY < parentDeg) {
                    parentDeg = degY;
                    parent = y;
                }
            }

           
            if (parent == -1) {
                return 0;
            }

            // Check neighbor(x) is subset of neighbor(parent) ∪ {parent}
            for (int nei : adj.get(x)) {
                if (nei == parent) continue;
                if (!adj.get(parent).contains(nei)) {
                    return 0;
                }
            }

            // If deg(parent) == deg(x), there is ambiguity → multiple trees
            if (parentDeg == degX) {
                result = 2;
            }
        }

        return result;
    }
}
