// Medium
// You have a graph of n nodes labeled from 0 to n - 1. 
// You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
// Return true if the edges of the given graph make up a valid tree, 
// and false otherwise.

// Example 1:
// Input: 
// n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
// Output: 
// true
  
// Example 2:
// Input: 
// n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
// Output: 
// false
 
// Constraints:
// 1 <= n <= 2000
// 0 <= edges.length <= 5000
// edges[i].length == 2
// 0 <= ai, bi < n
// ai != bi
// There are no self-loops or repeated edges.
  
// Solution
class Solution {
    class UF {
        int[] root;
        
        public UF(int size) {
            root = new int[size];
            
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }
        
        public int find(int i) {
            while (i != root[i]) {
                i = root[i];
            }
            
            return i;
        }
        
        public boolean union(int i, int j) {
            if (find(i) == find(j)) {
                return false;
            }
            
            root[find(i)] = find(j);
            
            return true;
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        
        for (int i = 0; i < edges.length; i++) {
            if (!uf.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        
        int root = uf.find(0);
        
        for (int j = 1; j < n; j++) {
            if (uf.find(j) != root) {
                return false;
            }
        }
        
        return true;
    }
}
// TC: O(n * alpha(n)); SC: O(n)
// Success
// Details 
// Runtime: 4 ms, faster than 49.99% of Java online submissions for Graph Valid Tree.
// Memory Usage: 46.1 MB, less than 64.16% of Java online submissions for Graph Valid Tree.
