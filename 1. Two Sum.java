// Easy

// Given an array of integers nums and an integer target, 
// return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, 
// and you may not use the same element twice.

// You can return the answer in any order. 

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, 
// we return [0, 1].
  
// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 
// Constraints:
// 2 <= nums.length <= 10^4
// -10^9 <= nums[i] <= 10^9
// -10^9 <= target <= 10^9
// Only one valid answer exists.
 
// Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

// Solution 1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        
        return ans;
    }
}

// TC: O(n^2); SC: O(1)
// Success
// Details 
// Runtime: 72 ms, faster than 17.25% of Java online submissions for Two Sum.
// Memory Usage: 41.6 MB, less than 35.48% of Java online submissions for Two Sum.


// Solution 2
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            int temp = target - nums[i];
            
            if (complement.containsKey(temp)) {
                return new int[] {complement.get(temp), i};
            }
            
            complement.put(nums[i], i);
        }
        
        return null;
    }
}

// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 2 ms, faster than 76.47% of Java online submissions for Two Sum.
// Memory Usage: 42.6 MB, less than 18.77% of Java online submissions for Two Sum.

// Solution 3
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        
        int len = nums.length;
        
        if (len == 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(nums[0], 0);
        
        for (int i = 1; i < len; i++) {
            int diff = target - nums[i];
            Integer idx = map.get(diff);
            
            if (idx != null) {
                return new int[] {idx, i};
            }
            
            map.put(nums[i], i);
        }
        
        return null;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 1 ms, faster than 99.80% of Java online submissions for Two Sum.
// Memory Usage: 42 MB, less than 64.89% of Java online submissions for Two Sum.
