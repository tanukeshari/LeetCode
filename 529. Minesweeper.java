// Medium
// Let's play the minesweeper game (Wikipedia, online game)!

// You are given an m x n char matrix board representing the game board where:
// 'M' represents an unrevealed mine,
// 'E' represents an unrevealed empty square,
// 'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
// digit ('1' to '8') represents how many mines are adjacent to this revealed square, 
// and 'X' represents a revealed mine.
// You are also given an integer array click 
// where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').

// Return the board after revealing this position according to the following rules:
// If a mine 'M' is revealed, 
// then the game is over. 
// You should change it to 'X'.
// If an empty square 'E' with no adjacent mines is revealed, 
// then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
// If an empty square 'E' with at least one adjacent mine is revealed, 
// then change it to a digit ('1' to '8') representing the number of adjacent mines.
// Return the board when no more squares will be revealed.
 
// Example 1:
// Input: 
// board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], 
// click = [3,0]
// Output: 
// [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]

// Example 2:
// Input: 
// board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], 
// click = [1,2]
// Output: 
// [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 
// Constraints:
// m == board.length
// n == board[i].length
// 1 <= m, n <= 50
// board[i][j] is either 'M', 'E', 'B', or a digit from '1' to '8'.
// click.length == 2
// 0 <= clickr < m
// 0 <= clickc < n
// board[clickr][clickc] is either 'M' or 'E'.
  
// Solution bfs
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || click == null) {
            return null;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        if (rows == 0 || cols == 0) {
            return board;
        }
        
        if (click.length == 0) {
            return board;
        }
        
        int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(click);
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
                
                return board;
            }
            else {
                int cnt = 0;
                
                for (int[] dir : DIRS) {
                    int nextRow = cur[0] + dir[0];
                    int nextCol = cur[1] + dir[1];
                    
                    if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols) {
                        if (board[nextRow][nextCol] == 'M') {
                            cnt++;
                        }
                    }
                }
                
                if (cnt == 0) {
                    board[row][col] = 'B';
                    
                    for (int[] dir : DIRS) {
                        int nextRow = cur[0] + dir[0];
                        int nextCol = cur[1] + dir[1];

                        if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols) {
                            if (board[nextRow][nextCol] == 'E') {
                                queue.offer(new int[] {nextRow, nextCol});
                                board[nextRow][nextCol] = 'B';
                            }
                        }
                    }  
                }
                else {
                    board[row][col] = (char) (cnt + '0');    
                }
            }  
        }  
        
        return board;
    }
}
// TC: O(cols * rows); SC: O(cols * rows）
// Success
// Details 
// Runtime: 3 ms, faster than 33.57% of Java online submissions for Minesweeper.
// Memory Usage: 42.3 MB, less than 88.95% of Java online submissions for Minesweeper.
