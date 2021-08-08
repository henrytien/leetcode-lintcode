// Source : https://leetcode.com/problems/sort-list/
// Author : henrytine
// Date   : 2020-10-13

/***************************************************************************************************** 
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * 
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * 
 * Example 1:
 * 
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * 
 * Example 2:
 * 
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * 
 * Example 3:
 * 
 * Input: head = []
 * Output: []
 * 
 * Constraints:
 * 
 * 	The number of nodes in the list is in the range [0, 5 * 104].
 * 	-105 <= Node.val <= 105
 ******************************************************************************************************/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) return head;
        
        ListNode* fast = head->next;
        ListNode* slow = head;
        ListNode* cur = head;
        while (fast && fast->next) {
            fast = fast->next->next;
            slow = slow->next;
        }
        
        ListNode* right = slow->next;
        slow->next = nullptr;
        
        cur = merge(sortList(head),sortList(right));
        return cur;
    }
    
    ListNode* merge(ListNode* l1, ListNode* l2) {
        ListNode dummy(0);
        ListNode* tail = &dummy;
        while (l1 && l2) {
            if (l1->val > l2->val) {
                swap(l1,l2);
            }
            tail->next = l1;
            l1 = l1->next;
            tail = tail->next;
            
//             if (l1->val < l2->val) {
//                 tail->next = l1;
//                 l1 = l1->next;
//             } else {
//                 tail->next = l2;
//                 l2 = l2->next;
//             }
            
//             tail = tail->next;
            
        }
        
        if (l1) tail->next = l1;
        if (l2) tail->next = l2;
        return dummy.next;
    }
};