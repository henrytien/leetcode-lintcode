// https://www.lintcode.com/problem/merge-k-sorted-lists/description?_from=ladder&&fromId=1
/**
 * Definition of ListNode
 * class ListNode {
 * public:
 *     int val;
 *     ListNode *next;
 *     ListNode(int val) {
 *         this->val = val;
 *         this->next = NULL;
 *     }
 * }
 */
struct mycomp{
    bool operator()(const ListNode* a, const ListNode* b){
        return a->val > b->val;
    }
};
 
class Solution {
public:
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if(lists.empty()) return nullptr;
        
        priority_queue<ListNode*,vector<ListNode *>,mycomp> pq;
        
        for (auto& list : lists) {
            ListNode* tmp = list;
            while(tmp){
                pq.push(tmp);
                tmp = tmp->next;
            }
        }
        
        ListNode *head = new ListNode(-1);
        ListNode *cur = head;
        while(!pq.empty()){
            ListNode* newNode = new ListNode(pq.top()->val);
            pq.pop();
            cur->next = newNode;
            cur = cur->next;
        }
        
        cur->next = nullptr;
        return head->next;
    }
};


