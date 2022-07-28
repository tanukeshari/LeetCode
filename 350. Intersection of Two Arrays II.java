// Easy
// Given two arrays, 
// write a function to compute their intersection.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.

// Follow up:
// What if the given array is already sorted? 
// How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, 
// and the memory is limited such that you cannot load all elements into the memory at once?

// Solution 1
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        int num1_len = nums1.length;
        int num2_len = nums2.length;
        
        if (num2_len < num1_len) {
            return intersect(nums2, nums1);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int k = 0;
        
        for (int num : nums2) {
            int cnt = map.getOrDefault(num, 0);
            
            if (cnt > 0) {
                nums1[k] = num;
                map.put(num, cnt - 1);
                k++;
            }
        }
        
        return Arrays.copyOf(nums1, k);
        
    }
}
// Success
// Details 
// Runtime: 2 ms, faster than 95.76% of Java online submissions for Intersection of Two Arrays II.
// Memory Usage: 39.7 MB, less than 18.65% of Java online submissions for Intersection of Two Arrays II.

// Solution 2
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if (len1 == 0 || len2 == 0) {
            return new int[0];
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                i++;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else {
                nums1[k] = nums2[j];
                i++;
                j++;
                k++;
            }
        }
        
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
// TC: O(nlgn + mlgm); SC: O(1)
// Success
// Details 
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Intersection of Two Arrays II.
// Memory Usage: 39 MB, less than 80.24% of Java online submissions for Intersection of Two Arrays II.

// Solution 3
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if (len1 == 0 || len2 == 0) {
            return new int[0];
        }
        
        if (len1 > len2) {
            return intersect(nums2, nums1);
        }
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        for (int num1 : nums1) {
            hm.put(num1, hm.getOrDefault(num1, 0) + 1);
        }
        
        int i = 0;
        
        for (int num2 : nums2) {
            Integer cnt = hm.get(num2);
            
            if (cnt != null) {
                nums1[i] = num2;
                i++;
                cnt--;
                
                if (cnt > 0) {
                    hm.put(num2, cnt);
                }
                else {
                    hm.remove(num2);
                }   
            }
        }
        
        return Arrays.copyOfRange(nums1, 0, i);
    }
}
// TC: O(n + m): SC: O(min(n, m))
// Success
// Details 
// Runtime: 3 ms, faster than 71.89% of Java online submissions for Intersection of Two Arrays II.
// Memory Usage: 44.6 MB, less than 5.37% of Java online submissions for Intersection of Two Arrays II.

// Solution 4
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();
        
        for (int n1 : nums1) {
            hm1.put(n1, hm1.getOrDefault(n1, 0) + 1);
        }
        
        for (int n2 : nums2) {
            hm2.put(n2, hm2.getOrDefault(n2, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int n : hm1.keySet()) {
            if (hm2.containsKey(n)) {
                int cnt = Math.min(hm1.get(n), hm2.get(n));
                
                while (cnt > 0) {
                    list.add(n);
                    cnt--;
                }
            }
        }
        
        int[] ans = new int[list.size()];
        int i = 0;
        
        for (int num : list) {
            ans[i] = num;
            i++;
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 5 ms, faster than 48.20% of Java online submissions for Intersection of Two Arrays II.
// Memory Usage: 44.8 MB, less than 7.17% of Java online submissions for Intersection of Two Arrays II.
