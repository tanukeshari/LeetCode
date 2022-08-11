// Medium
// Given the root of a binary tree, 
// return the bottom-up level order traversal of its nodes' values. 
// (i.e., from left to right, level by level from leaf to root).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[15,7],[9,20],[3]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []
 
// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000
  
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tempAns = new ArrayList<>();
        
        if (root == null) {
            return tempAns;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            
            while (len > 0) {
                TreeNode cur = queue.poll();
                len--;
                level.add(cur.val);
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            
            tempAns.add(level);
        }
        
        if (tempAns.size() == 1) {
            return tempAns;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = tempAns.size() - 1; i >= 0; i--) {
            ans.add(tempAns.get(i));
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 1 ms, faster than 98.52% of Java online submissions for Binary Tree Level Order Traversal II.
// Memory Usage: 43.5 MB, less than 53.89% of Java online submissions for Binary Tree Level Order Traversal II.
