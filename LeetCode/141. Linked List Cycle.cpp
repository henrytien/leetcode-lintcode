#include "AllInclude.h"
// https://leetcode.com/problems/linked-list-cycle/
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
  static bool has_cycle(ListNode *head);
};

bool Solution::has_cycle(ListNode *head) {
  if (head == nullptr)
    return false;

  while (head->next) {
    if (!head->next->next)
      break;
    if (head->next == head->next->next)
      return true;
    head->next = head->next->next;
    head = head->next;
  }
  return false;
}

void push(ListNode **head, const int val) {
  auto *new_node = static_cast<ListNode *>(malloc(sizeof(ListNode)));
  new_node->val = val;
  new_node->next = *head;
  *head = new_node;
}

void print(ListNode *list) {
  while (list != nullptr) {
    printf("%d ", list->val);
    list = list->next;
  }
}

int main() {
  vector<int> src = {3, 2, 0, -4};
  ListNode *list = NULL;
  for (auto &iter : src)
    push(&list, iter);
  print(list);

  cout << Solution().has_cycle(list);
  getchar();
  return 0;
}
