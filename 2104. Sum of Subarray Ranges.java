// Medium
// You are given an integer array nums. 
// The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
// Return the sum of all subarray ranges of nums.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,2,3]
// Output: 4
  
// Explanation: 
// The 6 subarrays of nums are the following:
// [1], range = largest - smallest = 1 - 1 = 0 
// [2], range = 2 - 2 = 0
// [3], range = 3 - 3 = 0
// [1,2], range = 2 - 1 = 1
// [2,3], range = 3 - 2 = 1
// [1,2,3], range = 3 - 1 = 2
// So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
  
// Example 2:
// Input: nums = [1,3,3]
// Output: 4
  
// Explanation: 
// The 6 subarrays of nums are the following:
// [1], range = largest - smallest = 1 - 1 = 0
// [3], range = 3 - 3 = 0
// [3], range = 3 - 3 = 0
// [1,3], range = 3 - 1 = 2
// [3,3], range = 3 - 3 = 0
// [1,3,3], range = 3 - 1 = 2
// So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
  
// Example 3:
// Input: nums = [4,-2,-3,4,1]
// Output: 59
  
// Explanation: 
// The sum of all subarray ranges of nums is 59.
 
// Constraints:
// 1 <= nums.length <= 1000
// -109 <= nums[i] <= 109

// Follow-up: 
// Could you find a solution with O(n) time complexity?

// Solution 1
class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            long min = nums[i];
            long max = nums[i];
            
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }
        }
        
        return ans;
    }
}
// TC: O(n^2); SC: O(n)
// Success
// Details 
// Runtime: 23 ms, faster than 76.52% of Java online submissions for Sum of Subarray Ranges.
// Memory Usage: 44.6 MB, less than 79.36% of Java online submissions for Sum of Subarray Ranges.

// Solution 2
class Solution {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        int[] leftLess = new int[len];
        Arrays.fill(leftLess, -1);
        int[] rightLess = new int[len];
        Arrays.fill(rightLess, len);
        int[] leftMore = new int[len];
        Arrays.fill(leftMore, -1);
        int[] rightMore = new int[len];
        Arrays.fill(rightMore, len);
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(0);
        
        long ans = 0;
        
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peekFirst()]) {
                rightLess[stack.peekFirst()] = i;
                stack.pollFirst();
            }
            
            stack.offerFirst(i);
        }
        
        stack = new ArrayDeque<>();
        stack.offerFirst(len - 1);
        
        for (int j = len - 2; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] < nums[stack.peekFirst()]) {
                leftLess[stack.peekFirst()] = j;
                stack.pollFirst();
            }
            
            stack.offerFirst(j);
        }
        
        stack = new ArrayDeque<>();
        stack.offerFirst(0);
        
        for (int k = 1; k < len; k++) {
            while (!stack.isEmpty() && nums[k] >= nums[stack.peekFirst()]) {
                rightMore[stack.peekFirst()] = k;
                stack.pollFirst();
            }
            
            stack.offerFirst(k);
        }
        
        stack = new ArrayDeque<>();
        stack.offerFirst(len - 1);
        
        for (int l = len - 2; l >= 0; l--) {
            while (!stack.isEmpty() && nums[l] > nums[stack.peekFirst()]) {
                leftMore[stack.peekFirst()] = l;
                stack.pollFirst();
            }
            
            stack.offerFirst(l);
        }
        
        for (int m = 0; m < len; m++) {
            ans += 1L * nums[m] * (m - leftMore[m]) * (rightMore[m] - m);
            ans -= 1L * nums[m] * (m - leftLess[m]) * (rightLess[m] - m);
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 15 ms, faster than 93.11% of Java online submissions for Sum of Subarray Ranges.
// Memory Usage: 47.6 MB, less than 15.48% of Java online submissions for Sum of Subarray Ranges.
