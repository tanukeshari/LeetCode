// Medium
// There are n cities. 
// Some of them are connected, 
// while some are not. 
// If city a is connected directly with city b, 
// and city b is connected directly with city c, 
// then city a is connected indirectly with city c.
// A province is a group of directly or indirectly connected cities and no other cities outside of the group.
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, 
// and isConnected[i][j] = 0 otherwise.
// Return the total number of provinces.

// Example 1:
// Input: 
// isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 
// 2
  
// Example 2:
// Input: 
// isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 
// 3
 
// Constraints:
// 1 <= n <= 200
// n == isConnected.length
// n == isConnected[i].length
// isConnected[i][j] is 1 or 0.
// isConnected[i][i] == 1
// isConnected[i][j] == isConnected[j][i]

// Solution
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new ArrayDeque<>();
        int cnt = 0;
        
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;
            }
            else {
                continue;
            }
            
            while (!queue.isEmpty()) {
                int island = queue.poll();
                
                for (int neighbor = 0; neighbor < len; neighbor++) {
                    if (isConnected[island][neighbor] == 1 && !visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
            
            cnt++;  
        }
        
        return cnt;
    }
}
// TC: O(n^2); SC: O(n)
// Success
// Details 
// Runtime: 2 ms, faster than 63.22% of Java online submissions for Number of Provinces.
// Memory Usage: 43.3 MB, less than 79.48% of Java online submissions for Number of Provinces.
