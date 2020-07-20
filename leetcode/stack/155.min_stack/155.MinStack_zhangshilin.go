// Source : https://leetcode.com/problems/min-stack/
// Author : zhangshilin
// Date   : 2020-07-20
package main

/*****************************************************************************************************
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * 	push(x) -- Push element x onto stack.
 * 	pop() -- Removes the element on top of the stack.
 * 	top() -- Get the top element.
 * 	getMin() -- Retrieve the minimum element in the stack.
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * Constraints:
 *
 * 	Methods pop, top and getMin operations will always be called on non-empty stacks.
 ******************************************************************************************************/

type MinStack struct {
	data []int
	min  []int
}

/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{
		data: []int{},
		min:  []int{},
	}
}

func (this *MinStack) Push(x int) {
	var (
		m, pushData int
	)
	if len(this.min) != 0 {
		m = this.GetMin()
		if x < m {
			pushData = x
		} else {
			pushData = m
		}
	} else {
		pushData = x
	}

	this.min = append(this.min, pushData)
	this.data = append(this.data, x)
}

func (this *MinStack) Pop() {
	this.min = this.min[:len(this.min)-1]
	this.data = this.data[:len(this.data)-1]
}

func (this *MinStack) Top() int {
	return this.data[len(this.data)-1]
}

func (this *MinStack) GetMin() int {
	return this.min[len(this.min)-1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
