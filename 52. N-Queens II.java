// Hard
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, 
// return the number of distinct solutions to the n-queens puzzle.

// Example 1:
// Input: 
// n = 4
// Output: 
// 2
// Explanation: 
// There are two distinct solutions to the 4-queens puzzle as shown.
  
// Example 2:
// Input: 
// n = 1
// Output: 
// 1
 
// Constraints:
// 1 <= n <= 9
  
// Solution
class Solution {
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        
        int[] cnt = new int[] {0};
        List<Integer> cur = new ArrayList<>();
        
        helperDFS(0, cur, n, cnt);
        
        return cnt[0];
    }
    
    private void helperDFS(int row, List<Integer> cur, int n, int[] cnt) {
        if (cur.size() == n) {
            cnt[0]++;
            
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (validate(cur, row, col)) {
                cur.add(col);
                helperDFS(row + 1, cur, n, cnt);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean validate(List<Integer> cur, int row, int col) {
        int rows = cur.size();
        
        for (int curRow = 0; curRow < rows; curRow++) {
            int curCol = cur.get(curRow);
            
            if (curCol == col || Math.abs(curCol - col) == Math.abs(curRow - row)) {
                return false;
            } 
        }
        
        return true;
    }
}
// TC: O(n!); SC: O(n)
// Success
// Details 
// Runtime: 8 ms, faster than 29.77% of Java online submissions for N-Queens II.
// Memory Usage: 41.1 MB, less than 28.18% of Java online submissions for N-Queens II.
