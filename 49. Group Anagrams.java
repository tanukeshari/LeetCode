// Medium
// Given an array of strings, 
// group anagrams together.

// Example:
// Input: 
// ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]

// Note:
// All inputs will be in lowercase.
// The order of your output does not matter.

// Solution 1
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return null;
        }
        
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> hm = new HashMap<>();
        
        for (String s : strs) {
            int[] cnt = new int[26];
            
            for (char ch : s.toCharArray()) {
                cnt[ch - 'a']++;
            }
            
            StringBuilder coding = new StringBuilder();
            
            for (int i = 0; i < 26; i++) {
                coding.append('#');
                coding.append(cnt[i]);
            }
            
            String key = coding.toString();
            List<String> val = hm.get(key);
            
            if (val == null) {
                val = new ArrayList<>();
            }
            
            val.add(s);
            hm.put(key, val);
        }
        
        return new ArrayList(hm.values());
    }
}
// TC: O(nk); SC: O(nk)
// Success
// Details 
// Runtime: 16 ms, faster than 39.44% of Java online submissions for Group Anagrams.
// Memory Usage: 42.9 MB, less than 63.33% of Java online submissions for Group Anagrams.

// Solution 2
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return null;
        }
        
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> hm = new HashMap<>();
        
        for (String s : strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String key = String.valueOf(sArr);
            List<String> val = hm.get(key);
            
            if (val == null) {
                val = new ArrayList<>();
                
            }
            
            val.add(s);
            hm.put(key, val);
        }
        
        return new ArrayList<>(hm.values());
    }
}
// TC: O(nklgk); SC: O(nk)
// Success
// Details 
// Runtime: 15 ms, faster than 41.17% of Java online submissions for Group Anagrams.
// Memory Usage: 55.6 MB, less than 60.97% of Java online submissions for Group Anagrams.
