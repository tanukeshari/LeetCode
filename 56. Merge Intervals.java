// Medium
// Given an array of intervals where intervals[i] = [starti, endi], 
// merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:
// Input: 
// intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: 
// [[1,6],[8,10],[15,18]]

// Explanation: 
// Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

// Example 2:
// Input: 
// intervals = [[1,4],[4,5]]
// Output: 
// [[1,5]]

// Explanation: 
// Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
  
// Solution
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][];
        }
        
        int len = intervals.length;
        
        if (len == 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> ans = new ArrayList<>();
        int[] cur = intervals[0];
        int i = 1;
        
        while (i < len) {
            int[] next = intervals[i];
            
            if (cur[1] < next[0] && cur[0] < next[1]) {
                ans.add(cur);
                cur = next;
            }
            else {
                int left = Math.min(cur[0], next[0]);
                int right = Math.max(cur[1], next[1]);
                int[] temp = new int[] {left, right};
                
                cur = temp;
            }
                
            i++;
        }
        
        ans.add(cur);
                
        return ans.toArray(new int[ans.size()][]);
    }
}
// TC: O(nlogn); SC: O(logn)
// Success
// Details 
// Runtime: 11 ms, faster than 72.76% of Java online submissions for Merge Intervals.
// Memory Usage: 55.3 MB, less than 49.48% of Java online submissions for Merge Intervals.
