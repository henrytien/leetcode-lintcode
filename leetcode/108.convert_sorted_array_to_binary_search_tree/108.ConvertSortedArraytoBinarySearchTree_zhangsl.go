// Source : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// Author : zhangsl
// Date   : 2020-08-24
package main

/*****************************************************************************************************
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 ******************************************************************************************************/

//* Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
// 思路：二叉搜索树的中序遍历是有序的，
// 		题目中又要求高度差<2 所以采用平分的方式，使得左右树高度差<2
// time:84 mem:48
func sortedArrayToBST(nums []int) *TreeNode {
	return helper(nums, 0, len(nums)-1)
}
func helper(nums []int, l, r int) *TreeNode {
    if l>r{
    	return nil
	}
	mid:=(r+l)/2
	root:=&TreeNode{Val: nums[mid]}
	root.Left = helper(nums,l,mid-1)
	root.Right = helper(nums,mid+1,r)
	return root
}
