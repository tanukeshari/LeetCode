// Medium
// Given the root of a binary tree, 
// return the zigzag level order traversal of its nodes' values. 
// (i.e., 
// from left to right, 
// then right to left for the next level and alternate between).

// Example 1:
// Input: 
// root = [3,9,20,null,null,15,7]
// Output: 
// [[3],[20,9],[15,7]]

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
// -100 <= Node.val <= 100
  
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curLevel = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
          
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        
        int len = deque.size();
        int level = 0;
        int cnt = 0;
        
        while (!deque.isEmpty()) {        
            if (len > 0) {
                if (level % 2 == 0) {
                    TreeNode curNode = deque.pollLast();
                    curLevel.add(curNode.val);
                    len--;

                    if (curNode.left != null) {
                        deque.offerFirst(curNode.left);
                        cnt++;
                    }
                    
                    if (curNode.right != null) {
                        deque.offerFirst(curNode.right);
                        cnt++;
                    }
                }
                else {
                    TreeNode curNode = deque.pollFirst();
                    curLevel.add(curNode.val);
                    len--;
                    
                    if (curNode.right != null) {
                        deque.offerLast(curNode.right);
                        cnt++;
                    }
                    
                    if (curNode.left != null) {
                        deque.offerLast(curNode.left);
                        cnt++;
                    }
                }
            }
            
            if (len == 0) {
                ans.add(new ArrayList<Integer>(curLevel));
                curLevel = new ArrayList<Integer>();
                len = cnt;
                cnt = 0;
                level++;
            }
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 1 ms, faster than 86.75% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
// Memory Usage: 43.5 MB, less than 7.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        
        boolean isEven = true;
        
        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> level = new ArrayList<>();
            
            while (len > 0) {
                TreeNode cur;
                
                if (isEven) {
                    cur = deque.pollFirst();
                    
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                }
                else {
                    cur = deque.pollLast();
                    
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                }
                
                len--;
                level.add(cur.val);
                    
            }
            
            isEven = !isEven;
            ans.add(level);
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 1 ms, faster than 96.41% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
// Memory Usage: 41 MB, less than 93.64% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
