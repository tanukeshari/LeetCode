// Easy
// Given two arrays, 
// write a function to compute their intersection.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]

// Note:
// Each element in the result must be unique.
// The result can be in any order.

// Solution 1
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        return intersection(set1, set2);
    }
    
    public int[] intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] ans = new int[set1.size()];
        int i = 0;
        
        for (int num : set1) {
            if (set2.contains(num)) {
                ans[i++] = num;
            }
        }
        
        return Arrays.copyOf(ans, i);
    }
}
// Success
// Details 
// Runtime: 3 ms, faster than 40.92% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 41 MB, less than 6.35% of Java online submissions for Intersection of Two Arrays.

// Solution 2
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        set1.retainAll(set2);
        
        int[] ans = new int[set1.size()];
        int i = 0;
        
        for (int num : set1) {
            ans[i++] = num;
        }
        
        return ans;
    }
}
// Success
// Details 
// Runtime: 2 ms, faster than 97.32% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 39.2 MB, less than 53.52% of Java online submissions for Intersection of Two Arrays.

// Solution 3
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int[] sh;
        int[] lg;
        
        if (len1 < len2) {
            sh = nums1;
            lg = nums2;
        }
        else {
            sh = nums2;
            lg = nums1;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int num1 : sh) {
            set.add(num1);
        }
        
        Set<Integer> ansSet = new HashSet<>();
        
        for (int num2 : lg) {
            if (set.contains(num2)) {
                ansSet.add(num2);
            }
        }
        
        int[] ans = new int[ansSet.size()];
        int i = 0;
        
        for (int n : ansSet) {
            ans[i] = n;
            i++;
        }
        
        return ans;
    }
}
// TC: O(n + m); SC: O(n)
// Success
// Details 
// Runtime: 5 ms, faster than 50.90% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 44.6 MB, less than 11.02% of Java online submissions for Intersection of Two Arrays.
