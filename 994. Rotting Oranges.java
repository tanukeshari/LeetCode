// Medium
// You are given an m x n grid where each cell can have one of three values:
// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, 
// any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
// If this is impossible, 
// return -1.

// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
  
// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
  
// Explanation: 
// The orange in the bottom left corner (row 2, column 0) is never rotten, 
// because rotting only happens 4-directionally.
  
// Example 3:
// Input: grid = [[0,2]]
// Output: 0
  
// Explanation: 
// Since there are already no fresh oranges at minute 0, 
// the answer is just 0.
 
// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.
  
// Solution
class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int cnt = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * COLS + j);
                    visited[i][j] = true;
                    cnt++;
                }
            }
        }
        
        int level = 0;
       
        int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            
            while (len > 0) {
                int cur = queue.poll();
                int row = cur / COLS;
                int col = cur % COLS;
                len--;

                for (int[] dir : DIRS) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if (0 <= nextRow && nextRow < ROWS && 0 <= nextCol && nextCol < COLS &&  grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                        queue.offer(nextRow * COLS + nextCol);
                        visited[nextRow][nextCol] = true;
                        cnt++;
                    }
                }
            }
            
            level++;
        }
        
        int totalOr = 0;
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    totalOr++;
                }
            }
        }
        
        if (level > 0 && cnt == totalOr) {
            return level - 1;
        }
        
         if (level == 0 && cnt == totalOr) {
            return level;
        }
        
        return -1;
    }
}
// TC: O(ROWS * COLS); SC: O(ROWS * COLS)
// Success
// Details 
// Runtime: 3 ms, faster than 76.29% of Java online submissions for Rotting Oranges.
// Memory Usage: 42.9 MB, less than 53.34% of Java online submissions for Rotting Oranges.
