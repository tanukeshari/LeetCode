// Medium
// Given the root of a binary tree, 
// imagine yourself standing on the right side of it, 
// return the values of the nodes you can see ordered from top to bottom.

// Example 1:
// Input: 
// root = [1,2,3,null,5,null,4]
// Output: 
// [1,3,4]

// Example 2:
// Input: 
// root = [1,null,3]
// Output: 
// [1,3]

// Example 3:
// Input: 
// root = []
// Output: 
// []
 
// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
  
// Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }  
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int len = 1;
        int curLen = 0;
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            len--;
            
            if (cur.left != null) {
                q.offer(cur.left);
                curLen++;
            }
            
            if (cur.right != null) {
                q.offer(cur.right);
                curLen++;
            }
            
            if (len == 0) {
                ans.add(cur.val);
                len = curLen;
                curLen = 0;
            } 
        }
        
        
        return ans;
    }
}
// TC: O(n); SC: O(d)
// Success
// Details 
// Runtime: 1 ms, faster than 91.99% of Java online submissions for Binary Tree Right Side View.
// Memory Usage: 43.1 MB, less than 16.97% of Java online submissions for Binary Tree Right Side View.
