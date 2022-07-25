// Medium
// On an infinite plane, 
// a robot initially stands at (0, 0) and faces north. 

// Note that:
// The north direction is the positive direction of the y-axis.
// The south direction is the negative direction of the y-axis.
// The east direction is the positive direction of the x-axis.
// The west direction is the negative direction of the x-axis.
  
// The robot can receive one of three instructions:
// "G": go straight 1 unit.
// "L": turn 90 degrees to the left (i.e., anti-clockwise direction).
// "R": turn 90 degrees to the right (i.e., clockwise direction).
  
// The robot performs the instructions given in order, 
// and repeats them forever.

// Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

// Example 1:
// Input: instructions = "GGLLGG"
// Output: true
  
// Explanation: 
// The robot is initially at (0, 0) facing the north direction.
// "G": move one step. Position: (0, 1). Direction: North.
// "G": move one step. Position: (0, 2). Direction: North.
// "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
// "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
// "G": move one step. Position: (0, 1). Direction: South.
// "G": move one step. Position: (0, 0). Direction: South.
// Repeating the instructions, 
// the robot goes into the cycle: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
// Based on that, 
// we return true.
  
// Example 2:
// Input: instructions = "GG"
// Output: false
  
// Explanation: 
// The robot is initially at (0, 0) facing the north direction.
// "G": move one step. Position: (0, 1). Direction: North.
// "G": move one step. Position: (0, 2). Direction: North.
// Repeating the instructions, 
// keeps advancing in the north direction and does not go into cycles.
// Based on that, 
// we return false.
  
// Example 3:
// Input: instructions = "GL"
// Output: true
  
// Explanation: 
// The robot is initially at (0, 0) facing the north direction.
// "G": move one step. Position: (0, 1). Direction: North.
// "L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
// "G": move one step. Position: (-1, 1). Direction: West.
// "L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
// "G": move one step. Position: (-1, 0). Direction: South.
// "L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
// "G": move one step. Position: (0, 0). Direction: East.
// "L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
// Repeating the instructions, 
// the robot goes into the cycle: (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0).
// Based on that, 
// we return true.
 
// Constraints:
// 1 <= instructions.length <= 100
// instructions[i] is 'G', 'L' or, 'R'.
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int x = 0;
        int y = 0;
        int dir = 0;
        
        char[] ins = instructions.toCharArray();
        
        for (char inst : ins) {
            if (inst == 'L') {
                dir = (dir + 3) % 4;
            }
            else if (inst == 'R') {
                dir = (dir + 1) % 4 ;
            }
            else {
                x += DIRS[dir][0];
                y += DIRS[dir][1];
            }
        }
        
        return (x == 0 && y == 0) || (dir != 0);
    }
}
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 1 ms, faster than 73.43% of Java online submissions for Robot Bounded In Circle.
// Memory Usage: 42.3 MB, less than 17.83% of Java online submissions for Robot Bounded In Circle.
