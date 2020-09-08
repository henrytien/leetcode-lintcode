// Source : https://leetcode.com/problems/range-sum-of-bst/
// Author : zhangsl
// Date   : 2020-08-20
package main

/*****************************************************************************************************
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value
 * between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 *
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 * Note:
 *
 * 	The number of nodes in the tree is at most 10000.
 * 	The final answer is guaranteed to be less than 2^31.
 *
 ******************************************************************************************************/

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
// 思路：递归，判断每一个节点，如果当前节点 L<=now.val<=R =>ans+=now.val
//           继续向下判断，如果比当前节点大，说明左子树中可能有在区间中的值
// 			 			 如果节点比右节点小，说明右子树中可能有在区间的值了
// time:18 mem:86
var ans = 0
func rangeSumBST(root *TreeNode, L int, R int) int {
	ans = 0
//	入参检查
	if root ==nil{
		return ans
	}
	helper(root,L,R)

}
func helper(root *TreeNode,l,r int){
	if root!=nil{
		if l<=root.Val&&root.Val<=r{
			ans+=root.Val
		}
		if l<root.Val{
			helper(root.Left,l,r)
		}
		if root.Val<r{
			helper(root.Right,l,r)
		}
	}
	return
}
