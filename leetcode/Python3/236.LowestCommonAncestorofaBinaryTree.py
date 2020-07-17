# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        if root in (None, p, q):
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left is None:
            return right
        elif right is None:
            return left
        else:
            return root

        # return self.helper(root, p, q)

    # def helper(self, node, p, q):
    #     if node in (None, p, q):
    #         return node
    #     left = self.helper(node.left, p, q)
    #     right = self.helper(node.right, p, q)
    #     if left is None:
    #         return right
    #     elif right is None:
    #         return left
    #     else:
    #         return node
