// Medium
// In this problem, 
// a tree is an undirected graph that is connected and has no cycles.
// You are given a graph that started as a tree with n nodes labeled from 1 to n, 
// with one additional edge added. 
// The added edge has two different vertices chosen from 1 to n, 
// and was not an edge that already existed. 
// The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

// Return an edge that can be removed so that the resulting graph is a tree of n nodes. 
// If there are multiple answers, 
// return the answer that occurs last in the input.

// Example 1:
// Input: 
// edges = [[1,2],[1,3],[2,3]]
// Output: 
// [2,3]

// Example 2:
// Input: 
// edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
// Output: 
// [1,4]
 
// Constraints:
// n == edges.length
// 3 <= n <= 1000
// edges[i].length == 2
// 1 <= ai < bi <= edges.length
// ai != bi
// There are no repeated edges.
// The given graph is connected.
  
// Solution
class Solution {
    class UF {
        int size = 1001;
        int[] root = new int[size];
        
        public UF(int size) {
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
            else {
                root[find(i)] = find(j);
                
                return true;
            }
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] connected = new int[len];
        UF uf = new UF(len);
        
        for (int i = 0; i < len; i++) {
            if (!uf.union(edges[i][0], edges[i][1])) {
                return edges[i];
            }     
        }
        
        throw new AssertionError();
    }
}
// TC: O(n * alpha(n)); SC: O(n)
// Success
// Details 
// Runtime: 1 ms, faster than 78.10% of Java online submissions for Redundant Connection.
// Memory Usage: 44.4 MB, less than 23.90% of Java online submissions for Redundant Connection.
