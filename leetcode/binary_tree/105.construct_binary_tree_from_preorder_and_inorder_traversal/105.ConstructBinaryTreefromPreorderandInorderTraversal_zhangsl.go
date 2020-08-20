// Source : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Author : zhangsl
// Date   : 2020-08-19
package main

/*****************************************************************************************************
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 ******************************************************************************************************/

//* Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
//思路：先序确定根，通过中序中根的位置，确定在左右子树的长度。然后将左子树和右子树传递下去，继续此过程，
//直到先序为空，表示当前子树已经到nil了

//time:56 mem:44
func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) < 1 {
		return nil
	}
	i := 0
	for i, _ = range inorder {
		if inorder[i] == preorder[0] {
			break
		}
	}

	root := &TreeNode{Val: preorder[0]}
	root.Left = buildTree(preorder[1:1+i], inorder[:i])
	root.Right = buildTree(preorder[1+i:], inorder[i+1:])
	return root
}
func main() {
	buildTree([]int{3,9,20,15,7},
	[]int{9,3,15,20,7})
}