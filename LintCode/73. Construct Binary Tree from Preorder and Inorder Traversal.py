# https://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal/description

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param preorder : A list of integers that preorder traversal of a tree
    @param inorder : A list of integers that inorder traversal of a tree
    @return : Root of a tree
    """
    def buildTree(self, preorder, inorder):
        if not inorder or len(inorder) == 0:
            return None
        
        root = TreeNode(preorder[0])
        root_index = inorder.index(preorder[0])
        
        root.left = self.buildTree(preorder[1:root_index+1],inorder[:root_index])
        root.right = self.buildTree(preorder[root_index+1:],inorder[root_index+1:])
        return root
        