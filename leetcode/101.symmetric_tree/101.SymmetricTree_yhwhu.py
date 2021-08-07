# Source : https://leetcode.com/problems/symmetric-tree/
# Author : yhwhu
# Date   : 2020-07-30

##################################################################################################### 
#
# Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
# 
# For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
# 
#     1
#    / \
#   2   2
#  / \ / \
# 3  4 4  3
# 
# But the following [1,2,2,null,3,null,3] is not:
# 
#     1
#    / \
#   2   2
#    \   \
#    3    3
# 
# Follow up: Solve it both recursively and iteratively.
#####################################################################################################


class Solution:

    def isSymmetric_iter(self, root) -> bool:
        if not root:
            return True
        if not root.left and not root.right:
            return True
        queue = [(root.left, root.right)]
        while queue:
            left, right = queue.pop(0)
            if not left and not right:
                continue
            if not left or not right:
                return False
            if left.val != right.val:
                return False
            queue.append((left.left, right.right))
            queue.append((left.right, right.left))
        return True

    def isSymmetric_recursion(self, root):
        if not root:
            return True
        return self._bfs(root.left, root.right)

    def _bfs(self, node1, node2):
        if not node1 and not node2:
            return True
        if not node1 or not node2:
            return False
        if node1.val != node2.val:
            return False
        return self._bfs(node1.left, node2.right) and self._bfs(node1.right, node2.left)