// Easy
// Given the root of a binary tree, 
// return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
// This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

// Example 1:
// Input: 
// root = [1,2,3,4,5]
// Output: 
// 3
  
// Explanation: 
// 3 is the length of the path [4,2,1,3] or [5,2,1,3].
  
// Example 2:
// Input: 
// root = [1,2]
// Output: 
// 1
 
// Constraints:
// The number of nodes in the tree is in the range [1, 104].
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
    private int di;
    
    public int diameterOfBinaryTree(TreeNode root) {
        di = 0;
        
        dfs(root);
        
        return di;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        
        di = Math.max(di, leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
// Memory Usage: 42.1 MB, less than 82.83% of Java online submissions for Diameter of Binary Tree.
