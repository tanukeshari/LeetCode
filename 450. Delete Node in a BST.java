// Medium
// Given a root node reference of a BST and a key, 
// delete the node with the given key in the BST. 
// Return the root node reference (possibly updated) of the BST.

// Basically, 
// the deletion can be divided into two stages:
// Search for a node to remove.
// If the node is found, 
// delete the node.
 
// Example 1:
// Input: root = [5,3,6,2,4,null,7], key = 3
// Output: [5,4,6,2,null,null,7]

// Explanation: Given key to delete is 3. 
// So we find the node with value 3 and delete it.
// One valid answer is [5,4,6,2,null,null,7], 
// shown in the above BST.
// Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

// Example 2:
// Input: root = [5,3,6,2,4,null,7], key = 0
// Output: [5,3,6,2,4,null,7]
// Explanation: 
// The tree does not contain a node with value = 0.
  
// Example 3:
// Input: root = [], key = 0
// Output: []
 
// Constraints:
// The number of nodes in the tree is in the range [0, 104].
// -105 <= Node.val <= 105
// Each node has a unique value.
// root is a valid binary search tree.
// -105 <= key <= 105
 
// Follow up: 
// Could you solve it with time complexity O(height of tree)?
  
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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode prev = null;
        TreeNode cur = root;
        boolean isLeft = true;
        
        while (cur != null && cur.val != key) {
            prev = cur;
            
            if (cur.val < key) {
                cur = cur.right;
                isLeft = false;
            }
            else {
                cur = cur.left;
                isLeft = true;
            }
        }
        
        if (cur == null) {
            return root;
        }
        
        TreeNode attached = null;
        
        if (cur.left != null) {
            attached = cur.left;
            TreeNode temp = cur.left;
            
            while (temp.right != null) {
                temp = temp.right;
            }
            
            temp.right = cur.right;
        }
        else {
            attached = cur.right;
        }
        
        if (cur == root) {
            root = attached;
        }
        else {
            if (isLeft) {
                prev.left = attached;
            }
            else {
                prev.right = attached;
            }
        }
        
        return root;
    }
}
// TC: O(height of tree); SC: O(1)
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
// Memory Usage: 50.2 MB, less than 17.32% of Java online submissions for Delete Node in a BST.
