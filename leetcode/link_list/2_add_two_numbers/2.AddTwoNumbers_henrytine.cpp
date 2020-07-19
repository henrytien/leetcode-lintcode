// Source : https://leetcode.com/problems/add-two-numbers/
// Author : henrytine
// Date   : 2020-07-19

/***************************************************************************************************** 
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are 
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and 
 * return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 ******************************************************************************************************/


#include<iostream>
#include<vector>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution{
public:
    ListNode* addList(ListNode* l1, ListNode* l2){
        ListNode* head = new ListNode(0);
        ListNode* curr = head;
        int dig = 0;
        while(l1 || l2){
            int sum = 0;
            sum += l1 == NULL ? 0 : l1->val;
            sum += l2 == NULL ? 0 : l2->val;
            sum += dig;

            dig = sum / 10;
            ListNode* tmp = new ListNode(sum % 10);
            curr->next = tmp;
            curr = tmp;

            if(l1) l1 = l1->next;
            if(l2) l2 = l2->next;
        }

        if(dig){
            ListNode* tmp = new ListNode(dig);
            curr->next = tmp;
            curr = tmp;
        }
        return head->next;
    }
};

ListNode* create_list_by_tail(vector<int>& nums){
    if(nums.size() == 0){
        return NULL;
    }

    ListNode* head = new ListNode(0);
    ListNode* tail= head;
  
    for (int i = 0; i < nums.size(); i++) {
        ListNode* s = new ListNode(nums[i]);
        tail->next = s;
        tail = s;
    }
    return head->next;
}

void print_list(ListNode* node){
    if(node == NULL){
        return;
    }
    while(node){
        cout << node->val << endl;
        node = node->next;
    }
}

int main(){
    
    vector<int> n = {5};
    vector<int> n1 = {5};
//  print_list(create_list_by_tail(n));
    ListNode* l1 = create_list_by_tail(n);
    ListNode* l2 = create_list_by_tail(n1);
    Solution s;
    print_list(s.addList(l1, l2));
    cout << "hello" << endl;
    return 0;
    
}