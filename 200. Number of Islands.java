// Medium
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
// return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// You may assume all four edges of the grid are all surrounded by water.

// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
  
// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 
// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.
  
// Solution
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    q.offer(cols * i + j);
                    cnt++;
                    
                    while (!q.isEmpty()) {
                        int curPoint = q.poll();
                        int row = curPoint / cols;
                        int col = curPoint % cols;
                        
                        for (int[] dir : DIRS) {
                            int nextRow = row + dir[0];
                            int nextCol = col + dir[1];
                            
                            if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols && grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) {
                                int nextPoint = cols * nextRow + nextCol;
                                
                                visited[nextRow][nextCol] = true;
                                q.offer(nextPoint);
                            }
                        }
                    }
                }
            }
        }
        
        return cnt;        
    }
}
// TC: O(m * n); SC: O(min(m, n))
// Success
// Details 
// Runtime: 17 ms, faster than 10.15% of Java online submissions for Number of Islands.
// Memory Usage: 56.4 MB, less than 35.09% of Java online submissions for Number of Islands.
