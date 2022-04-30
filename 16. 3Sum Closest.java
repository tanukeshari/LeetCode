// Medium
// Given an integer array nums of length n and an integer target, 
// find three integers in nums such that the sum is closest to target.
// Return the sum of the three integers.
// You may assume that each input would have exactly one solution.

// Example 1:
// Input: 
// nums = [-1,2,1,-4], target = 1
// Output: 
// 2
  
// Explanation: 
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
  
// Example 2:
// Input: 
// nums = [0,0,0], target = 1
// Output: 
// 0
 
// Constraints:
// 3 <= nums.length <= 1000
// -1000 <= nums[i] <= 1000
// -104 <= target <= 104
  
// Solution
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int glbCls = 0;
        int glbDiff = Integer.MAX_VALUE;
        int len = nums.length;
        
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                int diff = target - curSum;
                
                if (diff == 0) {
                    return curSum;
                }
                else if (diff > 0) {
                    if (diff < glbDiff) {
                        glbCls = curSum;
                        glbDiff = diff;
                    }
                    
                    left++;
                    
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                }
                else {
                    if (-diff < glbDiff) {
                        glbCls = curSum;
                        glbDiff = -diff;
                    }
                    
                    right--;
                    
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }  
            }
        }
        
        return glbCls;
    }
}
// TC: O(n^2); SC: O(1)
// Success
// Details 
// Runtime: 8 ms, faster than 80.29% of Java online submissions for 3Sum Closest.
// Memory Usage: 43.1 MB, less than 49.08% of Java online submissions for 3Sum Closest.
