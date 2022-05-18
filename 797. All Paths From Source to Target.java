// Medium
// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, 
// find all possible paths from node 0 to node n - 1 and return them in any order.

// The graph is given as follows: 
// graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

// Example 1:
// Input: 
// graph = [[1,2],[3],[3],[]]
// Output: 
// [[0,1,3],[0,2,3]]

// Explanation: 
// There are two paths: 
// 0 -> 1 -> 3 and 0 -> 2 -> 3.
  
// Example 2:
// Input: 
// graph = [[4,3,1],[3,2,4],[3],[4],[]]
// Output: 
// [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 
// Constraints:
// n == graph.length
// 2 <= n <= 15
// 0 <= graph[i][j] < n
// graph[i][j] != i (i.e., there will be no self-loops).
// All the elements of graph[i] are unique.
// The input graph is guaranteed to be a DAG.
  
// Solution
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int n = graph.length;
        
        path.add(0);    
        dfs(graph, n - 1, 0, path, ans);
        
        return ans;
    }
    
    private void dfs(int[][] graph, int target, int cur, List<Integer> path, List<List<Integer>> ans) {
        if (cur == target) {
            ans.add(new ArrayList<Integer>(path));
            
            return;
        }
        
        for (int node : graph[cur]) {
            path.add(node);
            dfs(graph, target, node, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
// TC: O(n * 2^n); SC: O(n)
// Success
// Details 
// Runtime: 3 ms, faster than 79.57% of Java online submissions for All Paths From Source to Target.
// Memory Usage: 54.9 MB, less than 60.07% of Java online submissions for All Paths From Source to Target.
