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

// Solution 2, brute force
class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        int len = rating.length;
        
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (rating[i] > rating[j]) {
                        if (rating[j] > rating[k]) {
                            ans++;
                        }
                        else {
                            continue;
                        }
                    }
                    else {
                        if (rating[j] < rating[k]) {
                            ans++;
                        }
                        else {
                            continue;
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}
// TC: O(n^3); SC: O(1)
// TLE

// Solution 3, dp
class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        int len = rating.length;
        
        int[] less = new int[len];
        int[] larger = new int[len];
        
        for (int i = 0; i < len - 1; i++) {
            int lessN = 0;
            int largerN = 0;
            
            for (int j = i + 1; j < len; j++) {
                if (rating[j] > rating[i]) {
                    largerN++;
                }
                else {
                    lessN++;
                }
            }
            
            less[i] = lessN;
            larger[i] = largerN;
        }
        
        for (int k = 0; k < len - 1; k++) {
            for (int l = k + 1; l < len; l++) {
                if (rating[l] > rating[k]) {
                    ans += larger[l];
                }
                else {
                    ans += less[l];
                }
            }
        }
        
        return ans;
    }
}
// TC; O(n^2); SC: O(n)
// Success
// Details 
// Runtime: 28 ms, faster than 77.54% of Java online submissions for Count Number of Teams.
// Memory Usage: 43.7 MB, less than 28.94% of Java online submissions for Count Number of Teams.
