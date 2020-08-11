/*
 * @Author: John
 * @Email: johnjim0816@gmail.com
 * @Date: 2020-08-11 07:50:58
 * @LastEditor: John
 * @LastEditTime: 2020-08-11 07:51:07
 * @Discription: 
 * @Environment: 
 */
// Source : https://leetcode.com/problems/implement-queue-using-stacks/
// Author : JohnJim0816
// Date   : 2020-08-11

/***************************************************************************************************** 
 *
 * Implement the following operations of a queue using stacks.
 * 
 * 	push(x) -- Push element x to the back of queue.
 * 	pop() -- Removes the element from in front of queue.
 * 	peek() -- Get the front element.
 * 	empty() -- Return whether the queue is empty.
 * 
 * Example:
 * 
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1);
 * queue.push(2);  
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * 
 * Notes:
 * 
 * 	You must use only standard operations of a stack -- which means only push to top, peek/pop 
 * from top, size, and is empty operations are valid.
 * 	Depending on your language, stack may not be supported natively. You may simulate a stack 
 * by using a list or deque (double-ended queue), as long as you use only standard operations of a 
 * stack.
 * 	You may assume that all operations are valid (for example, no pop or peek operations will 
 * be called on an empty queue).
 * 
 ******************************************************************************************************/

class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> s1;
    stack<int> s2;
    int front;
    MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        if(s1.empty()){
            front = x;
        }
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if(s2.empty())
        {
            while(!s1.empty())
            {
                s2.push(s1.top());
                s1.pop();
            }
            front = NULL;
        }
        int a=s2.top();
        s2.pop();
        return a;
    }
    
    /** Get the front element. */
    int peek() {
        if(s2.empty()){
            return front;
        }
        return s2.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(s1.empty()&&s2.empty()){
            return true;
        }
        return false;
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */