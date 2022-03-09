// Medium
// Given a string s, 
// sort it in decreasing order based on the frequency of the characters. 
// The frequency of a character is the number of times it appears in the string.

// Return the sorted string. 
// If there are multiple answers, return any of them.

// Example 1:
// Input: 
// s = "tree"
// Output: 
// "eert"
  
// Explanation: 
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. 
// Therefore "eetr" is also a valid answer.
  
// Example 2:
// Input: 
// s = "cccaaa"
// Output: 
// "aaaccc"
  
// Explanation: 
// Both 'c' and 'a' appear three times, 
// so both "cccaaa" and "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, 
// as the same characters must be together.
  
// Example 3:
// Input: 
// s = "Aabb"
// Output: 
// "bbAa"
  
// Explanation: 
// "bbaA" is also a valid answer, 
// but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.

// Constraints:
// 1 <= s.length <= 5 * 105
// s consists of uppercase and lowercase English letters and digits.
  
// Solution
class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        Map<Character, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int maxCnt = Collections.max(hm.values());
        int lenHM = hm.size();
        List<List<Character>> buckets = new ArrayList<>();
        
        for (int j = 0; j < maxCnt; j++) {
            buckets.add(new ArrayList<Character>());
        }
        
        for (char ch : hm.keySet()) {
            int cnt = hm.get(ch) - 1;
            
            buckets.get(cnt).add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int k = maxCnt - 1; k >= 0; k--) {
            List<Character> bucket = buckets.get(k);
            
            for (char ch : bucket) {       
                for (int frq = k + 1; frq > 0; frq--) {
                    sb.append(ch);
                }
            }
        }
        
        return sb.toString();
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 33 ms, faster than 32.74% of Java online submissions for Sort Characters By Frequency.
// Memory Usage: 54.4 MB, less than 24.23% of Java online submissions for Sort Characters By Frequency.
