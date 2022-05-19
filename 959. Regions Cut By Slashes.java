// Medium
// An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. 
// These characters divide the square into contiguous regions.
// Given the grid grid represented as a string array, 
// return the number of regions.

// Note that backslash characters are escaped, 
// so a '\' is represented as '\\'.

// Example 1:
// Input: 
// grid = [" /","/ "]
// Output: 
// 2
  
// Example 2:
// Input: 
// grid = [" /","  "]
// Output: 
// 1
  
// Example 3:
// Input: 
// grid = ["/\\","\\/"]
// Output: 
// 5
  
// Explanation: 
// Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
 
// Constraints:
// n == grid.length == grid[i].length
// 1 <= n <= 30
// grid[i][j] is either '/', '\', or ' '.
  
// Solution
class Solution {
    class UF {
        int[] root;

        public UF(int n) {
            root = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public int find(int i) {
            while (i != root[i]) {
                i = root[i];
            }

            return i;
        }

        public void union(int i, int j) {
            root[find(i)] = find(j);
        }
    }
    
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UF uf = new UF(4 * n * n);
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int base = 4 * (r * n + c);
                char slash = grid[r].charAt(c);
                
                if (slash != '\\') {
                    uf.union(base + 0, base + 1);
                    uf.union(base + 2, base + 3);
                }
                
                if (slash != '/') {
                    uf.union(base + 1, base + 3);
                    uf.union(base + 0, base + 2);
                }
                
                if (r + 1 < n) {
                    uf.union(base + 3, base + 4 * n);
                }
                
                if (c + 1 < n) {
                    uf.union(base + 2, base + 5);
                }
            }
        }
        
        int cnt = 0;
        
        for (int x = 0; x < 4 * n * n; x++) {
            if (uf.find(x) == x) {
                cnt++;
            }
        }
        
        return cnt;
    }
}
// TC: O(n^2 * alpha(n)); SC: O(n^2)
// alpha is the Inverse-Ackermann function (if we were to use union-find by rank).
// Success
// Details 
// Runtime: 74 ms, faster than 5.46% of Java online submissions for Regions Cut By Slashes.
// Memory Usage: 42.4 MB, less than 54.34% of Java online submissions for Regions Cut By Slashes.
