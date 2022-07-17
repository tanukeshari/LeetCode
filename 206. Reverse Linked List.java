// Easy
// Given the head of a singly linked list, 
// reverse the list, 
// and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

// Example 2:
// Input: head = [1,2]
// Output: [2,1]

// Example 3:
// Input: head = []
// Output: []
 
// Constraints:
// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000
 
// Follow up: 
// A linked list can be reversed either iteratively or recursively. 
// Could you implement both?

// Solution iterative
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
// Memory Usage: 43.2 MB, less than 26.73% of Java online submissions for Reverse Linked List.

// Solution 2, recursive
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
// Memory Usage: 44 MB, less than 7.88% of Java online submissions for Reverse Linked List.
