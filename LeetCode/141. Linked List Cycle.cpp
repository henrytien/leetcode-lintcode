#include"AllInclude.h"
//https://leetcode.com/problems/linked-list-cycle/
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
	bool hasCycle(ListNode *head) {
		if (head == NULL) return false;

		while (head->next)
		{
			if(!head->next->next)
				break;
			if (head->next == head->next->next)
				return true;
			head->next = head->next->next;
			head = head->next;
		}
		return false;
	}

};

int main()
{
	vector<int> src = { 3,2,0,-4 };
	ListNode *list = (ListNode*)malloc(sizeof(ListNode));
	for (auto &iter : src) {
		list->val = iter;
		list = list->next;
	}

	cout << Solution().hasCycle(list);
	getchar();
	return 0;
}