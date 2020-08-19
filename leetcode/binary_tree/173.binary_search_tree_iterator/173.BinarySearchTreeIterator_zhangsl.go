// Source : https://leetcode.com/problems/binary-search-tree-iterator/
// Author : zhangsl
// Date   : 2020-08-18
package main

/*****************************************************************************************************
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the
 * root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Example:
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 * Note:
 *
 * 	next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the
 * height of the tree.
 * 	You may assume that next() call will always be valid, that is, there will be at least a
 * next smallest number in the BST when next() is called.
 *
 ******************************************************************************************************/
// 思路： 由于是二叉搜索树，所以中序遍历是有序的。
//* Definition for a binary tree node.
//time:38 mem:93
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
type BSTIterator struct {
	data []int
	p  int
}
var bstIter BSTIterator
func Constructor(root *TreeNode) BSTIterator {
	bstIter=BSTIterator{}
	helper(root)
	return bstIter
}
func helper(root *TreeNode){
	if root==nil{
		return
	}
	helper(root.Left)
	// 处理当前子树根节点
	bstIter.data =  append(bstIter.data,root.Val)
	helper(root.Right)
}

/** @return the next smallest number */
func (this *BSTIterator) Next() int {
	if this.HasNext(){
		ans:= this.data[this.p]
		this.p++
		return ans
	}
	return -1
}

/** @return whether we have a next smallest number */
func (this *BSTIterator) HasNext() bool {
	if this.p==len(this.data){
		return false
	}
	return true
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */
