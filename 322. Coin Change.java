// Medium
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the fewest number of coins that you need to make up that amount. 
// If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

// Example 1:
// Input: 
// coins = [1,2,5], 
// amount = 11
// Output: 
// 3
  
// Explanation: 
// 11 = 5 + 5 + 1
  
// Example 2:
// Input: 
// coins = [2], 
// amount = 3
// Output: 
// -1
  
// Example 3:
// Input: 
// coins = [1], 
// amount = 0
// Output: 
// 0
 
// Constraints:
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
  
// Solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        int max = amount + 1;
        int[] cnt = new int[max];
        Arrays.fill(cnt, max);
        
        return dp(coins, amount, cnt);
    }
    
    private int dp(int[] coins, int amount, int[] cnt) {
        cnt[0] = 0;
        
        for (int val = 1; val < cnt.length; val++) {
            for (int coin : coins) {
                if (coin <= val) {
                    cnt[val] = Math.min(cnt[val], cnt[val - coin] + 1);
                }
            }
        }
        
        return cnt[amount] > amount ? -1 : cnt[amount];
    }
}
// TC: O(n * s); SC: O(s)
// Success
// Details 
// Runtime: 28 ms, faster than 48.27% of Java online submissions for Coin Change.
// Memory Usage: 44.7 MB, less than 75.92% of Java online submissions for Coin Change.
