// Easy
// Given two non-negative integers num1 and num2 represented as string, 
// return the sum of num1 and num2.

// Note:
// The length of both num1 and num2 is < 5100.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.

// Solution 1
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == "0") {
            return num2;
        }
        
        if (num2 == "0") {
            return num1;
        }
        
        StringBuilder ans = new StringBuilder();
        
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int temp = x1 + x2 + carry;  
            int value = temp % 10;
            carry = temp / 10;      
            ans.append(value);
            --p1;
            --p2;
        }
        
        if (carry > 0) {
            ans.append(carry);
        }
         
        ans.reverse();
        
        return ans.toString();     
    }
}
// TC: O(max(len1, len2)); SC: O(max(len1, len2))
// Success
// Details 
// Runtime: 2 ms, faster than 91.59% of Java online submissions for Add Strings.
// Memory Usage: 39.5 MB, less than 15.27% of Java online submissions for Add Strings.

// Solution 2
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return num1 == null ? num2 : num1;
        }
        
        int n1 = num1.length();
        int n2 = num2.length();
        
        if (n1 == 0 || n2 == 0) {
            return n1 == 0 ? num2 : num1;
        }
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (n1 > 0 || n2 > 0) {
            int d1 = n1 > 0 ? num1.charAt(n1 - 1) - '0' : 0;
            int d2 = n2 > 0 ? num2.charAt(n2 - 1) - '0' : 0;
            
            int sum = d1 + d2 + carry;
            
            int curDdt = sum % 10;
            carry = sum / 10;
            
            sb.append(curDdt);
            n1--;
            n2--;
        }
        
        if (carry != 0) {
            sb.append(carry);
        }
        
        
        return sb.reverse().toString();
    }
}
// TC: O(max(len1, len2)); SC: O(max(len1, len2))
// Success
// Details 
// Runtime: 2 ms, faster than 89.23% of Java online submissions for Add Strings.
// Memory Usage: 42.1 MB, less than 92.56% of Java online submissions for Add Strings.
