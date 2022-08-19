// Medium
// Given an m x n binary matrix mat, 
// return the distance of the nearest 0 for each cell.
// The distance between two adjacent cells is 1.

// Example 1:
// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]

// Example 2:
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]
 
// Constraints:
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// mat[i][j] is either 0 or 1.
// There is at least one 0 in mat.
  
// Solution 1
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null) {
            return null;
        }
        
        int rows = mat.length;
        
        if (rows == 0) {
            return new int[0][];
        }
        
        int cols = mat[0].length;
        
        if (cols == 0) {
            return new int[0][];
        }
        
        int[][] ans = new int[rows][cols];
        int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.offer(cols * i + j);
                }
                else {
                    ans[i][j] = -1;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int temp = q.poll();
            int curRow = temp / cols;
            int curCol = temp % cols;
            
            for (int[] dir : DIRS) {
                int nxtRow = curRow + dir[0];
                int nxtCol = curCol + dir[1];
                
                if (0 <= nxtRow && nxtRow < rows && 0 <= nxtCol && nxtCol < cols && ans[nxtRow][nxtCol] == -1) {
                    ans[nxtRow][nxtCol] = ans[curRow][curCol] + 1;
                    q.offer(cols * nxtRow + nxtCol);
                }
            }
        }
        
        return ans;
    }
}
// TC: O(r * c); SC: O(r * c)
// Success
// Details 
// Runtime: 25 ms, faster than 41.93% of Java online submissions for 01 Matrix.
// Memory Usage: 73.4 MB, less than 52.80% of Java online submissions for 01 Matrix.

// Solution 2
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int ROWS = mat.length;
        int COLS = mat[0].length;
        int[][] dist = new int[ROWS][COLS];
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        
        int level = 1;
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(i * COLS + j);
                    visited[i][j] = true;
                }
            }
        }
        
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

                    if (0 <= nextRow && nextRow < ROWS && 0 <= nextCol && nextCol < COLS && !visited[nextRow][nextCol]) {
                        dist[nextRow][nextCol] = level;
                        queue.offer(nextRow * COLS + nextCol);
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            
            level++;
        }
        
        return dist;
    }
}
// TC: O(r * c); SC: O(r * c)
// Success
// Details 
// Runtime: 27 ms, faster than 35.30% of Java online submissions for 01 Matrix.
// Memory Usage: 68.5 MB, less than 80.32% of Java online submissions for 01 Matrix.
