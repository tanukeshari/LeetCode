// Medium
// Given two strings s and p, 
// return an array of all the start indices of p's anagrams in s. 
// You may return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
// typically using all the original letters exactly once.

// Example 1:
// Input: s = "cbaebabacd", 
// p = "abc"
// Output: [0,6]

// Explanation:
// The substring with start index = 0 is "cba", 
// which is an anagram of "abc".
// The substring with start index = 6 is "bac", 
// which is an anagram of "abc".
  
// Example 2:
// Input: s = "abab", 
// p = "ab"
// Output: [0,1,2]

// Explanation:
// The substring with start index = 0 is "ab", 
// which is an anagram of "ab".
// The substring with start index = 1 is "ba", 
// which is an anagram of "ab".
// The substring with start index = 2 is "ab", 
// which is an anagram of "ab".

// Constraints:
// 1 <= s.length, 
// p.length <= 3 * 104
// s and p consist of lowercase English letters.
 
// Solution
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return null;
        }
        
        List<Integer> ans = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();
        
        if (lenS == 0 || lenP == 0 || lenS < lenP) {
            return ans;
        }
        
        Map<Character, Integer> map = mapConstruction(p);
        int match = 0;
        
        for (int i = 0; i < lenS; i++) {
            char ch = s.charAt(i);
            Integer cnt = map.get(ch);
            
            if (cnt != null) {
                map.put(ch, cnt - 1);
                
                if (cnt == 1) {
                    match++;
                }
            }
            
            if (i >= lenP) {
                ch = s.charAt(i - lenP);
                cnt = map.get(ch);
                
                if (cnt != null) {
                    map.put(ch, cnt + 1);
                    
                    if (cnt == 0) {
                        match--;
                    }
                }
            }
            
            if (match == map.size()) {
                ans.add(i - lenP + 1);
            }    
        }
        
        return ans;      
    }
    
    private Map<Character, Integer> mapConstruction(String p) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        return map;
    }
}
// TC: O(n): SC: O(n)
// Success
// Details 
// Runtime: 38 ms, faster than 34.15% of Java online submissions for Find All Anagrams in a String.
// Memory Usage: 47.7 MB, less than 42.71% of Java online submissions for Find All Anagrams in a String.
