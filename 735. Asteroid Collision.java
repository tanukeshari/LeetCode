// Medium
// We are given an array asteroids of integers representing asteroids in a row.
// For each asteroid, 
// the absolute value represents its size, 
// and the sign represents its direction 
// (positive meaning right, negative meaning left). 
// Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. 
// If two asteroids meet, 
// the smaller one will explode. 
// If both are the same size, 
// both will explode. 
// Two asteroids moving in the same direction will never meet.

// Example 1:
// Input: 
// asteroids = [5,10,-5]
// Output: 
// [5,10]

// Explanation: 
// The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

// Example 2:
// Input: 
// asteroids = [8,-8]
// Output: 
// []

// Explanation: 
// The 8 and -8 collide exploding each other.

// Example 3:
// Input: 
// asteroids = [10,2,-5]
// Output: 
// [10]

// Explanation: 
// The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 
// Constraints:
// 2 <= asteroids.length <= 104
// -1000 <= asteroids[i] <= 1000
// asteroids[i] != 0
  
// Solution
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(asteroids[0]);
        
        for (int i = 1; i < asteroids.length; i++) {
            int coming = asteroids[i];
            boolean add = true;
            
            while (!stack.isEmpty() && stack.peekFirst() > 0 && coming < 0) {
                if (Math.abs(stack.peekFirst()) < Math.abs(coming)) {
                    stack.pollFirst();
                    continue;
                }
                else if (Math.abs(stack.peekFirst()) == Math.abs(coming)) {
                    stack.pollFirst();
                }
                
                add = false;
                break; 
            }
            
            if (add) {
                stack.offerFirst(coming);  
            } 
        }
        
        int len = stack.size();
        int[] ans = new int[len];
        
        for (int j = len - 1; j >= 0; j--) {
            ans[j] = stack.pollFirst();
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 2 ms, faster than 99.61% of Java online submissions for Asteroid Collision.
// Memory Usage: 43.1 MB, less than 94.87% of Java online submissions for Asteroid Collision.
