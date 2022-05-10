// Easy
// Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, 
// return true if the nodes corresponding to the values x and y in the tree are cousins, 
// or false otherwise.

// Two nodes of a binary tree are cousins if they have the same depth with different parents.

// Note that in a binary tree, the root node is at the depth 0, 
// and children of each depth k node are at the depth k + 1.

// Example 1:
// Input: 
// root = [1,2,3,4], x = 4, y = 3
// Output: 
// false
  
// Example 2:
// Input: 
// root = [1,2,3,null,4,null,5], x = 5, y = 4
// Output: 
// true
  
// Example 3:
// Input: 
// root = [1,2,3,null,4], x = 2, y = 3
// Output: 
// false
 
// Constraints:
// The number of nodes in the tree is in the range [2, 100].
// 1 <= Node.val <= 100
// Each node has a unique value.
// x != y
// x and y are exist in the tree.
  
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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        Map<TreeNode, TreeNode> hm = new HashMap<>();
        TreeNode findOne = null;
        int len = 1;
        int cnt = 0;
        boolean sameLevel = false;
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            len--;
                    
            if (cur.val == x || cur.val == y) {
                if (findOne != null) {
                    if (hm.get(cur) != hm.get(findOne)) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    findOne = cur;
                    sameLevel = true;
                }
            }
            
            if (cur.left != null) {
                queue.offer(cur.left);
                hm.put(cur.left, cur);
                cnt++;
            }
            
            if (cur.right != null) {
                queue.offer(cur.right);
                hm.put(cur.right, cur);
                cnt++;
            }
            
            if (len == 0) {
                if (sameLevel == true) {
                    return false;
                }
                
                len = cnt;
                cnt = 0;
            }
        }
        
        return false;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 1 ms, faster than 58.44% of Java online submissions for Cousins in Binary Tree.
// Memory Usage: 40.6 MB, less than 75.14% of Java online submissions for Cousins in Binary Tree.
