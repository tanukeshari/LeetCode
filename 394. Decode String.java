// Medium
// Given an encoded string, 
// return its decoded string.
// The encoding rule is: 
// k[encoded_string], 
// where the encoded_string inside the square brackets is being repeated exactly k times. 
// Note that k is guaranteed to be a positive integer.
// You may assume that the input string is always valid; 
// No extra white spaces, 
// square brackets are well-formed, etc.
// Furthermore, 
// you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
// For example, 
// there won't be input like 3a or 2[4].

// Example 1:
// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"

// Example 2:
// Input: s = "3[a2[c]]"
// Output: "accaccacc"

// Example 3:
// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"

// Example 4:
// Input: s = "abc3[cd]xyz"
// Output: "abccdcdcdxyz"
 
// Constraints:
// 1 <= s.length <= 30
// s consists of lowercase English letters, digits, and square brackets '[]'.
// s is guaranteed to be a valid input.
// All the integers in s are in the range [1, 300].

// Solution 1
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            List<Character> decodedString = new ArrayList<>();
            
            if (s.charAt(i) == ']') {
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());    
                }    
                
                stack.pop();
                int k = 0, base = 1;
                
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k += (stack.pop() - '0') * base;
                    base *= 10;
                }
                
                while (k > 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }         
                    k--;
                }
            }         
            else {
                stack.push(s.charAt(i));
            } 
        }
            
        char[] result = new char[stack.size()];
            
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);  
    }
}
// Success
// Details 
// Runtime: 1 ms, faster than 62.33% of Java online submissions for Decode String.
// Memory Usage: 36.7 MB, less than 97.79% of Java online submissions for Decode String.

// Solution 2
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> char_stack = new Stack<>();
        Stack<Integer> int_stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int k = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            }
            else if (ch == '[') {
                int_stack.push(k);
                char_stack.push(result);
                k = 0;
                result = new StringBuilder();
            }
            else if (ch == ']') {
                StringBuilder temp = new StringBuilder();
                temp.append(char_stack.pop());
                
                for (int i = int_stack.pop(); i > 0; i--) {
                    temp.append(result);
                }
                result = new StringBuilder(temp);              
            }
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
// Memory Usage: 37.2 MB, less than 52.68% of Java online submissions for Decode String.

// Solution 3
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int[] sh;
        int[] lg;
        
        if (len1 < len2) {
            sh = nums1;
            lg = nums2;
        }
        else {
            sh = nums2;
            lg = nums1;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int num1 : sh) {
            set.add(num1);
        }
        
        Set<Integer> ansSet = new HashSet<>();
        
        for (int num2 : lg) {
            if (set.contains(num2)) {
                ansSet.add(num2);
            }
        }
        
        int[] ans = new int[ansSet.size()];
        int i = 0;
        
        for (int n : ansSet) {
            ans[i] = n;
            i++;
        }
        
        return ans;
    }
}
// TC: O(n + m); SC: O(n)
// Success
// Details 
// Runtime: 5 ms, faster than 50.90% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 44.6 MB, less than 11.02% of Java online submissions for Intersection of Two Arrays.
