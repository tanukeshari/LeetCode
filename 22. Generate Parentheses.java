// Medium

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
 //  "(())()",
//   "()(())",
//   "()()()"
// ]

// Solution 1
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    
    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur);
            return;
        }
        
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 89.18% of Java online submissions for Generate Parentheses.
// Memory Usage: 39.7 MB, less than 22.21% of Java online submissions for Generate Parentheses.

// Solution 2
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        
        dfs(n, 0, 0, 0, sb, stack, ans);
        
        return ans;
    }
    
    private void dfs(int n, int cnt, int leftCnt, int rightCnt, StringBuilder sb, Deque<Character> stack, List<String> ans) {
        if (cnt == 2 * n) {
            ans.add(sb.toString());
            
            return;
        }
        
        if (leftCnt < n) {
            sb.append('(');
            stack.offerFirst('(');
            dfs(n, cnt + 1, leftCnt + 1, rightCnt, sb, stack, ans);
            sb.deleteCharAt(sb.length() - 1);
            stack.pollFirst();
        }
           
        if (rightCnt < n && !stack.isEmpty() && stack.peekFirst() == '(') {
            sb.append(')');
            stack.pollFirst();
            dfs(n, cnt + 1, leftCnt, rightCnt + 1, sb, stack, ans);
            sb.deleteCharAt(sb.length() - 1);
            stack.offerFirst('(');
        }
    }
}
// TC: O(2^(2*n)); SC: O(2 * n)
// Success
// Details 
// Runtime: 1 ms, faster than 97.44% of Java online submissions for Generate Parentheses.
// Memory Usage: 42.2 MB, less than 92.31% of Java online submissions for Generate Parentheses.
