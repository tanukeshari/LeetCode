// Medium
// Given an array nums with n objects colored red, 
// white, 
// or blue, 
// sort them in-place so that objects of the same color are adjacent, 
// with the colors in the order red, 
// white, and blue.

// We will use the integers 0, 
// 1, 
// and 2 to represent the color red, 
// white, and blue, respectively.

// You must solve this problem without using the library's sort function.

// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// Example 2:
// Input: nums = [2,0,1]
// Output: [0,1,2]
 
// Constraints:
// n == nums.length
// 1 <= n <= 300
// nums[i] is either 0, 1, or 2.
 
// Follow up:
// Could you come up with a one-pass algorithm using only constant extra space?
  
// Solution
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int c1 = 0;
        int c2 = 0;
        int c3 = nums.length - 1;
        
        while (c2 <= c3) {
            if (nums[c2] == 0) {
                swap(nums, c2, c1);
                c1++;
                c2++;
            }
            else if (nums[c2] == 1) {
                c2++;
            }
            else {
                swap(nums, c2, c3);
                c3--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
// Memory Usage: 42.9 MB, less than 9.62% of Java online submissions for Sort Colors.
