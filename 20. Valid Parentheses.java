// Easy
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
// determine if the input string is valid.

// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
 
// Example 1:
// Input: 
// s = "()"
// Output: 
// true
  
// Example 2:
// Input: 
// s = "()[]{}"
// Output: 
// true
  
// Example 3:
// Input: 
// s = "(]"
// Output: 
// false
 
// Constraints:
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
  
// Solution
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char paren = s.charAt(i);
            
            if (paren == '{' || paren == '[' || paren == '(') {
                stack.offerFirst(paren);
            }
            else {
                if (paren == '}') {
                    if (stack.isEmpty() || stack.pollFirst() != '{') {
                        return false;
                    }
                }
                else if (paren == ']') {
                    if (stack.isEmpty() || stack.pollFirst() != '[') {
                        return false;
                    }
                }
                else {
                    if (stack.isEmpty() || stack.pollFirst() != '(') {
                        return false;
                    }
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 1 ms, faster than 99.44% of Java online submissions for Valid Parentheses.
// Memory Usage: 40 MB, less than 96.85% of Java online submissions for Valid Parentheses.
