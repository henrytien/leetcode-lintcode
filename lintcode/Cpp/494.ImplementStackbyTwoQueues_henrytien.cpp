// https://www.lintcode.com/problem/implement-stack-by-two-queues/description?_from=ladder&&fromId=1

class Stack {
public:
    /*
     * @param x: An integer
     * @return: nothing
     */
    void push(int x) {
        if(queue1.empty()){
            queue1.push(x);
            while(!queue2.empty()){
                int temp = queue2.front();
                queue2.pop();
                queue1.push(temp);
            }
        }else{
            queue2.push(x);
            while(!queue1.empty()){
                int temp = queue1.front();
                queue1.pop();
                queue2.push(temp);
            }
        }
    }

    /*
     * @return: nothing
     */
    void pop() {
        if(!queue1.empty()){
            queue1.pop();
        }
        if(!queue2.empty()){
            queue2.pop();
        }
    }

    /*
     * @return: An integer
     */
    int top() {
        if(!queue1.empty()){
            return queue1.front();
        }
        if(!queue2.empty()){
            return queue2.front();
        }
    }

    /*
     * @return: True if the stack is empty
     */
    bool isEmpty() {
        return queue1.empty() && queue2.empty();
    }
    private:
    std::queue<int> queue1;
    std::queue<int> queue2;
};