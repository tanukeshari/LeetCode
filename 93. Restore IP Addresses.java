// Medium
// A valid IP address consists of exactly four integers separated by single dots. 
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

// For example, 
// "0.1.2.201" and "192.168.1.1" are valid IP addresses, 
// but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
// Given a string s containing only digits, 
// return all possible valid IP addresses that can be formed by inserting dots into s. 
// You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

// Example 1:
// Input: s = "25525511135"
// Output: ["255.255.11.135","255.255.111.35"]

// Example 2:
// Input: s = "0000"
// Output: ["0.0.0.0"]

// Example 3:
// Input: s = "101023"
// Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 
// Constraints:
// 0 <= s.length <= 20
// s consists of digits only.
  
// Solution
class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null) {
            return null;
        }
        
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        if (s.length() == 0) {
            return ans;
        }
        
        helper(ans, sb, s, 0, 0);
        
        return ans;
    }
    
    private void helper(List<String> ans, StringBuilder sb, String s, int index, int level) {
        if (level == 4) {
            if (sb.length() == s.length() + 4) {
                ans.add(sb.substring(0, sb.length() - 1));
            }
            
            return;
        }
        
        
        if (index < s.length()) {
            char ch = s.charAt(index);
            
            sb.append(ch).append('.');
            helper(ans, sb, s, index + 1, level + 1);
            sb.delete(sb.length() - 2, sb.length());
        }
        
        if (index + 1 < s.length()) {
            char ch1 = s.charAt(index);
            char ch2 = s.charAt(index + 1);
            
            if (ch1 > '0') {
                sb.append(ch1).append(ch2).append('.');
                helper(ans, sb, s, index + 2, level + 1);
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        
        if (index + 2 < s.length()) {
            char ch1 = s.charAt(index);
            char ch2 = s.charAt(index + 1);
            char ch3 = s.charAt(index + 2);
            
            if (ch1 == '1' || ((ch1 == '2') && (('0' <= ch2 && ch2 <= '4') || (ch2 == '5' && ('0' <= ch3 && ch3 <= '5'))))) {
                sb.append(ch1).append(ch2).append(ch3).append('.');
                helper(ans, sb, s, index + 3, level + 1);
                sb.delete(sb.length() - 4, sb.length());
            }
        }
    }
}
// TC: O(3^4); SC: O(4)
// Success
// Details 
// Runtime: 2 ms, faster than 91.23% of Java online submissions for Restore IP Addresses.
// Memory Usage: 43 MB, less than 17.99% of Java online submissions for Restore IP Addresses.
