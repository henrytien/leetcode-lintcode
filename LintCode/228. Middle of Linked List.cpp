// https://www.lintcode.com/problem/middle-of-linked-list/description?_from=ladder&&fromId=1
/**
 * Definition of singly-linked-list:
 * class ListNode {
 * public:
 *     int val;
 *     ListNode *next;
 *     ListNode(int val) {
 *        this->val = val;
 *        this->next = NULL;
 *     }
 * }
 */

class Solution {
public:
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    ListNode * middleNode(ListNode * head) {
        if(NULL == head || head->next == NULL)
        {
            return head;
        }
        ListNode *slow = head, *fast = head->next;
        while(fast != NULL && fast->next != NULL)
        {
            fast = fast->next->next;
            slow = slow->next;
        }
        
        return slow;
    }
};