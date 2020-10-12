// Source : https://leetcode.com/problems/design-linked-list/
// Author : henrytine
// Date   : 2020-10-12

/***************************************************************************************************** 
 *
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the 
 * current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the 
 * previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * 
 * Implement the MyLinkedList class:
 * 
 * 	MyLinkedList() Initializes the MyLinkedList object.
 * 	int get(int index) Get the value of the indexth node in the linked list. If the index is 
 * invalid, return -1.
 * 	void addAtHead(int val) Add a node of value val before the first element of the linked 
 * list. After the insertion, the new node will be the first node of the linked list.
 * 	void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * 	void addAtIndex(int index, int val) Add a node of value val before the indexth node in the 
 * linked list. If index equals the length of the linked list, the node will be appended to the end of 
 * the linked list. If index is greater than the length, the node will not be inserted.
 * 	void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is 
 * valid.
 * 
 * Example 1:
 * 
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * 
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 * 
 * Constraints:
 * 
 * 	0 <= index, val <= 1000
 * 	Please do not use the built-in LinkedList library.
 * 	At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.
 ******************************************************************************************************/

class MyLinkedList {
public:
    /** Initialize your data structure here. */
    MyLinkedList():head_(nullptr),tail_(nullptr),size_(0) {}
    
    ~MyLinkedList() {
        Node* node = head_;
        while (node) {
            Node* cur = node; // 
            node = node->next;
            delete cur;
        }
        head_ = nullptr;
        tail_ = nullptr;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        if (index < 0 || index >= size_) return -1;
        Node* node = head_;
        while (index--) { // Care 
            node = node->next;
        }
        return node->val;
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val) {
        head_ = new Node(val, head_);
        if (size_++ == 0) {
            tail_ = head_;
        }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        Node* node = new Node(val);
        // When size is one, head and tail should be point the node.  
        if (size_++ == 0) {
            head_ = tail_ = node;
        } else {
            tail_->next = node;
            tail_ = tail_->next;  // Update tail_ 
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        if (index < 0 || index > size_) return;
        if (index == 0) {
           return addAtHead(val);
        }
        if (index == size_) {
            return addAtTail(val);
        }
        // How to track the prev node
        Node dummy(0, head_);  // Memory in stack
        Node* prev = &dummy;    
        while (index--) {
            prev = prev->next;
        }
        prev->next = new Node(val, prev->next);
        ++size_;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        if (index < 0 || index >= size_) return;
        Node dummy(0, head_);
        Node *prev = &dummy;
        for (int i = 0; i < index; i++) {
            prev = prev->next;
        } 
        
        Node* node_to_delete = prev->next;
        prev->next = node_to_delete->next;
        
        if (index == 0) {
            head_ = prev->next;
        }
        if (index == size_ - 1) {
            tail_ = prev;
        }
        delete node_to_delete;
        --size_;
        
    }
    
private:
    struct Node {
        int val;
        Node* next;
        Node (int _val):Node(_val, nullptr) {} // val
        Node (int _val, Node* _next):val(_val),next(_next) {}
    };
    
    Node* head_;
    Node* tail_;
    int size_;
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */