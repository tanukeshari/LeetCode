// Medium
// Given the root of a binary tree, 
// return the level order traversal of its nodes' values. 
// (i.e., from left to right, level by level).

// Example 1:
// Input: 
// root = [3,9,20,null,null,15,7]
// Output: 
// [[3],[9,20],[15,7]]

// Example 2:
// Input: 
// root = [1]
// Output: 
// [[1]]

// Example 3:
// Input: 
// root = []
// Output: 
// []

// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000
  
// Solution 1
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        
        if (root == null) {
            return ans;
        }
        
        List<Integer> curLevel = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int len = queue.size();
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            curLevel.add(curNode.val);
            len--;
            
            if (curNode.left != null) {
                queue.offer(curNode.left);
                cnt++;
            }
            
            if (curNode.right != null) {
                queue.offer(curNode.right);
                cnt++;
            }
            
            if (len == 0) {
                ans.add(new LinkedList<Integer>(curLevel));
                curLevel = new LinkedList<Integer>();
                len = cnt;
                cnt = 0;
            }
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 3 ms, faster than 8.50% of Java online submissions for Binary Tree Level Order Traversal.
// Memory Usage: 44.4 MB, less than 6.35% of Java online submissions for Binary Tree Level Order Traversal.

// Solution 2
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
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
            
            ans.add(level);
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 1 ms, faster than 93.16% of Java online submissions for Binary Tree Level Order Traversal.
// Memory Usage: 43.7 MB, less than 47.84% of Java online submissions for Binary Tree Level Order Traversal.
