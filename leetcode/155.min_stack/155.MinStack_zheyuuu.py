# Source : https://leetcode.com/problems/min-stack/
# Author : zheyuuu
# Date   : 2020-07-19

##################################################################################################### 
#
# Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
# 
# 	push(x) -- Push element x onto stack.
# 	pop() -- Removes the element on top of the stack.
# 	top() -- Get the top element.
# 	getMin() -- Retrieve the minimum element in the stack.
# 
# Example 1:
# 
# Input
# ["MinStack","push","push","push","getMin","pop","top","getMin"]
# [[],[-2],[0],[-3],[],[],[],[]]
# 
# Output
# [null,null,null,null,-3,null,0,-2]
# 
# Explanation
# MinStack minStack = new MinStack();
# minStack.push(-2);
# minStack.push(0);
# minStack.push(-3);
# minStack.getMin(); // return -3
# minStack.pop();
# minStack.top();    // return 0
# minStack.getMin(); // return -2
# 
# Constraints:
# 
# 	Methods pop, top and getMin operations will always be called on non-empty stacks.
#####################################################################################################

from collections import deque
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []
        self.i = 0
        

    def push(self, x: int) -> None:
        self.s1.append(x)
        if(not self.s2 or self.s1[self.s2[-1]]>x):
            self.s2.append(self.i)
        self.i += 1
        

    def pop(self) -> None:
        top = self.s1.pop()
        if self.i-1==self.s2[-1]:
            self.s2.pop()
        self.i -= 1
        

    def top(self) -> int:
        return self.s1[-1]
        

    def getMin(self) -> int:
        return self.s1[self.s2[-1]]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()