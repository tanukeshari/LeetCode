// Easy
// Given an integer array nums, 
// move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

// Example 1:
// Input: 
// nums = [0,1,0,3,12]
// Output: 
// [1,3,12,0,0]

// Example 2:
// Input: 
// nums = [0]
// Output: 
// [0]
 
// Constraints:
// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
 
// Follow up: Could you minimize the total number of operations done?
  
// Solution
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                len--;
                moveForward(nums, i, len);
                nums[len] = 0;
                i--;
            }
        }
    }
    
    private void moveForward(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
// TC: O(n^2): SC: O(1)
// Success
// Details 
// Runtime: 53 ms, faster than 8.85% of Java online submissions for Move Zeroes.
// Memory Usage: 43.9 MB, less than 80.79% of Java online submissions for Move Zeroes.
