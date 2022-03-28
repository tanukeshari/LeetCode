// Medium
// Given an array of integers temperatures represents the daily temperatures, 
// return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
// If there is no future day for which this is possible, 
// keep answer[i] == 0 instead.

// Example 1:
// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

// Example 2:
// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]

// Example 3:
// Input: temperatures = [30,60,90]
// Output: [1,1,0]
 
// Constraints:
// 1 <= temperatures.length <= 105
// 30 <= temperatures[i] <= 100
 
// Solution
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length < 2) {
            return new int[0];
        }
        
        Deque<Integer> monStack = new ArrayDeque<>();
        monStack.offerFirst(0);
        int len = temperatures.length;
        int[] ans = new int[len];
        
        for (int i = 1; i < len; i++) {
            int temp = temperatures[i];
            
            while (!monStack.isEmpty() && temp > temperatures[monStack.peekFirst()]) {
                int prev = monStack.pollFirst();
                ans[prev] = i - prev;
            }
            
            monStack.offerFirst(i);
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 31 ms, faster than 82.89% of Java online submissions for Daily Temperatures.
// Memory Usage: 134 MB, less than 20.50% of Java online submissions for Daily Temperatures.
