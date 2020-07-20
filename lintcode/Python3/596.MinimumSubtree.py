#https://www.lintcode.com/problem/minimum-subtree/description?_from=ladder&&fromId=1

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: the root of binary tree
    @return: the root of the minimum subtree
    """
    def findSubtree(self, root):
        minimum, subtree, sum = self.helper(root)
        return subtree
        
        
        
    def helper(self,root):
        if root is None:
            return sys.maxsize,None,0
            
        left_minimum,left_subtree,left_sum = self.helper(root.left)
        right_minmum,right_subtree,right_sum = self.helper(root.right)
        
        
        sum = left_sum + right_sum + root.val
        if left_minimum == min(left_minimum,right_minmum,sum):
            return left_minimum,left_subtree,sum
        if right_minmum == min(left_minimum,right_minmum,sum):
            return right_minmum,right_subtree,sum
            
        return sum,root,sum
        
