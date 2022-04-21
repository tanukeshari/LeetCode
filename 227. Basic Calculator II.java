// Medium
// Given a string s which represents an expression, 
// evaluate this expression and return its value. 

// The integer division should truncate toward zero.
// You may assume that the given expression is always valid. 
// All intermediate results will be in the range of [-231, 231 - 1].

// Note: 
// You are not allowed to use any built-in function which evaluates strings as mathematical expressions, 
// such as eval().

// Example 1:
// Input: 
// s = "3+2*2"
// Output: 
// 7
    
// Example 2:
// Input: 
// s = " 3/2 "
// Output: 
// 1
    
// Example 3:
// Input: 
// s = " 3+5 / 2 "
// Output: 
// 5
 
// Constraints:
// 1 <= s.length <= 3 * 105
// s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
// s represents a valid expression.
// All the integers in the expression are non-negative integers in the range [0, 231 - 1].
// The answer is guaranteed to fit in a 32-bit integer.
    
// Solution 1
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0, len = s.length(), number = 0;
        char operator = '+';
        
        if (s == null || len == 0) {
            return 0;
        }
        
        for (int i = 0; i < len; i++) {
            char cur_char = s.charAt(i);
            
            if (Character.isDigit(cur_char)) {
                number = number * 10 + (cur_char - '0');
            }
            if (!Character.isDigit(cur_char) && !Character.isWhitespace(cur_char) || i == len - 1) {
                if (operator == '+') {
                    stack.push(number);
                }
                else if (operator == '-') {
                    stack.push(-number);
                }
                else if (operator == '*') {
                    stack.push(stack.pop() * number);
                }
                else if (operator == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                operator = cur_char;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}

// Success
// Details 
// Runtime: 20 ms, faster than 15.33% of Java online submissions for Basic Calculator II.
// Memory Usage: 42.1 MB, less than 15.14% of Java online submissions for Basic Calculator II.

// Solution 2
class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int ans = 0, number = 0, last = 0;
        int len = s.length();
        char operator = '+';

        for (int i = 0; i < len; i++) {
            char cur_char = s.charAt(i);
            
            if (Character.isDigit(cur_char)) {
                number = number * 10 + (cur_char - '0');
            }
            
            if (!Character.isDigit(cur_char) && !Character.isSpace(cur_char) || i == len - 1) {
                if (operator == '+' || operator == '-') {
                    ans += last;
                    last = operator == '+' ? number : -number;
                }
                else if (operator == '*') {
                    last = last * number;
                }
                else if (operator == '/') {
                    last = last / number;
                }
                operator = cur_char;
                number = 0;
            } 
        }
        ans += last;
        return ans;
    }
}

// Success
// Details 
// Runtime: 6 ms, faster than 92.92% of Java online submissions for Basic Calculator II.
// Memory Usage: 38.8 MB, less than 96.14% of Java online submissions for Basic Calculator II.

// Solution 3
class Solution {
    public int calculate(String s) {
        Deque<Integer> diQ = new ArrayDeque<>();
        Queue<Character> opQ = new ArrayDeque<>();
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (cur == ' ') {
                continue;
            }
            else if (Character.isDigit(cur)) {
                int[] rslt = new int[] {cur - '0'};
                int idx = extractWholeNumber(s, i + 1, rslt);
              
                diQ.offerFirst(rslt[0]);
                i = idx - 1;
            }
            else {
                if (cur == '*') {
                    int temp = diQ.pollFirst();
                    int[] rslt = new int[] {0};
                    int idx = extractWholeNumber(s, i + 1, rslt);
                    
                    temp *= rslt[0];
                    diQ.offerFirst(temp);
                    i = idx - 1;
                }
                else if (cur == '/') {
                    int temp = diQ.pollFirst();
                    int[] rslt = new int[] {0};
                    int idx = extractWholeNumber(s, i + 1, rslt);
                    
                    temp /= rslt[0];
                    diQ.offerFirst(temp);
                    i = idx - 1;
                }
                else if (cur == '+') {
                    opQ.offer(cur);
                }
                else {
                    opQ.offer(cur);
                }
            }
        }
        
        ans = diQ.pollLast();
            
        while (!diQ.isEmpty()) {
            int curNum = diQ.pollLast();
            char operator = opQ.poll();

            if (operator == '+') {
                ans += curNum;
            }
            else {
                ans -= curNum;
            }
        }

        return ans;
    }
    
    private int extractWholeNumber(String s, int idx, int[] rslt) {
        while (idx < s.length()) {
            char cur = s.charAt(idx);
            
            if (cur == ' ') {
                idx++;
                
                continue;
            }
            
            if (!Character.isDigit(cur)) {
                break;
            }
            
            rslt[0] = rslt[0] * 10 + cur - '0';
            idx++;
        }
        
        return idx;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 28 ms, faster than 28.87% of Java online submissions for Basic Calculator II.
// Memory Usage: 48.5 MB, less than 14.55% of Java online submissions for Basic Calculator II.
