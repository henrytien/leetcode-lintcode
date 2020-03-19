// https://leetcode.com/problems/add-two-numbers/
#include<iostream>
#include<vector>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

void print(ListNode *node){
    while(node){
        cout << node->val << endl;
        node = node->next;
    }
}
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(l1 == NULL)
            return l2;
        if(l2 == NULL)
            return l1;
        ListNode* head = new ListNode(0);
        ListNode* tail = head;
        int dig = 0;
        while(l1 || l2){
            
            int total = 0;
            total += l1 == NULL ? 0 : l1->val ;
            total += l2 == NULL ? 0 : l2->val ;
            total += dig;
            dig = total / 10;
            
            ListNode* s = new ListNode(total%10);
            tail->next = s;
            tail = tail->next;
            
            if(l1) l1 = l1->next;
            if(l2) l2 = l2->next;
        }
        // 5 5 = 0,1
        if(dig){
            ListNode* s = new ListNode(dig);
            tail->next = s;
            tail = s;
        }
        return head->next;
    }
};

ListNode* create_list(vector<int> &nums){
    ListNode* tail, *head = new ListNode(0);
    tail = head;
    for (int i = 0; i < nums.size(); i++) {
        ListNode* s = new ListNode(0);
        s->val = nums[i];
        tail->next = s;
        tail = s;
    }
    return head->next;
}

int main(){
    vector<int> nums = {5};
    vector<int> nums1 = {5};

//    vector<int> nums = {2,4,3};
//    vector<int> nums1 = {5,6,4};
    ListNode* l1 = create_list(nums);
    ListNode* l2 = create_list(nums1);
    
    Solution s;
    print(s.addTwoNumbers(l1,l2));
}