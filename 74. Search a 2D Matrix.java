// Medium
// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
// This matrix has the following properties:
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
 
// Example 1:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
  
// Example 2:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false
 
// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
 
// Solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        
        int left = 0 * row + 0;
        int right = (row - 1) * col + col - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midRow = mid / col;
            int midCol = mid % col;
            
            if (matrix[midRow][midCol] == target) {
                return true;
            }
            else if (matrix[midRow][midCol] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
// TC: O(lg(m*n)); SC: O(1)

// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
// Memory Usage: 43.1 MB, less than 5.73% of Java online submissions for Search a 2D Matrix.
