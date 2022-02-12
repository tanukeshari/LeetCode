// Easy
// Give a binary string s, 
// return the number of non-empty substrings that have the same number of 0's and 1's, 
// and all the 0's and all the 1's in these substrings are grouped consecutively.

// Substrings that occur multiple times are counted the number of times they occur.

// Example 1:
// Input: s = "00110011"
// Output: 6
  
// Explanation: 
// There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
// Notice that some of these substrings repeat and are counted the number of times they occur.
// Also, 
// "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
  
// Example 2:
// Input: s = "10101"
// Output: 4
  
// Explanation: 
// There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 
// Constraints:
// 1 <= s.length <= 105
// s[i] is either '0' or '1'.
  
// Solution 1
class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int cnt = 0;
        int len = s.length();
        
        for (int i = 0; i < len - 1; i++) {
            char chI = s.charAt(i);
            char chI1 = s.charAt(i + 1);
            if (chI != chI1) {
                int j = 0;
                
                while (0 <= i - j && i + 1 + j < len && chI == s.charAt(i - j) && chI1 == s.charAt(i + 1 + j)) {
                    cnt++;
                    j++;
                }
            }
        }
        
        return cnt;
    }
}
// TC: O(n^2); SC: O(1)
// Success
// Details 
// Runtime: 18 ms, faster than 33.07% of Java online submissions for Count Binary Substrings.
// Memory Usage: 49.2 MB, less than 24.32% of Java online submissions for Count Binary Substrings.

// Solution 2
class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int cntPre = 0;
        int cntCur = 0;
        int cntTotal = 0;
        
        for (int i = 0; i < s.length(); i += cntCur) {
            cntCur = 0;
            
            while (i + cntCur < s.length() && s.charAt(i + cntCur) == s.charAt(i)) {
                cntCur++;
            }
            
            cntTotal += Math.min(cntPre, cntCur);
            cntPre = cntCur;        
        }
        
        return cntTotal;
    }
}
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 9 ms, faster than 78.74% of Java online submissions for Count Binary Substrings.
// Memory Usage: 42.5 MB, less than 70.81% of Java online submissions for Count Binary Substrings.
