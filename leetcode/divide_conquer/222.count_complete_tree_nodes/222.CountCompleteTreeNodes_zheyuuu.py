# Source : https://leetcode.com/problems/count-complete-tree-nodes
# Author : zheyuuu
# Date   : 2020-07-27

##################################################################################################### 
#
# Given a complete binary tree, count the number of nodes.
# 
# Note: 
# 
# Definition of a complete binary tree from Wikipedia:
# In a complete binary tree every level, except possibly the last, is completely filled, and all 
# nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive 
# at the last level h.
# 
# Example:
# 
# Input: 
#     1
#    / \
#   2   3
#  / \  /
# 4  5 6
# 
# Output: 6
#####################################################################################################

class Solution:
    # T(n) = T(n/2) + f(n), where f(n) = logn
    # f(n) = θ(n^0·logn)  => T(n) = n^0·(logn)^2
    def countNodes(self, root: TreeNode) -> int:
        if not root:
            return 0
        l = root.left
        r = root.right
        hl,hr = 1,1
        while(l):
            l = l.left
            hl +=1
        while(r):
            r = r.right
            hr +=1
        if(hr==hl):
            return pow(2, hl)-1
        else:
            return self.countNodes(root.left)+self.countNodes(root.right)+1
            