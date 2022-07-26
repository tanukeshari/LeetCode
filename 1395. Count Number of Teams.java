// Medium
// There are n soldiers standing in a line. 
// Each soldier is assigned a unique rating value.

// You have to form a team of 3 soldiers amongst them under the following rules:
// Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
// A team is valid if: 
// (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
// Return the number of teams you can form given the conditions. 
// (soldiers can be part of multiple teams).

// Example 1:
// Input: rating = [2,5,3,4,1]
// Output: 3
  
// Explanation: 
// We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1). 

// Example 2:
// Input: rating = [2,1,3]
// Output: 0

// Explanation: 
// We can't form any team given the conditions.

// Example 3:
// Input: rating = [1,2,3,4]
// Output: 4
 
// Constraints:
// n == rating.length
// 3 <= n <= 1000
// 1 <= rating[i] <= 105
// All the integers in rating are unique.
  
// Solution 1, dfs
class Solution {
    public static int numTeams(int[] rating) {
        boolean[] asd = new boolean[] {false};
        int[] ans = new int[] {0};
        dfs(rating, 0, 0, asd, 0, ans);
        
        return ans[0];
    }
    
    private static void dfs(int[] rating, int idx, int cnt, boolean[] asd, int prev, int[] ans) {
        if (cnt == 3) {
            ans[0]++;
            
            return;
        }
        
        for (int i = idx; i < rating.length; i++) {
            if (cnt == 0) {
                dfs(rating, i + 1, cnt + 1, asd, rating[i], ans);
            }
            
            if (cnt == 1) {
                if (rating[i] > prev) {
                    asd[0] = true;
                }
                else {
                    asd[0] = false;
                }
                
                dfs(rating, i + 1, cnt + 1, asd, rating[i], ans);
            }
            
            if (cnt == 2) {
                if (asd[0] && rating[i] > prev) {
                    dfs(rating, i + 1, cnt + 1, asd, rating[i], ans);
                }
                else if (!asd[0] && rating[i] < prev) {
                    dfs(rating, i + 1, cnt + 1, asd, rating[i], ans);
                }
                else {
                    continue;
                }
            }           
        }
    }
}
// TC: O(n^3); SC: O(3)
// TLE
