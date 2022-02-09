// Medium
// Given a collection of numbers, 
// nums, 
// that might contain duplicates, 
// return all possible unique permutations in any order.

// Example 1:
// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
 
// Example 2:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Constraints:
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
  
// Solution
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return null;
        }
        
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
                
        permuteHelper(ans, nums, 0, len);
        
        return ans;
    }
    
    private void permuteHelper(List<List<Integer>> ans, int[] nums, int start, int len) {
        if (start == len) {
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i < len; i++) {
                temp.add(nums[i]);
            }
            
            ans.add(temp);
            
            return;
        }
        
        Set<Integer> used = new HashSet<>();
        
        for (int i = 0; i < len - start; i++) {
            if (used.contains(nums[start + i])) {
                continue;
            }
            
            used.add(nums[start + i]);
            
            swap(nums, start, start + i);
            permuteHelper(ans, nums, start + 1, len);
            swap(nums, start, start + i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// TC: O(n!); SC: O(n^2)
