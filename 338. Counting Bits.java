// Easy
// Given an integer n, 
// return an array ans of length n + 1 such that for each i (0 <= i <= n), 
// ans[i] is the number of 1's in the binary representation of i.

// Example 1:
// Input: 
// n = 2
// Output: 
// [0,1,1]

// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
  
// Example 2:
// Input: 
// n = 5
// Output: 
// [0,1,1,2,1,2]

// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101

// Constraints:
// 0 <= n <= 105
 
// Follow up:
// It is very easy to come up with a solution with a runtime of O(n log n). 
// Can you do it in linear time O(n) and possibly in a single pass?
// Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
  
// Solution
class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        
        for (int i = 1; i <= num; i++) {
            ans[i] = helper(i);
        }
        
        return ans;
    }
    
    private int helper(int num) {
        int cnt = 0;
        int temp = num;
        
        while (temp > 0) {
            cnt++;
            temp /= 2;
        }
        
        int ans = 0;
        
        while (cnt >= 0) {
            ans += (num >> cnt - 1) & 1;
            cnt--;
        }
        
        return ans;
    }
}
// TC: O(m * n); SC: O(1)
// Success
// Details 
// Runtime: 12 ms, faster than 17.60% of Java online submissions for Counting Bits.
// Memory Usage: 46.5 MB, less than 83.73% of Java online submissions for Counting Bits.
