// Medium
// Given the head of a singly linked list that is sorted in non-decreasing order using the absolute values of its nodes, 
// return the list sorted in non-decreasing order using the actual values of its nodes.
 
// Example 1:
// Input: 
// head = [0,2,-5,5,10,-10]
// Output: 
// [-10,-5,0,2,5,10]

// Explanation:
// The list sorted in non-descending order using the absolute values of the nodes is [0,2,-5,5,10,-10].
// The list sorted in non-descending order using the actual values is [-10,-5,0,2,5,10].
  
// Example 2:
// Input: 
// head = [0,1,2]
// Output: 
// [0,1,2]

// Explanation:
// The linked list is already sorted in non-decreasing order.
  
// Example 3:
// Input: 
// head = [1]
// Output: 
// [1]
// Explanation:

// The linked list is already sorted in non-decreasing order.
 
// Constraints:
// The number of nodes in the list is the range [1, 105].
// -5000 <= Node.val <= 5000
// head is sorted in non-decreasing order using the absolute value of its nodes.
 
// Follow up:
// Can you think of a solution with O(n) time complexity?
  
// Solution 1
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
    public ListNode sortLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode negativeCur = null;
        ListNode positiveHead = null;
        ListNode negativeHead = null;
        boolean positiveHeadFind = false;
        boolean negativeHeadFind = false;
        
        while (cur != null) {
            if (cur.val >= 0) {
                if (!positiveHeadFind) {
                    positiveHead = cur;
                    positiveHeadFind = true;
                }
                
                prev = cur;
                cur = cur.next;
            }
            else {
                if (!negativeHeadFind) {
                    negativeHead = cur;
                    negativeHeadFind = true;
                    negativeCur = negativeHead; 
                    
                    if (prev != null) {
                        prev.next = cur.next;    
                    }
                    
                    cur = cur.next;
                    
                    continue;
                }
                
                negativeCur.next = cur;
                
                if (prev != null) {
                    prev.next = cur.next;    
                }
                
                cur = cur.next;
                negativeCur = negativeCur.next;
            }
        }
        
              
        if (negativeHead == null) {
            return positiveHead;
        }
        
        negativeCur.next = null;
        
        prev = null;
        cur = negativeHead;    
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        head = prev;
        negativeHead.next = positiveHead;
        
        return head;
    }
}
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 4 ms, faster than 67.18% of Java online submissions for Sort Linked List Already Sorted Using Absolute Values.
// Memory Usage: 106.7 MB, less than 64.88% of Java online submissions for Sort Linked List Already Sorted Using Absolute Values.
