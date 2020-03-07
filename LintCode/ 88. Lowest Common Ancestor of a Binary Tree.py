# https://www.lintcode.com/problem/lowest-common-ancestor-of-a-binary-tree/description
"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""


class Solution:
    """
    @param: root: The root of the binary search tree.
    @param: A: A TreeNode in a Binary.
    @param: B: A TreeNode in a Binary.
    @return: Return the least common ancestor(LCA) of the two nodes.
    """
    def lowestCommonAncestor(self, root, A, B):
        if root is None:
            return None
            
        if A == root or B == root:
            return root
            
        result_left = self.lowestCommonAncestor(root.left, A, B)
        result_right = self.lowestCommonAncestor(root.right,A, B)
        
        if result_left and result_right:
            return root
        
        if result_left:
            return result_left
        
        if result_right:
            return result_right
            
        return None
