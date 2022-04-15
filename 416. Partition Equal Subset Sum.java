// Medium
// Given a non-empty array nums containing only positive integers, 
// find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

// Example 1:
// Input: 
// nums = [1,5,11,5]
// Output: 
// true
  
// Explanation: 
// The array can be partitioned as [1, 5, 5] and [11].
  
// Example 2:
// Input: 
// nums = [1,2,3,5]
// Output: 
// false
  
// Explanation: 
// The array cannot be partitioned into equal sum subsets.
 
// Constraints:

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
  
// Solution 1
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        } 
        
        int len = nums.length;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        int halfSum = sum / 2;
        boolean[] dp = new boolean[halfSum + 1];
        dp[0] = true;
        
        for (int num : nums) {
            boolean[] temp = new boolean[halfSum + 1];
            
            for (int s = 0; s <= halfSum; s++) {
                if (s < num) {
                    temp[s] = dp[s];
                }
                else {
                    temp[s] = dp[s] || dp[s - num];
                }
            }
            
            dp = temp;
        }
        
        return dp[halfSum];
    }
}
// TC: O(halfSum * n); SC: O(halfSum)
// Success
// Details 
// Runtime: 40 ms, faster than 66.78% of Java online submissions for Partition Equal Subset Sum.
// Memory Usage: 42.3 MB, less than 91.20% of Java online submissions for Partition Equal Subset Sum.

// Solution 2
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        } 
        
        int len = nums.length;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        int halfSum = sum / 2;
        boolean[] dp = new boolean[halfSum + 1];
        dp[0] = true;
        
        for (int num : nums) {
            for (int s = halfSum; s >= 0; s--) {
                if (s < num) {
                    continue;
                }
                else {
                    dp[s] = dp[s] || dp[s - num];
                }
            }
        }
        
        return dp[halfSum];
    }
}
// TC: O(halfSum * n); SC: O(halfSum)
// Success
// Details 
// Runtime: 23 ms, faster than 89.44% of Java online submissions for Partition Equal Subset Sum.
// Memory Usage: 40.8 MB, less than 96.85% of Java online submissions for Partition Equal Subset Sum.
