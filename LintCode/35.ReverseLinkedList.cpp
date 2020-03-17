// https://www.lintcode.com/problem/reverse-linked-list/description
/**
 * Definition of singly-linked-list:
 *
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
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    ListNode * reverse(ListNode * head) {
        if(head == nullptr){
            return nullptr;
        }
        
        ListNode *pre = NULL;
        ListNode *p = head;
        while(p != NULL){
            ListNode *tmp = p->next;
            p->next = pre;
            pre = p;
            p = tmp;
        }
        return pre;
    }
};