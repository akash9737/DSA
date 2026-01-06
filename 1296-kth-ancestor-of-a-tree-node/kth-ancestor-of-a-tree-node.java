class TreeAncestor {
    int[][] up;   // up[v][j] = 2^j-th ancestor of v
    int LOG;
    
    public TreeAncestor(int n, int[] parent) {
        LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        up = new int[n][LOG];
        
        for (int v = 0; v < n; v++) {
            up[v][0] = parent[v];
        }
        
        for (int j = 1; j < LOG; j++) {
            for (int v = 0; v < n; v++) {
                int mid = up[v][j-1];
                up[v][j] = (mid == -1 ? -1 : up[mid][j-1]);
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if (((k >> j) & 1) == 1) {
                node = up[node][j];
                if (node == -1) return -1;
            }
        }
        return node;
    }
}
/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */