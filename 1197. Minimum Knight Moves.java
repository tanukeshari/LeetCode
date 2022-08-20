// Medium
// In an infinite chess board with coordinates from -infinity to +infinity, 
// you have a knight at square [0, 0].

// A knight has 8 possible moves it can make, 
// as illustrated below. 
// Each move is two squares in a cardinal direction, 
// then one square in an orthogonal direction.

// Return the minimum number of steps needed to move the knight to the square [x, y]. 
// It is guaranteed the answer exists.

// Example 1:
// Input: x = 2, y = 1
// Output: 1
  
// Explanation: 
// [0, 0] → [2, 1]

// Example 2:
// Input: x = 5, y = 5
// Output: 4
  
// Explanation: 
// [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 
// Constraints:
// -300 <= x, y <= 300
// 0 <= |x| + |y| <= 300
  
// Solution 1
class Solution {    
    public int minKnightMoves(int x, int y) {
        int cnt = 0;
        int[][] DIRS = new int[][] {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        
        Queue<String> queue = new ArrayDeque<>();
        String src = 0 + "," + 0;
        queue.offer(src);
        Set<String> visited = new HashSet<>();
        visited.add(src);
        
        boolean brk = false;
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            
            while (len > 0) {
                String[] sArr = queue.poll().split(",");
                int curX = Integer.valueOf(sArr[0]);
                int curY = Integer.valueOf(sArr[1]);
                
                len--;
            
                if (curX == x && curY == y) {
                    brk = true;
                    
                    break;
                }

                for (int[] dir : DIRS) {
                    int nxtX = curX + dir[0];
                    int nxtY = curY + dir[1];
                    String nxt = nxtX + "," + nxtY;

                    if (!visited.contains(nxt)) {
                        queue.offer(nxt);
                        visited.add(nxt);
                    }
                }
            }
            
            if (brk) {
                break;
            }
            
            cnt++;
        }
        
        return cnt;  
    }
}
// TC: O(max(|x|, |y|)^2); SC: O(max(|x|, |y|)^2)
// TLE

// Solution 2
class Solution {    
    public int minKnightMoves(int x, int y) {
        int cnt = 0;
        int[][] DIRS = new int[][] {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        
        Queue<int[]> queue = new ArrayDeque<>();
        int[] src = new int[] {0, 0};
        queue.offer(src);
        
        boolean[][] visited = new boolean[607][607];
        visited[0][0] = true;
        
        boolean brk = false;
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            
            while (len > 0) {
                int[] cur = queue.poll();
        
                len--;
            
                if (cur[0] == x && cur[1] == y) {
                    brk = true;
                    
                    break;
                }

                for (int[] dir : DIRS) {
                    int nxtX = cur[0] + dir[0];
                    int nxtY = cur[1] + dir[1];
                    int[] nxt = new int[] {nxtX, nxtY};

                    if (!visited[nxtX + 302][nxtY + 302]) {
                        queue.offer(nxt);
                        visited[nxtX + 302][nxtY + 302] = true;
                    }
                }
            }
            
            if (brk) {
                break;
            }
            
            cnt++;
        }
        
        return cnt;  
    }
}
// TC: O(max(|x|, |y|)^2); SC: O(max(|x|, |y|)^2)
// Success
// Details 
// Runtime: 325 ms, faster than 57.07% of Java online submissions for Minimum Knight Moves.
// Memory Usage: 162 MB, less than 41.52% of Java online submissions for Minimum Knight Moves.
