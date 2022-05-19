// Medium
// We want to split a group of n people (labeled from 1 to n) into two groups of any size. 
// Each person may dislike some other people, and they should not go into the same group.

// Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, 
// return true if it is possible to split everyone into two groups in this way.

// Example 1:
// Input: 
// n = 4, dislikes = [[1,2],[1,3],[2,4]]
// Output: 
// true
  
// Explanation: 
// group1 [1,4] and group2 [2,3].
  
// Example 2:
// Input: 
// n = 3, dislikes = [[1,2],[1,3],[2,3]]
// Output: 
// false
  
// Example 3:
// Input: 
// n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
// Output: 
// false
 
// Constraints:
// 1 <= n <= 2000
// 0 <= dislikes.length <= 104
// dislikes[i].length == 2
// 1 <= dislikes[i][j] <= n
// ai < bi
// All the pairs of dislikes are unique.
  
// Solution
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        toArrList(dislikes, n, graph);
        
        Map<Integer, Integer> color = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (!bfs(graph, color, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void toArrList(int[][] dislikes, int n, List<List<Integer>> graph) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int j = 0; j < dislikes.length; j++) {
            int a = dislikes[j][0] - 1;
            int b = dislikes[j][1] - 1;
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
    
    private boolean bfs(List<List<Integer>> graph, Map<Integer, Integer> color, int node) {
        if (color.containsKey(node)) {
            return true;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        color.put(node, 0);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int neighColor = color.get(cur) == 0 ? 1 : 0;
            
            for (int neigh : graph.get(cur)) {
                if (color.containsKey(neigh)) {
                    if (color.get(neigh) != neighColor) {
                        return false;
                    }
                }
                else {
                    color.put(neigh, neighColor);
                    queue.offer(neigh);
                }
            }
        }
        
        return true;       
    }
}
// TC: O(E + V); SC: O(V)
// Success
// Details 
// Runtime: 29 ms, faster than 52.50% of Java online submissions for Possible Bipartition.
// Memory Usage: 72.2 MB, less than 53.91% of Java online submissions for Possible Bipartition.
