// Medium

// Given a string, find the length of the longest substring without repeating characters.

// Example 1:
// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 

// Example 2:
// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
// Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Solution 1
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, n = s.length();
        int[] index = new int[128];
        
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        
        return ans;
    }
}
// TC: O(n): SC: O(n)
// Success
// Details 
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Substring Without Repeating Characters.
// Memory Usage: 39.8 MB, less than 34.68% of Java online submissions for Longest Substring Without Repeating Characters.

// Solution 2
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> hm = new HashMap<>();
        int cnt = 1;
        
        int fast = 1;
        int slow = 0;
        
        hm.put(s.charAt(slow), slow);
        
        while (fast < s.length()) {
            char ch = s.charAt(fast);
            Integer idx = hm.get(ch);
            
            hm.put(ch, fast);
            
            if (idx == null || idx < slow) { 
                cnt = Math.max(cnt, fast - slow + 1);
            }     
            else {
                slow = idx + 1;
            }
            
            fast++;
        }
        
        cnt = Math.max(cnt, fast - slow);
        
        return cnt;
    }
}
// TC: O(n); SC: O(n)
