// Medium

// Given an array nums of n integers where n > 1,  
// return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Example:
// Input:  
// [1,2,3,4]
// Output: 
// [24,12,8,6]

// Constraint: 
// It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

// Note: 
// Please solve it without division and in O(n).

// Follow up:
// Could you solve it with constant space complexity? 
// (The output array does not count as extra space for the purpose of space complexity analysis.)

// Solution 1
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];
        
        L[0] = 1;
        for (int i = 1; i < length; ++i) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; --i) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        
        for (int i = 0; i < length; ++i) {
            answer[i] = R[i] * L[i];
        }
        return answer;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 2 ms, faster than 35.16% of Java online submissions for Product of Array Except Self.
// Memory Usage: 52.3 MB, less than 5.02% of Java online submissions for Product of Array Except Self.

// Solution 2
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }
        
        int len = nums.length;
        
        if (len == 0) {
            return new int[0];
        }
        
        int[] ans = new int[len];
        ans[0] = 1;
        
        for (int i = 1; i < len; i++) {
            ans[i] = nums[i - 1] * ans[i - 1]; 
        }
        
        
        for (int j = len - 2; j >= 0; j--) {
            ans[j] = ans[j] * nums[j + 1];
            nums[j] *= nums[j + 1];
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 2 ms, faster than 79.21% of Java online submissions for Product of Array Except Self.
// Memory Usage: 57.8 MB, less than 52.33% of Java online submissions for Product of Array Except Self.
