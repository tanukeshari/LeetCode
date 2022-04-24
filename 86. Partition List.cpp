// Medium
// Given the head of a linked list and a value x, 
// partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.
  
// Example 1:
// Input: 
// head = [1,4,3,2,5,2], x = 3
// Output: 
// [1,2,2,4,3,5]

// Example 2:
// Input: 
// head = [2,1], x = 2
// Output: 
// [1,2]
 
// Constraints:
// The number of nodes in the list is in the range [0, 200].
// -100 <= Node.val <= 100
// -200 <= x <= 200
  
// Solution
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* curr=head;
        ListNode* before=NULL,*beforetail=NULL;
        ListNode* after=NULL,*aftertail=NULL;
        while(curr!=NULL){
            if(curr->val<x){
                if(before==NULL){
                    before=curr;
                    beforetail=curr;
                }
                else{
                    beforetail->next=curr;
                    beforetail=beforetail->next;
                }
            }
            else{
                if(after==NULL){
                    after=curr;
                    aftertail=curr;
                }
                else{
                    aftertail->next=curr;
                    aftertail=aftertail->next;
                }
            }
            curr=curr->next;
        }
        if(before==NULL||after==NULL) return head;
        beforetail->next=after;
        aftertail->next=NULL;
        return before;
    }
};
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
// Memory Usage: 43.3 MB, less than 10.10% of Java online submissions for Partition List.
