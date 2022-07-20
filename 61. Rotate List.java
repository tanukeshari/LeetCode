// Medium
// Given the head of a linked list, 
// rotate the list to the right by k places.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
 
// Constraints:
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109

// Solution
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode fast = head;
        int cnt = 1;
        
        while (fast.next != null) {
            fast = fast.next;
            cnt++;
        }
        
        k = k % cnt;
        
        int steps = cnt - k - 1;
        ListNode slow = head;
        
        while (steps > 0) {
            slow = slow.next;
            steps--;
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
}
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
// Memory Usage: 41.8 MB, less than 91.96% of Java online submissions for Rotate List.
