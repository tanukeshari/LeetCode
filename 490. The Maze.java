// Medium
// There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). 
// The ball can go through the empty spaces by rolling up, 
// down, 
// left or right, 
// but it won't stop rolling until hitting a wall. 
// When the ball stops, 
// it could choose the next direction.

// Given the m x n maze, 
// the ball's start position and the destination, 
// where start = [startrow, startcol] and destination = [destinationrow, destinationcol], 
// return true if the ball can stop at the destination, 
// otherwise return false.

// You may assume that the borders of the maze are all walls (see examples).

// Example 1:
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
// Output: true
  
// Explanation: 
// One possible way is : left -> down -> left -> down -> right -> down -> right.
  
// Example 2:
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
// Output: false
  
// Explanation: 
// There is no way for the ball to stop at the destination. 
// Notice that you can pass through the destination but you cannot stop there.
  
// Example 3:

// Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
// Output: false
 
// Constraints:
// m == maze.length
// n == maze[i].length
// 1 <= m, n <= 100
// maze[i][j] is 0 or 1.
// start.length == 2
// destination.length == 2
// 0 <= startrow, destinationrow <= m
// 0 <= startcol, destinationcol <= n
// Both the ball and the destination exist in an empty space, and they will not be in the same position initially.
// The maze contains at least 2 empty spaces.
  
// Solution
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        return dfs(maze, start, destination, visited);
    }
    
    private boolean dfs(int[][] maze, int[] cur, int[] destination, boolean[][] visited) {
        if (cur[0] == destination[0] && cur[1] == destination[1]) {
            return true;
        }
        
        visited[cur[0]][cur[1]] = true;
        
        int left = cur[1] - 1;
        int right = cur[1] + 1;
        int up = cur[0] - 1;
        int down = cur[0] + 1;
        
        while (0 <= left && maze[cur[0]][left] == 0) {
            left--;
        }
        
        left++;
        
        if (!visited[cur[0]][left]) {
            int[] temp = new int[] {cur[0], left};
        
            if (dfs(maze, temp, destination, visited)) {
                return true;
            }
        }
        
        while (right < maze[0].length && maze[cur[0]][right] == 0) {
            right++;
        }
        
        right--;
        
        if (!visited[cur[0]][right]) {
            int[] temp = new int[] {cur[0], right};
            
            if (dfs(maze, temp, destination, visited)) {
                return true;
            }
        }
        
        while (0 <= up && maze[up][cur[1]] == 0) {
            up--;
        }
        
        up++;
        
        if (!visited[up][cur[1]]) {
            int[] temp = new int[] {up, cur[1]};
            
            if (dfs(maze, temp, destination, visited)) {
                return true;
            }
        }
        
        while (down < maze.length && maze[down][cur[1]] == 0) {
            down++;
        }
        
        down--;
        
        if (!visited[down][cur[1]]) {
            int[] temp = new int[] {down, cur[1]};
            
            if (dfs(maze, temp, destination, visited)) {
                return true;
            }
        }
        
        return false;
    }
}
// TC: O(m * n); SC: O(m * n)
// Success
// Details 
// Runtime: 2 ms, faster than 97.58% of Java online submissions for The Maze.
// Memory Usage: 54.2 MB, less than 59.16% of Java online submissions for The Maze.
