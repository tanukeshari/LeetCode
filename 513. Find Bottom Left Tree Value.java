// Medium
// Given the root of a binary tree, 
// return the leftmost value in the last row of the tree.

// Example 1:
// Input: root = [2,1,3]
// Output: 1
  
// Example 2:
// Input: root = [1,2,3,4,null,5,6,null,null,7]
// Output: 7
 
// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1
  
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
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        boolean leftMost = true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            
            while (len > 0) {
                TreeNode cur = queue.poll();
                len--;
                
                if (leftMost) {
                    ans = cur.val;
                    leftMost = false;
                }
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            
            if (!queue.isEmpty()) {
                leftMost = true;
            }
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 2 ms, faster than 54.23% of Java online submissions for Find Bottom Left Tree Value.
// Memory Usage: 44.8 MB, less than 6.38% of Java online submissions for Find Bottom Left Tree Value.
