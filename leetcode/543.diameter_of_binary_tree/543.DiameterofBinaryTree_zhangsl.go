// Source : https://leetcode.com/problems/diameter-of-binary-tree/
// Author : zhangsl
// Date   : 2020-08-18
package main

/*****************************************************************************************************
 *
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a
 * binary tree is the length of the longest path between any two nodes in a tree. This path may or may
 * not pass through the root.
 *
 * Example:
 * Given a binary tree
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note:
 * The length of path between two nodes is represented by the number of edges between them.
 ******************************************************************************************************/

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
// 思路：
//     对于每一个根节点：1。返回左右子树的最大高度，并计算左右子树连接根节点后的最长距离来更新ans
//     root=nil return 0
// time:94 mem:97
var ans = 0
func max(x,y int)int{
	if x>=y{
		return x
	}
	return y
}
func diameterOfBinaryTree(root *TreeNode) int {
	ans = 0
	helper(root)
	return ans-1
}
func helper(root *TreeNode)int{
	if root==nil{
		return 0
	}
	left:=helper(root.Left)
	right:=helper(root.Right)
	ans = max(left+right+1,ans)
	return max(left,right)+1
}

