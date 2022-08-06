// Hard
// Given n non-negative integers representing an elevation map where the width of each bar is 1, 
// compute how much water it can trap after raining.

// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6

// Explanation: 
// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
// In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9
 
// Constraints:
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105

// Solution 1
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        int ans = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                }
                else {
                    ans += left_max - height[left];
                } 
                ++left;
            }
            
            else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                }
                else {
                    ans += right_max - height[right];
                }
                --right;      
            }
        }
        return ans;
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 90.66% of Java online submissions for Trapping Rain Water.
// Memory Usage: 38.7 MB, less than 13.14% of Java online submissions for Trapping Rain Water.

// Solution 2
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        int leftHighest = height[0];
        int rightHighest = height[len - 1];
        
        for (int i = 0; i < len - 1; i++) {
            left[i + 1] = leftHighest;
            leftHighest = Math.max(leftHighest, height[i + 1]);
                
            right[len - 2 - i] = rightHighest;
            rightHighest = Math.max(rightHighest, height[len - 2 - i]);
        }
        
        int ans = 0;
        
        for (int j = 0; j < len; j++) {
            int h = Math.min(left[j], right[j]);
            if (height[j] < h) {
                ans += h - height[j];
            }
             
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 2 ms, faster than 57.61% of Java online submissions for Trapping Rain Water.
// Memory Usage: 49.8 MB, less than 9.62% of Java online submissions for Trapping Rain Water.

// Solution 3
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int leftMax = height[0];
        int rightMax = height[len - 1];
        
        for (int i = 1; i < len; i++) {
            left[i] = leftMax;
            right[len - 1 - i] = rightMax;
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[len - 1 - i]);
        }
        
        int ans = 0;
        
        for (int j = 0; j < len; j++) {
            int h = Math.min(left[j], right[j]);
            
            if (height[j] < h) {
                ans += h - height[j];
            }
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 2 ms, faster than 59.38% of Java online submissions for Trapping Rain Water.
// Memory Usage: 49.3 MB, less than 24.56% of Java online submissions for Trapping Rain Water.
