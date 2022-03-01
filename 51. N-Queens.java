// Hard
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, 
// return all distinct solutions to the n-queens puzzle. 
// You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, 
// where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Example 1:
// Input: 
// n = 4
// Output: 
// [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: 
// There exist two distinct solutions to the 4-queens puzzle as shown above

// Example 2:
// Input: 
// n = 1
// Output: 
// [["Q"]]
 
// Constraints:
// 1 <= n <= 9
  
// Solution
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        
        if (n == 0) {
            return ans;
        }
        
        List<Integer> cur = new ArrayList<>();
        
        helperDFS(0, n, cur, ans);
        
        return ans;
    }
    
    private void helperDFS(int row, int n, List<Integer> cur, List<List<String>> ans) {
        if (cur.size() == n) {
            List<String> result = writeString(cur, n);
            
            ans.add(new ArrayList<String>(result));
            
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (validate(cur, row, col)) {
                cur.add(col);
                helperDFS(row + 1, n, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean validate(List<Integer> cur, int row, int col) {
        int rows = cur.size();
        
        for (int curRow = 0; curRow < rows; curRow++) {
            int curCol = cur.get(curRow);
            
            if (curCol == col || Math.abs(curRow - row) == Math.abs(curCol - col)) {
                return false;
            } 
        }
        
        return true;
    }
    
    private List<String> writeString(List<Integer> cur, int n) {
        List<String> result = new ArrayList<>();
        
        for (int num : cur) {
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                if (i == num) {
                    sb.append('Q');
                }
                else {
                    sb.append('.');
                }
            }
            
            result.add(sb.toString());
        }
        
        return result;
    }
}
// TC: O(n!); SC: O(n)
// Success
// Details 
// Runtime: 10 ms, faster than 37.53% of Java online submissions for N-Queens.
// Memory Usage: 45.2 MB, less than 36.16% of Java online submissions for N-Queens.
