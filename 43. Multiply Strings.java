// Medium
// Given two non-negative integers num1 and num2 represented as strings, 
// return the product of num1 and num2, 
// also represented as a string.

// Note: 
// You must not use any built-in BigInteger library or convert the inputs to integer directly.

// Example 1:
// Input: num1 = "2", num2 = "3"
// Output: "6"
  
// Example 2:
// Input: num1 = "123", num2 = "456"
// Output: "56088"
 
// Constraints:
// 1 <= num1.length, num2.length <= 200
// num1 and num2 consist of digits only.
// Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 
// Solution
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        List<String> interRst = new ArrayList<>();
        int carry = 0;
        
        for (int i = len1 - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            carry = 0;
            
            for (int l = 0; l < len1 - 1 - i; l++) {
                    sb.append(0);
                }
            
            for (int j = len2 - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int tepRst = d1 * d2 + carry;
                sb.append(tepRst % 10);
                carry = tepRst / 10;
            }
            
            if (carry != 0) {
                sb.append(carry);
            }
            
            interRst.add(sb.toString());
        }
        
        String op1 = interRst.get(0);
        
        for (int p = 1; p < interRst.size(); p++) {
            String op2 = interRst.get(p);
            StringBuilder sbAns = new StringBuilder();

            int m = 0;
            int n = 0;
            
            carry = 0;
        
            while (m < op1.length() && n < op2.length()) {
                int nd1 = op1.charAt(m) - '0';
                int nd2 = op2.charAt(n) - '0';
                int tepAns = nd1 + nd2 + carry;
                
                sbAns.append(tepAns % 10);
                carry = tepAns / 10; 
                
                m++;
                n++;
            }
            
            while (m < op1.length()) {
                char nd = op1.charAt(m);
                
                if (carry != 0) {
                    int nd1 = nd - '0'; 
                    nd1 += carry;
                    carry = nd1 / 10;
                    nd1 %= 10;
                    sbAns.append(nd1);
                    m++;
                    
                    continue;
                }
                
                sbAns.append(nd);
                m++;
            }
            
            while (n < op2.length()) {
                char nd = op2.charAt(n);
                
                if (carry != 0) {
                    int nd2 = nd - '0'; 
                    nd2 += carry;
                    carry = nd2 / 10;
                    nd2 %= 10;
                    sbAns.append(nd2);
                    n++;
                    
                    continue;
                }
                
                sbAns.append(nd);
                n++;
            }
            
            if (carry != 0) {
                sbAns.append(carry);
                carry = 0;
            }
            
            op1 = sbAns.toString();
        }
        
        StringBuilder ans = new StringBuilder();
        
        for (int q = op1.length() - 1; q >= 0; q--) {
            ans.append(op1.charAt(q));
        }
        
        return ans.toString();
    }
}
// TC: O(m * n); SC: O(m * n)
// Success
// Details 
// Runtime: 27 ms, faster than 24.91% of Java online submissions for Multiply Strings.
// Memory Usage: 47.6 MB, less than 18.89% of Java online submissions for Multiply Strings.
