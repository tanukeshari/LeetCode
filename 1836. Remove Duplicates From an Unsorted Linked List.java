// Medium
// Given the head of a linked list, 
// find all the values that appear more than once in the list and delete the nodes that have any of those values.

// Return the linked list after the deletions.

// Example 1:
// Input: head = [1,2,3,2]
// Output: [1,3]

// Explanation: 
// 2 appears twice in the linked list, 
// so all 2's should be deleted. 
// After deleting all 2's, 
// we are left with [1,3].

// Example 2:
// Input: head = [2,1,1,2]
// Output: []

// Explanation: 
// 2 and 1 both appear twice. 
// All the elements should be deleted.

// Example 3:
// Input: head = [3,2,2,1,3,2,4]
// Output: [1,4]

// Explanation: 
// 3 appears twice and 2 appears three times. 
// After deleting all 3's and 2's, 
// we are left with [1,4].
 
// Constraints:
// The number of nodes in the list is in the range [1, 105]
// 1 <= Node.val <= 105
  
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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        ListNode cur = head;
        
        while (cur != null) {
            if (set1.contains(cur.val)) {
                set2.add(cur.val);
            }
            else {
                set1.add(cur.val);
            }
            
            cur = cur.next;
        }
        
        ListNode c = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (c != null) {
            if (set2.contains(c.val)) {
                prev.next = c.next;
            }
            else {
                prev = prev.next;
            }
            
            c = c.next;
        }
        
        return dummy.next == null ? null : dummy.next;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 94 ms, faster than 80.65% of Java online submissions for Remove Duplicates From an Unsorted Linked List.
// Memory Usage: 58.9 MB, less than 99.13% of Java online submissions for Remove Duplicates From an Unsorted Linked List.
