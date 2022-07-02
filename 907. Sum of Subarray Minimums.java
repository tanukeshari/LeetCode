// Medium
// Given an array of integers arr, 
// find the sum of min(b), 
// where b ranges over every (contiguous) subarray of arr. 
// Since the answer may be large, 
// return the answer modulo 109 + 7.

// Example 1:
// Input: arr = [3,1,2,4]
// Output: 17
  
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.
  
// Example 2:
// Input: arr = [11,81,94,43,3]
// Output: 444
 
// Constraints:
// 1 <= arr.length <= 3 * 104
// 1 <= arr[i] <= 3 * 104
  
// Solution
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] leftLess = new int[arr.length];
        Arrays.fill(leftLess, -1);
        int[] rightLess = new int[arr.length];
        Arrays.fill(rightLess, arr.length);
        
        Deque<Integer> leftStack = new ArrayDeque<>();
        leftStack.offerFirst(arr.length - 1);
        Deque<Integer> rightStack = new ArrayDeque<>();
        rightStack.offerFirst(0);
        
        long ans = 0;
        int m = (int) 1e9 + 7;
        
        for (int i = 1; i < arr.length; i++) {
            while (!rightStack.isEmpty() && arr[i] < arr[rightStack.peekFirst()]) {
                rightLess[rightStack.peekFirst()] = i;
                rightStack.pollFirst();
            }
            
            rightStack.offerFirst(i);
        }
        
        for (int j = arr.length - 2; j >= 0; j--) {
            while (!leftStack.isEmpty() && arr[j] <= arr[leftStack.peekFirst()]) {
                leftLess[leftStack.peekFirst()] = j;
                leftStack.pollFirst();
            }
            
            leftStack.offerFirst(j);
        }
        
        for (int k = 0; k < arr.length; k++) {
            long temp = 1L * arr[k] * (k - leftLess[k]) % m * (rightLess[k] - k) % m;
            ans += temp;
            ans %= m;            
        }
        
        return (int) ans % m;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 33 ms, faster than 85.11% of Java online submissions for Sum of Subarray Minimums.
// Memory Usage: 50.3 MB, less than 81.39% of Java online submissions for Sum of Subarray Minimums.
