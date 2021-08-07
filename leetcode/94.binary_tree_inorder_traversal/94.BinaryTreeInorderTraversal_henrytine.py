# Source : https://leetcode.com/problems/binary-tree-inorder-traversal/
# Author : henrytine
# Date   : 2020-08-18

##################################################################################################### 
#
# Given a binary tree, return the inorder traversal of its nodes' values.
# 
# Example:
# 
# Input: [1,null,2,3]
#    1
#     \
#      2
#     /
#    3
# 
# Output: [1,3,2]
# 
# Follow up: Recursive solution is trivial, could you do it iteratively?
#####################################################################################################

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.helper(root, res)
        return res

    def helper(self, root, res):
        if root:
            self.helper(root.left, res)
            res.append(root.val)
            self.helper(root.right, res)

# iterator


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []

        while stack or root:
            if root:
                stack.append(root)
                root = root.left
            else:
                node = stack.pop()
                res.append(node.val)
                root = node.right
        return res
