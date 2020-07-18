// https://www.lintcode.com/problem/implement-queue-by-two-stacks/description

class MyQueue {
public:
    MyQueue() {
        // do intialization if necessary
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    void push(int element) {
        stack1.push(element);
    }
    
    void adjust()
    {
        if(stack2.empty()){
            while(!stack1.empty()){
                 stack2.push(stack1.top());
                 stack1.pop();
            }
        }
    }

    /*
     * @return: An integer
     */
    int pop() {
        adjust();
        int temp = stack2.top();
        stack2.pop();
        return temp;
        // write your code here
    }

    /*
     * @return: An integer
     */
    int top() {
        adjust();
        return stack2.top();
        // write your code here
    }
    private:
    std::stack<int> stack1;
    std::stack<int> stack2;
    
};